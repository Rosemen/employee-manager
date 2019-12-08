package cn.edu.scau.employee.interfaces.service;

import cn.edu.scau.employee.common.dto.UserAddDto;
import cn.edu.scau.employee.common.dto.UserDto;
import cn.edu.scau.employee.common.constant.CommonResult;
import cn.edu.scau.employee.common.dto.UserQueryDto;

import java.util.List;

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

    /**
     * 添加用户
     *
     * @param userAddDto
     * @return
     */
    CommonResult add(UserAddDto userAddDto);

    /**
     * 修改用户
     *
     *
     * @param id
     * @param userAddDto
     * @return
     */
    CommonResult update(Integer id, UserAddDto userAddDto);

    /**
     * 删除用户
     *
     * @param ids
     * @return
     */
    CommonResult delete(List<Integer> ids);

    /**
     * 根据id列表删除
     *
     * @param userQueryDto
     * @return
     */
    CommonResult findByCondition(UserQueryDto userQueryDto);

    /**
     * 根据token查询用户信息
     *
     * @param token
     * @return
     */
    CommonResult findByToken(String token);
}
