package me.aloo.javainaction.action.keyworddriven;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by walbx on 2017/7/12.
 * 反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；
 * 这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。
 */
public class Loader {
    public static Map<String, Method> METHOD_MAP = new HashMap<>();

    public void init() throws ClassNotFoundException {
        Class<?> klass = Class.forName("me.aloo.javainaction.action.keyworddriven.ScriptMethod");
        Method[] methods = klass.getDeclaredMethods(); //klass.getMethods()只返回public方法
        for (Method method : methods) {
            method.setAccessible(true); //调用私有方法/私有变量前，都需要设置为true
            System.out.println(method.toString());
            METHOD_MAP.put(method.getName(), method);
        }
    }
}
