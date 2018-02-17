package com.aspectj;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class AccountTest {

    private Account account;

    @Before
    public void before(){
        account = new Account();
    }

    @Test
    public void given20AndMin10_whenWithdraw5_thenSuccess() {
        assertTrue(account.withdraw(5));
    }
}
