package cn.edu.scau.employee.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author chen.jiale
 * @date  2019/12/03
 */
@Data
public class Department implements Serializable {
    private static final long serialVersionUID = -1634346253211324448L;

    private Integer id;

    private String name;
}