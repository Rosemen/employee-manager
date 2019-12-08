package cn.edu.scau.employee.common.dto;

import cn.edu.scau.employee.common.constant.PageConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户查询Dto
 *
 * @author chen.jiale
 * @date 2019/11/28 22:53
 */
@Data
@ApiModel(value = "UserQueryDto", description = "用户查询Dto")
public class UserQueryDto implements Serializable {

    private static final long serialVersionUID = -4014849406042350812L;

    @ApiModelProperty(value = "工号")
    private String username;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "分页信息")
    private PageConstant pageConstant = new PageConstant();
}
