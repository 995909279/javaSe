package com.god.thread;

public class AccountThread extends  Thread {
    private  Account account;

    public AccountThread(Account account){
        this.account=account;
    }

    public  void  run(){
        double money=5000;
        synchronized (account) {
            account.withdraw(money);
        }
        System.out.println(Thread.currentThread().getName()+"余额："+account.getBalance());
    }
}
