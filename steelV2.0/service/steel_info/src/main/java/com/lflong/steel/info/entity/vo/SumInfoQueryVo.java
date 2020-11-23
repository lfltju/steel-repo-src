package com.lflong.steel.info.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("SumInfo查询对象")
@Data
public class SumInfoQueryVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "型钢编号")
    private String number;

    @ApiModelProperty(value = "型钢型号")
    private String type;

    @ApiModelProperty(value = "型钢长度")
    private int length;

    @ApiModelProperty(value = "采集开始时间")
    private String joinDateBegin;

    @ApiModelProperty(value = "采集结束时间")
    private String joinDateEnd;
}
