package com.revature.service;

import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.BalanceException;
import com.revature.model.Account;
import com.revature.repository.AccountRepository;
import org.apache.log4j.Logger;

public class TransferServiceImpl implements TransferService {

    private static final Logger logger = Logger.getLogger("mts");

    private AccountRepository accountRepository; // abstraction of account-com.revature.repository

    // constructor
    public TransferServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public boolean transfer(double amount, String fromAccountNumber, String toAccountNumber) {

        logger.info("transfer initiated...");
        // step-1: Load 'from' account , // SELECT
        Account fromAccount = accountRepository.loadAccount(fromAccountNumber).orElseThrow(
                () -> new AccountNotFoundException(fromAccountNumber)
        );

        // step-2: Load 'to' account // SELECT
        Account toAccount = accountRepository.loadAccount(toAccountNumber).orElseThrow(
                () -> new AccountNotFoundException(toAccountNumber)
        );
        if (fromAccount.getBalance() < amount) {
            throw new BalanceException(fromAccount.getBalance());
        }
        // step-3: debit
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        logger.debug("debited");
        // step-4: credit
        toAccount.setBalance(toAccount.getBalance() + amount);
        logger.debug("credited");


        // step-5: update 'from' account // UPDATE
        accountRepository.updateAccount(fromAccount);

//        boolean boom = true;
//        if (boom)
//            throw new IllegalStateException("boooom");

        // step-6: update 'to' account   // UPDATE
        accountRepository.updateAccount(toAccount);

        logger.info("transfer completed...");

        return true;
    }
}
