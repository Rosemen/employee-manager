package cn.edu.scau.employee.interfaces.service;

import cn.edu.scau.employee.common.entity.dto.UserDto;
import cn.edu.scau.employee.common.result.CommonResult;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 用户业务接口
 *
 * @author chen.jiale
 * @date 2019/11/10 16:55
 */
public interface UserService {
    /**
     * 登录
     *
     * @param userDto
     * @return
     */
    CommonResult login(UserDto userDto);

    /**
     * 登出
     *
     * @param token
     * @return
     */
    CommonResult logout(String token);

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    CommonResult findByUserName(String username);

    /**
     * 导入用户excel文件
     *
     * @param bytes
     * @return
     */
    CommonResult importExcel(byte[] bytes);

    /**
     * 导出用户excel文件
     *
     * @param fileName
     * @return
     */
    CommonResult exportExcel(String fileName) throws Exception;
}
