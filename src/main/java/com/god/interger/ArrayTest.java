package com.god.interger;

public class ArrayTest {
    public static void main(String[] args) {
        int[] src={1,11,2,3};
        int[] dest=new int[20];
//        System.arraycopy(src,1,dest,2,3);
//        for (int i = 0; i < dest.length; i++) {
//            System.out.println(dest[i]);
//        }

/*        System.arraycopy(src,0,dest,0,src.length);
        for (int i = 0; i < dest.length; i++) {
            System.out.println(dest[i]);
        }*/

   /*     String [] strs = new String[5];
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        String[] S = {"11","22","33"};
        System.arraycopy(S,0,strs,0,S.length);
        for (int i = 0; i< strs.length;i++){
            System.out.println(strs[i]);
        }*/

        /*Object[] obj={new Object(),new Object(),new Object()};
        Object[] objects = new Object[5];
        System.arraycopy(obj,0,objects,0,obj.length);
        for (Object object : objects) {
            System.out.println(object);
        }*/


       /* int[] array={1,2,3};
        System.out.println(array.length);//3

        int[][] a={{1,2,3,4},{5,6}};
        System.out.println(a.length);//2
        System.out.println(a[0].length);//4*/

/*
        int[][] a={{1,2,3,4},{5,6}};
        int[] q=a[0];//{1,2,3,4}
        int i = q[0];//1
        System.out.println(i);

        int aa=a[0][0];
        System.out.println(aa);//1
        System.out.println(a[1][1]);//6*/


        printArray(new String[][]{
                {"a","vv"},
                {"cc","dd"},
                {"123","999"}
        });

        }

        public static void printArray(String[][] a) {
            for (int i = 0; i < a.length ;i++) {
                System.out.println();
                for (int j=0;j<a[i].length;j++){
                    System.out.println(a[i][j]+"  ");
                }
    }



    }
}
