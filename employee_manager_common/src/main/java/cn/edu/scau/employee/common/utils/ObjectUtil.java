package cn.edu.scau.employee.common.utils;

import java.util.Optional;

/**
 * @Description 对象工具
 * @author chen.jiale
 * @date 2019/12/15 10:26
 */
public class ObjectUtil {
    public static boolean isEmpty(Object object){
        Optional<?> optional = Optional.ofNullable(object);
        if (optional.isPresent()){
            return false;
        }else {
            return true;
        }
    }
}
