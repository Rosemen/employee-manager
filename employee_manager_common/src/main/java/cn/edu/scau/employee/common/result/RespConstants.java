package cn.edu.scau.employee.common.result;

/**
 * 响应常量类
 *
 * @author chen.jiale
 * @date 2019/11/11 16:38
 */
public class RespConstants {
    /**
     * 成功状态码
     */
    public static final int SUCCESS = 200;

    /**
     * 请求不允许状态码
     */
    public static final int FORBIDDEN = 403;

    /**
     * 失败状态码
     */
    public static final int ERROR = 500;

    /**
     * 成功提示
     */
    public static final String SUCCESS_MSG = "请求成功";

    /**
     * 错误提示
     */
    public static final String ERROR_MSG = "服务器异常";

    /**
     * 登录失败提示信息
     */
    public static final String LOGIN_FAILURE = "用户名或密码错误";

    /**
     * 未登录提示信息
     */
    public static final String NOT_LOGIN = "暂未登录";

    /**
     * 响应编码
     */
    public static final String CHARACTER_ENCODING = "UTF-8";

    /**
     * 响应类型
     */
    public static final String CONTENT_TYPE = "application/json";

    /**
     * 没有权限
     */
    public static final String NO_PERMISSION = "没有权限访问";
}
