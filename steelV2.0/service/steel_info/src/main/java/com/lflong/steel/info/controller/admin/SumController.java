package com.lflong.steel.info.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lflong.steel.common.base.result.R;
import com.lflong.steel.info.entity.SumInfo;
import com.lflong.steel.info.entity.vo.SumInfoQueryVo;
import com.lflong.steel.info.service.ISumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin //允许跨域
@Api(description = "型钢信息查询")
@RestController
@RequestMapping("/admin/steel/sum")
@Slf4j
public class SumController {

    @Autowired
    private ISumService sumService;

    /**
     *查询所有型钢信息
     * @return
     */
    @ApiOperation("查询所有型钢信息")
    @GetMapping("list")
    public R listAll(){
        List<SumInfo> list = sumService.list();
        return R.ok().data("items", list);
    }

    /**
     * 型钢分页列表查询
     * @param page      查询第几页
     * @param limit     每页显示条数
     * @return
     */
    @ApiOperation("型钢分页列表")
    @GetMapping("list/{page}/{limit}")
    public R listPage(@ApiParam(value = "当前页码", required = true) @PathVariable Long page,
                      @ApiParam(value = "每页记录数", required = true) @PathVariable Long limit,
                      @ApiParam("型钢信息列表查询对象") SumInfoQueryVo sumInfoQueryVo){

        Page<SumInfo> pageParam = new Page<>(page, limit);
        IPage<SumInfo> pageModel = sumService.selectPage(pageParam, sumInfoQueryVo);
        List<SumInfo> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return R.ok().data("total", total).data("rows", records);
    }

    /**
     * 根据ID删除型钢
     * @param id    待删除型钢ID
     * @return
     */
    @ApiOperation(value = "根据ID删除型钢", notes = "根据ID删除型钢，逻辑删除")
    @DeleteMapping("remove/{id}")
    public R removeById(@ApiParam(value = "讲师ID", required = true) @PathVariable String id){

        //删除型钢
        boolean result = sumService.removeById(id);

        if(result){
            return R.ok().message("删除成功");
        }else{
            return R.error().message("数据不存在");
        }
    }
}
