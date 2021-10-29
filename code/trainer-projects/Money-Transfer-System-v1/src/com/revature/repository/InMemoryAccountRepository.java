package com.revature.repository;

import com.revature.model.Account;

public class InMemoryAccountRepository implements AccountRepository{

    public InMemoryAccountRepository(){
        System.out.println("InMemoryAccountRepository instance created..");
    }

    @Override
    public Account loadAccount(String accountNumber) {
        // find account by account-number xxx source
        System.out.println("loading account - "+accountNumber);
        Account account=new Account(accountNumber,1000.00);
        return account;
    }

    @Override
    public void updateAccount(Account account) {
        // update account with changes...
        System.out.println("updating account - "+account.getNumber());
        System.out.println("current balance -"+account.getBalance());
    }
}
