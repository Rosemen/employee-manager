package cn.edu.scau.employee.dao.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * 处理token
 *
 * @author chen.jiale
 * @date 2019/11/15 13:20
 */
@Repository
public class TokenRepository {
    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String EMPLOYEE_TOKEN_PREFIX = "employee-manage:";

    public static final String TOKEN_HEADER_NAME = "employee-token";

    public void saveUser(String token, String userInfo) {
        redisTemplate.opsForValue().set(EMPLOYEE_TOKEN_PREFIX + token, userInfo, 30 * 60 * 1000, TimeUnit.MILLISECONDS);
    }

    public boolean checkToken(String token) {
        String value = redisTemplate.opsForValue().get(EMPLOYEE_TOKEN_PREFIX + token);
        if (null == value) {
            return false;
        }
        saveUser(token, value);
        return true;
    }

    public String getUserInfoByToken(String token) {
        String value = redisTemplate.opsForValue().get(EMPLOYEE_TOKEN_PREFIX + token);
        return value;
    }

    public void clearToken(String token){
        Boolean hasKey = redisTemplate.hasKey(EMPLOYEE_TOKEN_PREFIX + token);
        if (hasKey){
            redisTemplate.delete(EMPLOYEE_TOKEN_PREFIX + token);
        }
    }
}
