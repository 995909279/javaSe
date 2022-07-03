package com.god.ex;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        UserService userService = new UserService();
        System.out.println("请输入账户和密码");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();
        String password = scanner.next();
        try {
            userService.register(username,password);
        } catch (RegisterException e) {
            System.out.println(e.getMessage());
        }
    }
}
