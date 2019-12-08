package cn.edu.scau.employee.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色添加Dto
 *
 * @author chen.jiale
 * @date 2019/11/20 20:35
 */
@Data
@ApiModel(value = "RoleAddDto",description = "角色添加Dto")
public class RoleAddDto implements Serializable {
    @ApiModelProperty(value = "角色名")
    private String name;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "备注")
    private String remark;

    //TODO 这里之后要添加权限属性
}
