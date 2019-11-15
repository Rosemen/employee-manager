package cn.edu.scau.employee.common.utils;

import org.springframework.util.DigestUtils;

/**
 * token生成工具
 *
 * @author chen.jiale
 * @date 2019/11/12 10:42
 */
public class TokenUtil {

    /**
     * 根据用户名生成token
     *
     * @param username
     * @return
     */
    public static String generateToken(String username){
        String tokenStr = username + System.currentTimeMillis();
        return DigestUtils.md5DigestAsHex(tokenStr.getBytes());
    }
}
