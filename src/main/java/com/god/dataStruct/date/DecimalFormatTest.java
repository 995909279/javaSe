package com.god.dataStruct.date;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

public class DecimalFormatTest {
    @Test
    public  void q(){
        /*代表任意数字
         * ,代表千分位
         * .代表小数*/
        DecimalFormat decimalFormat = new DecimalFormat("###,###.00000");
        String format = decimalFormat.format(14444423.111);
        System.out.println(format);

    }

    @Test
    public  void s(){
        /*BigDecimal a = new BigDecimal(11.213123212222222);
        BigDecimal b = new BigDecimal(222.1111111111111111111);
        System.out.println(a.add(b));*/

        Object o = new Object();
        int i = o.hashCode();
        System.out.println(i);



    }
}
