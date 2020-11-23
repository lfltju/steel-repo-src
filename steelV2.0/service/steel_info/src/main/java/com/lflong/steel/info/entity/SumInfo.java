package com.lflong.steel.info.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("sum_info")
@ApiModel(value = "型钢信息汇总", description = "型钢信息汇总")
public class SumInfo {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "型钢ID")
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @ApiModelProperty(value = "型钢编号", example = "202011231")
    private String number;

    @ApiModelProperty(value = "型钢型号", example = "600*300")
    private String type;

    @ApiModelProperty(value = "型钢开口度，默认合格")
    private String opening;

    @ApiModelProperty(value = "型钢通条B值，默认合格")
    @TableField(value = "bvalue")
    private String bValue;

    @ApiModelProperty(value = "型钢缺陷个数，默认为0")
    private int defects;

    @ApiModelProperty(value = "型钢长度，默认为0", example = "72")
    private int length;

    @ApiModelProperty(value = "生产时间(粗略)", example = "2020-01-01")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date joinDate;

    @ApiModelProperty(value = "生产时间(详细)")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;
}
