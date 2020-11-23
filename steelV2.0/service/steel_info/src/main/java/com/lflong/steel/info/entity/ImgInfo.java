package com.lflong.steel.info.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("img_info")
@ApiModel(value = "图片信息", description = "图片")
public class ImgInfo {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "图像ID")
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @ApiModelProperty(value = "图像所属型钢编号", example = "202011231")
    private String number;

    @ApiModelProperty(value = "图像所属平面", example = "1面")
    private String surface;

    @ApiModelProperty(value = "图像缺陷类型", example = "结疤")
    private String type;

    @ApiModelProperty(value = "缺陷位置", example = "55.56")
    private double length;

    @ApiModelProperty(value = "图像索引位置", example = "E:\\image\\202011203\\1\\Lenna1.jpg")
    private String index;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;
}
