package com.lflong.steel.info.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lflong.steel.info.entity.ImgInfo;
import com.lflong.steel.info.mapper.IImageInfoMapper;
import com.lflong.steel.info.service.IImgService;
import org.springframework.stereotype.Service;

@Service
public class ImgServiceImpl extends ServiceImpl<IImageInfoMapper, ImgInfo> implements IImgService {
}
