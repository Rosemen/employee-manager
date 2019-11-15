package cn.edu.scau.employee.common.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chen.jiale
 * @date 2019/11/12 10:50
 */
@Data
@ApiModel(value = "UserResultDto",description = "用户结果Dto")
public class UserResultDto  implements Serializable {
    private static final long serialVersionUID = 1425153206510524599L;

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "真实姓名")
    private String name;
}
