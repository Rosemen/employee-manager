package cn.edu.scau.employee.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 资源实体类
 *
 * @author chen
 * @date 2019/11/20
 */
@Data
public class Resource implements Serializable {
    private static final long serialVersionUID = -8105455923461590148L;

    private Integer id;

    private String menuName;

    private String url;

    private Integer parentId;

    private Date createDate;

    private Date updateDate;

    private String remark;
}