package com.thoughtworks.tddintro.accountbalance;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class AccountTests {

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        Account account = new Account(100);
        account.deposit(50);
        assertThat(account.getBalance(), is(150));

    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        Account account2 = new Account(100);
        account2.withdraw(50);
        assertThat(account2.getBalance(), is(50));
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        Account account2 = new Account(50);
        account2.withdraw(100);
        assertThat(account2.getBalance(), is(50));
    }
}
