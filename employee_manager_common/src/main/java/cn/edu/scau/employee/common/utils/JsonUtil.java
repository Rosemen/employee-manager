package cn.edu.scau.employee.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * json工具
 *
 * @author chen.jiale
 * @date 2019/11/15 15:27
 */
public class JsonUtil {

    /**
     * 对象转换成json
     *
     * @param obj
     * @return
     */
    public static String convertToJson(Object obj){
        String json = JSON.toJSONString(obj);
        return json;
    }

    public static Object convertToObj(String json,Class clazz){
        JSONObject jsonObject = JSON.parseObject(json);
        Object object = JSON.toJavaObject(jsonObject, clazz);
        return object;
    }
}
