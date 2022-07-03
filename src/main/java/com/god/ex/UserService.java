package com.god.ex;

import java.util.Scanner;

public class UserService {
    public  void  register(String  username,String password) {

            if (!(username.length()>6&&password.length()<11)){
                throw new RegisterException("输入账户不在6-11区间");
            }
    }
}
