package com.lflong.steel.info.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lflong.steel.info.entity.SumInfo;
import com.lflong.steel.info.entity.vo.SumInfoQueryVo;
import com.lflong.steel.info.mapper.ISumInfoMapper;
import com.lflong.steel.info.service.ISumService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SumServiceImpl extends ServiceImpl<ISumInfoMapper, SumInfo> implements ISumService {

    @Override
    public IPage<SumInfo> selectPage(Page<SumInfo> pageParam, SumInfoQueryVo sumInfoQueryVo) {

        //显示分页查询列表
        QueryWrapper<SumInfo> queryWrapper = new QueryWrapper<>();

        //若无查询信息，直接返回分页结果
        if(sumInfoQueryVo == null){
            return baseMapper.selectPage(pageParam, queryWrapper);
        }

        //条件查询
        //获取要匹配的信息
        String number = sumInfoQueryVo.getNumber();
        String type = sumInfoQueryVo.getType();
        String joinDateBegin = sumInfoQueryVo.getJoinDateBegin();
        String joinDateEnd = sumInfoQueryVo.getJoinDateEnd();

        //判断信息是否为空，如不为空进行匹配
        //1. 若编号不为空则做相似查询
        if(!StringUtils.isEmpty(number)){
            queryWrapper.likeRight("number", number);
        }

        //2. 若型号不为空，做型号匹配查询
        if(type != null){
            queryWrapper.eq("type", type);
        }

        //3. 生产日期不为空
        if(!StringUtils.isEmpty(joinDateBegin)){
            queryWrapper.ge("join_date", joinDateBegin);
        }

        //4. 截止日期不为空
        if(!StringUtils.isEmpty(joinDateEnd)){
            queryWrapper.le("join_date", joinDateEnd);
        }

        //返回最终结果
        return baseMapper.selectPage(pageParam, queryWrapper);
    }
}
