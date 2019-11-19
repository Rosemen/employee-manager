package cn.edu.scau.employee.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 加密工具
 *
 * @author chen.jiale
 * @date 2019/11/18 12:53
 */
public class EncryptUtil {
    public static final String ALGORITHM = "md5";

    public static final int INTERATION = 1024;

    public static String getEncryptedPassword(String password){
        ByteSource salt = ByteSource.Util.bytes(password);
        return new SimpleHash(ALGORITHM,password,salt,INTERATION).toHex();
    }
}
