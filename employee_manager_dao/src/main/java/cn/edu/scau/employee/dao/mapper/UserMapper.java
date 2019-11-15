package cn.edu.scau.employee.dao.mapper;

import cn.edu.scau.employee.common.entity.User;

/**
 * 用户数据库接口
 *
 * @author chen
 * @date 2019/11/11
 */
public interface UserMapper {
    /**
     * 添加用户
     *
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 更新用户
     *
     * @param record
     * @return
     */
    int updateById(User record);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User selectById(Integer id);

    /**
     * 根据用户名查询
     *
     * @param username
     * @return
     */
    User selectByUsername(String username);

}
