package com.god.thread;

public class Test {
    public static void main(String[] args) {
        Account account = new Account("001", 10000);

        AccountThread accountThread1 = new AccountThread(account);
        AccountThread accountThread2 = new AccountThread(account);

        accountThread1.setName("t1");
        accountThread2.setName("t2");

        accountThread1.start();
        accountThread2.start();




    }
}
