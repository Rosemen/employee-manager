package cn.edu.scau.employee.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色资源关联类
 *
 * @author chen
 * @date 2019/11/20
 *
 */
@Data
public class RoleResource implements Serializable {
    private static final long serialVersionUID = 1378593357107497251L;

    private Integer roleId;

    private Integer resourceId;

    private Date createTime;

    private Date updateTime;

    private String remark;
}