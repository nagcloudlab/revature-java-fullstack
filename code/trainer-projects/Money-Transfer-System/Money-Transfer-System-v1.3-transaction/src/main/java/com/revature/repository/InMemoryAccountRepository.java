package com.revature.repository;

import com.revature.model.Account;

import java.util.Optional;

public class InMemoryAccountRepository implements AccountRepository{

    public InMemoryAccountRepository(){
        System.out.println("InMemoryAccountRepository instance created..");
    }

    @Override
    public Optional<Account> loadAccount(String accountNumber) {
        // find account by account-number xxx source
        System.out.println("loading account - "+accountNumber);
        Account account=new Account(accountNumber,1000.00);
        return Optional.of(account);
    }

    @Override
    public void updateAccount(Account account) {
        // update account with changes...
        System.out.println("updating account - "+account.getNumber());
        System.out.println("current balance -"+account.getBalance());
    }
}
