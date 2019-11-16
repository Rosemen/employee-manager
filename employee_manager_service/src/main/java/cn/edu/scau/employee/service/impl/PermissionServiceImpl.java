package cn.edu.scau.employee.service.impl;

import cn.edu.scau.employee.common.entity.Permission;
import cn.edu.scau.employee.common.entity.PermissionRole;
import cn.edu.scau.employee.dao.mapper.PermissionMapper;
import cn.edu.scau.employee.dao.mapper.PermissionRoleMapper;
import cn.edu.scau.employee.interfaces.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen.jiale
 * @date 2019/11/16 11:04
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private PermissionRoleMapper permissionRoleMapper;

    @Override
    public List<Permission> findByRoleId(Integer roleId) {
        List<PermissionRole> permissionRoles = permissionRoleMapper.selectByRoleId(roleId);
        List<Permission> permissions = new ArrayList<>();
        permissionRoles.forEach(permissionRole -> {
            Permission permission = permissionMapper.selectById(permissionRole.getPermissionId());
            permissions.add(permission);
        });
        return permissions;
    }
}
