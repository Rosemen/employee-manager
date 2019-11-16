package cn.edu.scau.employee.dao.mapper;

import cn.edu.scau.employee.common.entity.Permission;

/**
 * 权限Mapper
 *
 * @author chen
 * @date 2019/11/16
 */
public interface PermissionMapper {
    /**
     * 添加权限
     *
     * @param record
     * @return
     */
    int insert(Permission record);

    /**
     * 删除权限
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 修改权限
     *
     * @param record
     * @return
     */
    int updateById(Permission record);

    /**
     * 查询权限
     *
     * @param id
     * @return
     */
    Permission selectById(Integer id);
}