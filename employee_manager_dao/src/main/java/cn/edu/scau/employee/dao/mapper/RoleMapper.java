package cn.edu.scau.employee.dao.mapper;

import cn.edu.scau.employee.common.entity.Role;

import java.util.List;

/**
 * 角色Mapper
 *
 * @author chen
 * @date 2019/11/16
 */
public interface RoleMapper {
    /**
     * 添加角色
     *
     * @param record
     * @return
     */
    int insert(Role record);

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 更新角色
     *
     * @param record
     * @return
     */
    int updateById(Role record);

    /**
     * 查询角色
     *
     * @param id
     * @return
     */
    Role selectById(Integer id);

    /**
     * 获取所有角色信息
     *
     * @return
     */
    List<Role> selectAll();
}