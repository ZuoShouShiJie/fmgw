package com.dzjk.qzgw.core.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by daixiaohu on 2018/4/18.
 */
public final class CommonUtil {
    private static final Logger logger = LoggerFactory.getLogger(CommonUtil.class);

    public CommonUtil() {
    }
    /**
     * 获取利用反射获取类里面的值和名称
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        System.out.println(clazz);
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            if (value!=null&&value!=""){
                map.put(fieldName, value);
            }
        }
        return map;
    }
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}