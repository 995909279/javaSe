package com.god.thread;

public class Account {

    private String  Account;
    private double  balance;

    public Account(String account, double balance) {
        Account = account;
        this.balance = balance;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public  void withdraw(double money){

        synchronized (this){
            double before = this.balance;
            double after=before- money;

            try{
                Thread.sleep(1000*5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            this.setBalance(after);
        }
        }


}
