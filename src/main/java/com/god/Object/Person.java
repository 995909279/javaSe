package com.god.Object;

import java.util.Scanner;

public class Person {

    protected  void finalize()throws Throwable{
        System.out.println("即将被回收");
    }


    public static void main(String[] args)   {

        /*for (int i = 0; i < 100000; i++) {
            Person person = new Person();
            person=null;
        }
        //可能启动也可能不启动
        System.gc();*/
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }



    }
}
