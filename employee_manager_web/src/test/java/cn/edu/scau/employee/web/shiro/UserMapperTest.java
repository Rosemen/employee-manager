package cn.edu.scau.employee.web.shiro;

import cn.edu.scau.employee.common.entity.User;
import cn.edu.scau.employee.dao.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chen.jiale
 * @date 2019/11/11 16:28
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads(){
//        User user = userMapper.selectById(1);
        User user = userMapper.selectByUsername("201911110001");
        System.out.println(user);
    }
}
