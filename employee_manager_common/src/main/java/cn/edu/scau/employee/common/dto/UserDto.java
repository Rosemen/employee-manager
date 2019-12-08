package cn.edu.scau.employee.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 服务层用户数据实体
 *
 * @author chen.jiale
 * @date 2019/11/11 14:52
 */
@Data
@ApiModel(value = "UserDto",description = "用户请求数据实体类")
public class UserDto implements Serializable {
    private static final long serialVersionUID = -2856726201700507489L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;
}
