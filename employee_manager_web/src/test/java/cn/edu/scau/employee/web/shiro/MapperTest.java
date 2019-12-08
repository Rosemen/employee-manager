//package cn.edu.scau.employee.web.shiro;
//
//import cn.edu.scau.employee.common.dto.UserQueryDto;
//import cn.edu.scau.employee.common.entity.Department;
//import cn.edu.scau.employee.common.entity.Role;
//import cn.edu.scau.employee.common.entity.User;
//import cn.edu.scau.employee.dao.mapper.DepartmentMapper;
//import cn.edu.scau.employee.dao.mapper.RoleMapper;
//import cn.edu.scau.employee.dao.mapper.UserMapper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @author chen.jiale
// * @date 2019/11/16 9:42
// */
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class MapperTest {
//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private RoleMapper roleMapper;
//
//    @Autowired
//    private DepartmentMapper departmentMapper;
//
//    @Test
//    public void contextLoads() {
////       testUserMapper();
////        testPermissionMapper();
////        testPermissionRoleMapper();
////        testRoleMapper();
//        testDepartmentMapper();
//    }
//
//    private void testUserMapper() {
////        User user = userMapper.selectById(1);
////        User user = userMapper.selectByUsername("201911110001");
////        System.out.println(user);
//        UserQueryDto userQueryDto = new UserQueryDto();
//        List<User> users = userMapper.selectByCondition(userQueryDto);
//        System.out.println(Arrays.toString(users.toArray()));
//    }
//
//    private void testRoleMapper(){
//        Role role = roleMapper.selectById(1);
//        System.out.println(role.toString());
//    }
//
//    private void testDepartmentMapper(){
//        Department department = departmentMapper.selectById(1);
//        System.out.println(department);
//    }
//}
