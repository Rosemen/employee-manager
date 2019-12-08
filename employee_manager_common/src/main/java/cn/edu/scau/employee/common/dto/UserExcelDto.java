package cn.edu.scau.employee.common.dto;

import cn.edu.scau.employee.common.constant.GenderConverter;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.util.DateUtils;
import lombok.Data;

import java.io.Serializable;

/**
 * 对应excel表数据的dto
 *
 * @author chen.jiale
 * @date 2019/11/16 16:58
 */
@Data
public class UserExcelDto implements Serializable {

    @ExcelIgnore
    private static final long serialVersionUID = -5186327627795432750L;

    @ExcelProperty(index = 0,value = "工号")
    private String username;

    @ExcelProperty(index = 1,value = "姓名")
    private String name;

    @ExcelProperty(index = 2,value = "性别",converter = GenderConverter.class)
    private Integer gender;

    @ExcelProperty(index = 3,value = "出生日期")
    @DateTimeFormat(value = DateUtils.DATE_FORMAT_19)
    private String birthday;

    @ExcelProperty(index = 4,value = "入职日期")
    @DateTimeFormat(value = DateUtils.DATE_FORMAT_19)
    private String hiredate;

    @ExcelProperty(index = 5,value = "手机号")
    private String phone;

    @ExcelProperty(index = 6,value = "邮箱")
    private String email;

    @ExcelProperty(index = 7,value = "住址")
    private String address;

    @ExcelProperty(index = 8,value = "部门")
    private String dept;

    @ExcelProperty(index = 9,value = "学历")
    private String education;
}
