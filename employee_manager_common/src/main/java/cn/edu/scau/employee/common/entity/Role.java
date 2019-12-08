package cn.edu.scau.employee.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色实体类
 *
 * @author chen
 * @date 2019/11/16
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -1805677569883536464L;

    private Integer id;

    private String name;

    private Date createDate;

    private Date updateDate;

    private String remark;


}