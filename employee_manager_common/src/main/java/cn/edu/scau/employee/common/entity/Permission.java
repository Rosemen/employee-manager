package cn.edu.scau.employee.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限实体类
 *
 * @author chen
 * @date 2019/11/16
 *
 */
@Data
public class Permission implements Serializable {
    private static final long serialVersionUID = -2189621636487067915L;

    private Integer id;

    private String resourceName;

    private String resourceUrl;

    private String permissionCode;

    private String permissionName;

    private Date createDate;

    private Date updateDate;
}