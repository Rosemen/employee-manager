package cn.edu.scau.employee.web.shiro;

import cn.edu.scau.employee.common.entity.Permission;
import cn.edu.scau.employee.common.entity.PermissionRole;
import cn.edu.scau.employee.common.entity.Role;
import cn.edu.scau.employee.common.entity.User;
import cn.edu.scau.employee.dao.mapper.PermissionMapper;
import cn.edu.scau.employee.dao.mapper.PermissionRoleMapper;
import cn.edu.scau.employee.dao.mapper.RoleMapper;
import cn.edu.scau.employee.dao.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author chen.jiale
 * @date 2019/11/16 9:42
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MapperTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private PermissionRoleMapper permissionRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void contextLoads() {
//       testUserMapper();
//        testPermissionMapper();
//        testPermissionRoleMapper();
        testRoleMapper();
    }

    private void testUserMapper() {
//        User user = userMapper.selectById(1);
        User user = userMapper.selectByUsername("201911110001");
        System.out.println(user);
    }

    private void testPermissionMapper(){
        Permission permission =
                permissionMapper.selectById(1);
        System.out.println(permission.toString());
    }

    private void testPermissionRoleMapper(){
        List<PermissionRole> permissionRoles = permissionRoleMapper.selectByRoleId(1);
        permissionRoles.forEach(permissionRole -> {
            System.out.println(permissionRole.toString());
        });
    }

    private void testRoleMapper(){
        Role role = roleMapper.selectById(1);
        System.out.println(role.toString());
    }
}
