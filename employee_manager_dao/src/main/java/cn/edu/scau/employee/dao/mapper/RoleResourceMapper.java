package cn.edu.scau.employee.dao.mapper;

import cn.edu.scau.employee.common.entity.RoleResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色资源Mapper
 *
 * @author chen
 * @date 2019/11/20
 */
public interface RoleResourceMapper {
    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insert(RoleResource record);

    /**
     * 删除
     *
     * @param roleId
     * @param resourceId
     * @return
     */
    int deleteById(@Param("roleId") Integer roleId,
                   @Param("resourceId") Integer resourceId);

    /**
     * 修改
     *
     * @param record
     * @return
     */
    int updateById(RoleResource record);

    /**
     * 查询
     *
     * @param roleId
     * @return
     */
    List<RoleResource> selectByRoleId(@Param("roleId") Integer roleId);
}