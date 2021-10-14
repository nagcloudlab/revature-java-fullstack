package com.revature.service;

import com.revature.model.Account;
import com.revature.repository.AccountRepository;

public class NEFTTransferService implements TransferService{

    private AccountRepository accountRepository; // abstraction of account-repository

    // constructor
    public NEFTTransferService(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
        System.out.println("NEFTTransferService instance created..");
    }

    @Override
    public boolean transfer(double amount, String fromAccountNumber, String toAccountNumber) {
        System.out.println("transfer initiated..");
        // step-1: Load 'from' account
        Account fromAccount=accountRepository.loadAccount(fromAccountNumber);

        // step-2: Load 'to' account
        Account toAccount=accountRepository.loadAccount(toAccountNumber);

        // step-3: debit
        fromAccount.setBalance(fromAccount.getBalance()-amount);

        // step-4: credit
        toAccount.setBalance(toAccount.getBalance()+amount);

        // step-5: update 'from' account
        accountRepository.updateAccount(fromAccount);

        // step-6: update 'to' account
        accountRepository.updateAccount(toAccount);

        System.out.println("transfer completed..");

        return true;
    }
}
