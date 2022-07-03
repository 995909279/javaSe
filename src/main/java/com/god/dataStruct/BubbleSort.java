package com.god.dataStruct;

public class BubbleSort {
    public static void main(String[] args) {


        int[] arr = {1,9,3,4,7,8};
        int temp=0;
        //冒泡思想：最大的数字排到最后
        for (int i = arr.length-1; i >0 ; i--) {
            for (int j=0;j<i;j++){
                if (arr[j]>arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                
            }
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}
