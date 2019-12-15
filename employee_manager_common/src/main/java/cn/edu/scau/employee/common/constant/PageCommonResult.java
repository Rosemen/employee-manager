package cn.edu.scau.employee.common.constant;

import lombok.Data;

/**
 * 分页结果
 *
 * @author chen.jiale
 * @date 2019/11/29 10:24
 */
@Data
public class PageCommonResult extends CommonResult {
    /**
     * 总记录数
     */
    private int total;

    public static CommonResult success(int total, Object data) {
        PageCommonResult result = new PageCommonResult();
        result.setStatus(HttpConstants.SUCCESS);
        result.setMsg(HttpConstants.SUCCESS_MSG);
        result.setTotal(total);
        result.setData(data);
        return result;
    }
}
