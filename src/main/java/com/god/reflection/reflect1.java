package com.god.reflection;

import com.god.pojo.Student;
import com.god.pojo.User;
import com.god.pojo.UserService;
import org.junit.Test;

import javax.annotation.Resources;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Properties;
import java.util.ResourceBundle;

public class reflect1 {

    @Test
    public void test(){
        Class c1=null;
        try {
            c1=Class.forName("java.lang.String");
            System.out.println(c1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        String s="abc";
        Class x = s.getClass();
        System.out.println(x==c1);
    }

    @Test
    public  void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        User user = new User();

        Class<User> userClass = User.class;
        Class<? extends User> aClass = user.getClass();
        Class<?> user1 = Class.forName("com.god.pojo.User");

        User user2 = userClass.newInstance();

        FileReader fileReader = new FileReader("src/main/resources/classInfo.properties");

        Properties properties = new Properties();
        properties.load(fileReader);
        fileReader.close();
        String className = properties.getProperty("className");
        //从文件里获得类名
        System.out.println(className);
    }

    @Test
    public  void getPath(){
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        String path = contextClassLoader.getResource("classInfo.properties").getPath();
        System.out.println(path);
        //得到的是——>/D:/IDEAProject/javaSe/target/classes/classInfo.properties
        //从os的根路径/开始算起

        InputStream resourceAsStream = contextClassLoader.getResourceAsStream("classInfo.properties");
        System.out.println(resourceAsStream.toString());


    }

    //资源定位器
    @Test
    public  void getResourceBundle(){

        ResourceBundle resourceBundle = ResourceBundle.getBundle("classInfo");
        String className = resourceBundle.getString("className");
        System.out.println(className);
    }

    @Test
    public  void field() throws ClassNotFoundException {
        Class<?> studentClass = Class.forName("com.god.pojo.Student");
        Field[] fields = studentClass.getFields();
        System.out.println(fields.length);
        Field field = fields[0];
        String name = field.getName();
        System.out.println(field);
        //public int com.god.pojo.Student.no
        //说明只能反射只能得到public的属性


        //简类名
        String simpleName = studentClass.getSimpleName();
        System.out.println(simpleName);
        //Student
    }

    @Test
    public void type() throws ClassNotFoundException, IllegalAccessException {
        Class<?> studentClass = Class.forName("com.god.pojo.Student");
        Field[] declaredFields = studentClass.getDeclaredFields();
        //getDeclaredFields:得到已经宣布的字段
        //获取全部属性
        for (Field declaredField : declaredFields) {
            System.out.print(declaredField.getName()+"  ");
            Class<?> type = declaredField.getType();
            System.out.print(type.getSimpleName()+ "  ");
            int i = declaredField.getModifiers();
            System.out.println(i);
            String modifier = Modifier.toString(i);
            System.out.println(modifier);
            System.out.println("__________________________");

        }
    }

    @Test
    public void a() throws ClassNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        Class<?> studentClass = Class.forName("com.god.pojo.Student");
        String modifier = Modifier.toString(studentClass.getModifiers());
        String classSimpleName = studentClass.getSimpleName();
        StringBuilder s = stringBuilder.append(modifier + "  class  " + classSimpleName+"{\n ");
        Field[] dfs = studentClass.getDeclaredFields();
        for (Field field : dfs) {
            s.append("\t");
            s.append(Modifier.toString(field.getModifiers()));
            s.append(" ");
            s.append(field.getType().getSimpleName());
            s.append(" ");
            s.append(field.getName());
            s.append(";\n");
        }
        s.append("}");
        System.out.println(s);

    }

    @Test
    public void fieldValue() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        //正常给属性赋值
        Student student = new Student();
        student.no=1;

        //反射给属性赋值
        Class<?> studentClass = Class.forName("com.god.pojo.Student");
        Field noField = studentClass.getField("no");
        Object obj = studentClass.newInstance();
        noField.set(obj,111);
        System.out.println(noField.get(obj));

        Field nameField = studentClass.getDeclaredField("name");
        //System.out.println(nameField.get(obj));//此时不可以访问private

        nameField.setAccessible(true);//让私有属性可以访问
        nameField.set(obj,"zs");
        System.out.println(nameField.get(obj));//此时可以访问private




    }

   /* public static void main(String[] args) {

        m();
        m(10);
        m2(10,"qq");
        m3("zxc");

    }*/
    public static  void m(int... args){
        System.out.println("m方法执行了");
    }

    public static  void m2(int a,String... args){

    }

    public static void m3(String... args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }

    @Test
    public void revoke() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> userService = Class.forName("com.god.pojo.UserService");
        Object o = userService.newInstance();
        Method login = userService.getDeclaredMethod("login", String.class, String.class);
        Object retValue = login.invoke(o,"admin","123");//invoke:调用
        System.out.println(retValue);

        Class<?> stringClass = Class.forName("java.lang.String");
        Class<?> superclass = stringClass.getSuperclass();
        System.out.println(superclass.getSimpleName());

        Class<?>[] interfaces = stringClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(interfaces.getClass());
        }

    }


}


