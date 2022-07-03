package com.god.pojo;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class UserService {

    public  Boolean  login(String name,String password){
        if ("admin".equals(name)&& "123".equals(password)){
            return true;
        }
        return false;
    }

    public void logout(){
        System.out.println("系统已经安全退出");
    }

/*
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> userServiceClass = Class.forName("com.god.pojo.UserService");
        Method[] methods = userServiceClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(Modifier.toString(method.getModifiers()));
            System.out.println(method.getReturnType().getSimpleName());
            System.out.println(method.getName());
            System.out.println("-------------");
        }
    }
*/
    public static void main(String[] args) throws ClassNotFoundException {
        StringBuilder sb = new StringBuilder();
        Class<?> userServiceClass = Class.forName("com.god.pojo.UserService");
        sb.append(Modifier.toString(userServiceClass.getModifiers())+" class "+userServiceClass.getSimpleName()+"{\n");
        Method[] methods = userServiceClass.getDeclaredMethods();
        for (Method method : methods) {
            sb.append("\t");
            sb.append(Modifier.toString(method.getModifiers()));
            sb.append(" ");
            sb.append(method.getReturnType().getSimpleName());
            sb.append(" ");
            sb.append(method.getName());
            sb.append("(");

            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                sb.append(parameterType.getSimpleName());
                sb.append(",");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("){}\n");
        }
        sb.append("}");
        System.out.println(sb);


    }



}
