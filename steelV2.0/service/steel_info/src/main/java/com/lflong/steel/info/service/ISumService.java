package com.lflong.steel.info.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lflong.steel.info.entity.SumInfo;
import com.lflong.steel.info.entity.vo.SumInfoQueryVo;

public interface ISumService extends IService<SumInfo> {

    IPage<SumInfo> selectPage(Page<SumInfo> pageParam, SumInfoQueryVo sumInfoQueryVo);
}
