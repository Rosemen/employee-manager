package cn.edu.scau.employee.common.utils;

import com.alibaba.fastjson.JSON;

/**
 * json工具
 *
 * @author chen.jiale
 * @date 2019/11/15 15:27
 */
public class JsonUtil {

    public static String convertToJson(Object obj){
        String json = JSON.toJSONString(obj);
        return json;
    }
}
