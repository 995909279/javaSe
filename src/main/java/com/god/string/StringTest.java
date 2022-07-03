package com.god.string;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class StringTest {
    @Test
    public void  a(){
        String s1="aaa";
        String s2="aaa";
        System.out.println(s1==s2);//true

        String s3 = new String("aaa");
        String s4 = new String("aaa");
        System.out.println(s3==s4);//false
    }

    @Test
    public  void  b(){
        String s = new String("test");
        System.out.println("test".equals(s));
        //"test"是一个对象 所以可以.方法
    }

    @Test
    public  void c(){
        String s = new String("qq");
        String s1="qq";

        byte []bytes={97,98,99};
        String s2 = new String(bytes);
        System.out.println(s2);//abc
        String s3 = new String(bytes, 1, 2);
        System.out.println(s3);//bc
        char[] chars = new char[]{'1','2','3'};
        String s4 = new String(chars,1,2);
        System.out.println(s4);//23

        char c = "我是齐天大圣孙悟空".charAt(1);
        System.out.println(c);//是

        String a="zs";
        int i = a.compareTo("zs");
        System.out.println(i);//0

        String b="za";
        int i2 = b.compareTo("zc");
        System.out.println(i2);//c=3, a=1, a-c=-2
        //a的位置-c的位置
    }

    @Test
    public  void d(){
        String a="zxcd";
       /* boolean b = a.endsWith("x");
        String s="zxcdcdcd";
        boolean b1 = a.equalsIgnoreCase(s);
        System.out.println(b1);
        int i = s.indexOf("cd");
        System.out.println(i);
        int i1 = s.lastIndexOf("cd");//最后出现的下标
        System.out.println(i1);

        String replace = a.replace("x", "a");
        System.out.println(replace);*/

        String[] cds = a.split("cd");
        String s = String.valueOf(cds);

        String substring = a.substring(2);
        System.out.println(substring);//cd

        String s1 = a.toUpperCase(Locale.ROOT);
        System.out.println(s1);

        Object obj = new Object();
        System.out.println(obj);



    }
    @Test
    public void t(){
       /* String s = "abc";
        System.out.println(s);
        s += "hello";
        System.out.println(s);*/

        int a=11111;
        boolean b=false;
        String s1 = String.valueOf(b);
        System.out.println(s1);
    }

    @Test
    public void q(){
        String s="qq";

    }
}
