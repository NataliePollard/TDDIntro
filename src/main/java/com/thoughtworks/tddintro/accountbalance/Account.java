package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by nataliepollard on 1/5/16.
 */
public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void deposit(int n)
    {
        balance +=n;
    }

    public void withdraw(int n) {
        if(balance - n >=0)
            balance -=n;
    }

    public int getBalance() {
        return balance;
    }

}
