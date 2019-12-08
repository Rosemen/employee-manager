package cn.edu.scau.employee.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户响应Dto
 *
 * @author chen.jiale
 * @date 2019/11/12 10:50
 */
@Data
@ApiModel(value = "UserResultDto",description = "用户结果Dto")
public class UserResultDto  implements Serializable {
    private static final long serialVersionUID = 1425153206510524599L;

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "工号")
    private String username;

    @ApiModelProperty(value = "真实姓名")
    private String name;

    @ApiModelProperty(value = "角色")
    private String role;

    @ApiModelProperty(value = "部门")
    private String dept;
}
