package cn.edu.scau.employee.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色响应结果Dto
 *
 * @author chen.jiale
 * @date 2019/11/20 15:39
 */
@ApiModel(value = "RoleResultDto", description = "角色响应结果Dto")
@Data
public class RoleResultDto implements Serializable {
    private static final long serialVersionUID = 4435851838769504324L;

    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "角色名")
    private String name;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "备注")
    private String remark;
}
