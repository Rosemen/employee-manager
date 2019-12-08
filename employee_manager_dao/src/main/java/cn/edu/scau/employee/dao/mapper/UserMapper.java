package cn.edu.scau.employee.dao.mapper;

import cn.edu.scau.employee.common.dto.UserQueryDto;
import cn.edu.scau.employee.common.entity.User;

import java.util.List;

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
     * 批量删除用户
     *
     * @param ids
     */
    void delete(List<Integer> ids);

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

    /**
     * 查询所有
     *
     * @return
     */
    List<User> selectAll();

    /**
     * 条件查询
     *
     * @param userQueryDto
     * @return
     */
    List<User> selectByCondition(UserQueryDto userQueryDto);
}
