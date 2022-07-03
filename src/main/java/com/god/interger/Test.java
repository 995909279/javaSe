package com.god.interger;

public class Test {

    public static void main(String[] args) {
        MyInt myInt = new MyInt(100);
        doSome(myInt);
        Integer integer = new Integer(123);
        float v = integer.floatValue();
        System.out.println(v);
    }


        public static void doSome(Object obj){
            System.out.println(obj);
        }


}
