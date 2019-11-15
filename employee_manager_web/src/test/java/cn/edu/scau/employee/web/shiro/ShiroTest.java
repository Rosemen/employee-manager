package cn.edu.scau.employee.web.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

/**
 * @author chen.jiale
 * @date 2019/11/9 12:54
 */
public class ShiroTest {
    @Test
    public void printHashedPassword(){
        //加密方式
        String hashAlgorithmName = "MD5";
        //加密次数
        int hashInteractions = 1024;
        //盐值
        ByteSource salt = ByteSource.Util.bytes("199711070002");
        //原密码
        String pwd = "123";
        //将得到的result放到数据库中就行了。
        String result = new SimpleHash(hashAlgorithmName, pwd, salt, hashInteractions).toHex();
        System.out.println(result);

    }
}
