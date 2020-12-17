package other;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by HAOYUXING on 2020/12/14.
 *
 */
public class Reflect {

    public void reflectClass() throws Exception {
        Class<? extends Function> function = null;
        Function instance;
        //if (ClassUtils.isInnerClass(function)) {  // 工具类

        // 内部类分情况讨论
        if (isInnerClass(function)) {
            int modifiers = function.getModifiers();

            // public static class
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                instance = function.newInstance();
            }
            // private static class
            else if (Modifier.isStatic(modifiers)) {
                Constructor<? extends Function> innerConstructor = function.getDeclaredConstructor();
                innerConstructor.setAccessible(true);
                instance = innerConstructor.newInstance();
            }
            // private class
            else {
                Object clazz = function.getEnclosingClass().getDeclaredConstructor().newInstance();
                Constructor<?> constructor = function.getDeclaredConstructors()[0];
                constructor.setAccessible(true);
                instance = (Function) constructor.newInstance(clazz);
            }
        }
        // 外部类直接创建实例
        else {
            instance = function.newInstance();
        }

        //-=-=-=-=-=-=-=-=-=

        // 对象
        Object bean = null;
        // 对象的字段
        Field field = null;
        field.setAccessible(true);
        // 字段的类型
        Class<?> type = field.getType();

        if (type == List.class) {
            ParameterizedType genericType = (ParameterizedType) field.getGenericType();
            Class typeArgument = (Class) genericType.getActualTypeArguments()[0];
            List list = parseToList("", typeArgument);
            field.set(bean, list);
            return;
        }
        if (type == Map.class) {
            ParameterizedType genericType = (ParameterizedType) field.getGenericType();
            Class keyClass = (Class) genericType.getActualTypeArguments()[0];
            Class valueClass = (Class) genericType.getActualTypeArguments()[1];
            Map map = parseToMap("", keyClass, valueClass);
            field.set(bean, map);
            return;
        }
    }

    // 工具类的实现
    public static boolean isInnerClass(final Class<?> cls) {
        return cls != null && cls.getEnclosingClass() != null;
    }

    private <T> List<T> parseToList(String json, Class<T> type) {
        //return JSON.parseObject(json, new TypeReference<List<T>>(type) {
        //});
        return null;
    }

    private <K, V> Map<K, V> parseToMap(String json, Class<K> keyType, Class<V> valueType) {
        //return JSON.parseObject(json, new TypeReference<Map<K, V>>(keyType, valueType) {
        //});
        return null;
    }


}
