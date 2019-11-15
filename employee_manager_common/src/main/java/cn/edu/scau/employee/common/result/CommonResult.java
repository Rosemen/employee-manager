package cn.edu.scau.employee.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用结果实体类: 返回到前端
 *
 * @author chen.jiale
 * @date 2019/11/11 15:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult {
    /**
     * 响应状态码
     */
    private int status;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应数据
     */
    private Object data;

    public static CommonResult success() {
        CommonResult result = new CommonResult();
        result.setStatus(RespConstants.SUCCESS);
        result.setMsg(RespConstants.SUCCESS_MSG);
        return result;
    }

    public static CommonResult error(String msg) {
        CommonResult result = new CommonResult();
        result.setStatus(RespConstants.ERROR);
        result.setMsg(msg);
        return result;
    }

    public static CommonResult error(int status, String msg) {
        CommonResult result = new CommonResult();
        result.setStatus(status);
        result.setMsg(msg);
        return result;
    }
}
