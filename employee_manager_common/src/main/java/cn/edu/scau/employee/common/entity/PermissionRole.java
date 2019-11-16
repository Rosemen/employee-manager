package cn.edu.scau.employee.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限角色关联类
 *
 * @author chen
 * @date 2019/11/16
 */
@Data
public class PermissionRole implements Serializable {
    private static final long serialVersionUID = 4404598904142151458L;

    private Integer roleId;

    private Integer permissionId;

    private Date createDate;

    private String remark;
}