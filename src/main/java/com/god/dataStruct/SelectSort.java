package com.god.dataStruct;

public class SelectSort {

    //选择排序
    public static void main(String[] args) {
        int a[]={3,1,6,2,5};
        for (int i = 0; i < a.length - 1; i++) {
            //i是最小元素下标
            int min=i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j]<a[min]){
                    min=j;
                }
            }
            if (i!=min){
                int temp;
                temp=a[min];
                a[min]=a[i];
                a[i]=temp;
            }
        }
    }

}
