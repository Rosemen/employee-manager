package cn.edu.scau.employee.interfaces.service;

import cn.edu.scau.employee.common.entity.Permission;

import java.util.List;


/**
 * 权限业务接口
 *
 * @author chen.jiale
 * @date 2019/11/16 11:02
 */
public interface PermissionService {
    /**
     * 查询权限
     *
     * @param roleId
     * @return
     */
    List<Permission> findByRoleId(Integer roleId);
}
