package com.god.dataStruct.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class datetimeTest {
    @Test
    public void t() throws ParseException {

        System.out.println(new Date());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);

        String time = "2020-01-01 00:08:08:888";
        //注意：字符串的日期格式和SimpleDateFormat对象指定的日期要相同，不然会出现异常PareException
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        Date dateTime = sdf2.parse(time);
        System.out.println(dateTime);

    }

    @Test
    public void  a(){
        long begin = System.currentTimeMillis();
        print();
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }

    public  static  void print(){
        for (int i = 0; i < 1000; i++) {
            System.out.println("i="+i);
        }
    }

    @Test
    public void t1(){
        Date date = new Date(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        Date time1 = new Date(System.currentTimeMillis() - (1000 * 60 *60 *24));
        String strTime2 = simpleDateFormat.format(time1);
        System.out.println(strTime2);

    }


}
