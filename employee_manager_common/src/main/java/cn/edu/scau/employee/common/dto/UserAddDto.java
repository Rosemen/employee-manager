package cn.edu.scau.employee.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户添加Dto
 *
 * @author chen.jiale
 * @date 2019/11/20 16:27
 */
@Data
@ApiModel(value = "UserAddDto",description = "用户添加Dto")
public class UserAddDto implements Serializable {
    private static final long serialVersionUID = -8986727932888350648L;

    @ApiModelProperty(value = "工号")
    private String username;

    @ApiModelProperty(value = "真实姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    @ApiModelProperty(value = "出生日期")
    private Date birthday;

    @ApiModelProperty(value = "入职日期")
    private Date hiredate;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "住址")
    private String address;

    @ApiModelProperty(value = "部门")
    private String dept;

    @ApiModelProperty(value = "照片")
    private String photo;

    @ApiModelProperty(value = "角色id")
    private Integer roleId;
}
