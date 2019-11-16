package cn.edu.scau.employee.dao.mapper;

import cn.edu.scau.employee.common.entity.PermissionRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限角色关联Mapper
 *
 * @author chen
 * @date 2019/11/16
 */
public interface PermissionRoleMapper {
    /**
     * 插入权限角色关联记录
     *
     * @param record
     * @return
     */
    int insert(PermissionRole record);

    /**
     * 根据id删除关联记录
     *
     * @param roleId
     * @param permissionId
     * @return
     */
    int deleteById(@Param("roleId") Integer roleId,
                   @Param("permissionId")Integer permissionId);

    /**
     * 根据id更新记录
     *
     * @param record
     * @return
     */
    int updateById(PermissionRole record);

    /**
     * 根据角色id查询
     *
     * @param roleId
     * @return
     */
    List<PermissionRole> selectByRoleId(@Param("roleId") Integer roleId);
}