package cn.edu.scau.employee.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author chen
 * @date 2019/11/11
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 4329580237446386215L;

    private Integer id;

    private String username;

    private String name;

    private Integer gender;

    private String password;

    private Date birthday;

    private Date hiredate;

    private String phone;

    private String email;

    private String address;

    private String dept;

    private String photo;

    private String education;

    private Integer roleId;
}