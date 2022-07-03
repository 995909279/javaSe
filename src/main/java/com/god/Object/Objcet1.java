package com.god.Object;

public class Objcet1 {

    public  native int  hashCode();





    public  String toString(){
        return getClass().getName()+"@"+Integer.toHexString(hashCode());
    }

    public static void main(String[] args) {
        Objcet1 objcet1 = new Objcet1();
        boolean equals = objcet1.equals(1);
        System.out.println(equals);



    }
}
