package com.revature.service;

import com.revature.model.Account;
import com.revature.repository.AccountRepository;
import org.apache.log4j.Logger;

public class NEFTTransferService implements TransferService {

    private static final Logger logger = Logger.getLogger("mts");

    private AccountRepository accountRepository; // abstraction of account-com.revature.repository

    // constructor
    public NEFTTransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public boolean transfer(double amount, String fromAccountNumber, String toAccountNumber) {
        try {
            logger.info("transfer initiated...");
            // step-1: Load 'from' account
            Account fromAccount = accountRepository.loadAccount(fromAccountNumber);

            // step-2: Load 'to' account
            Account toAccount = accountRepository.loadAccount(toAccountNumber);

            // step-3: debit
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            logger.debug("debited");


            // step-4: credit
            toAccount.setBalance(toAccount.getBalance() + amount);
            logger.debug("credited");

            // step-5: update 'from' account
            accountRepository.updateAccount(fromAccount);



            // step-6: update 'to' account
            accountRepository.updateAccount(toAccount);

            logger.info("transfer completed...");

        } catch (Exception e) {
            logger.error("transfer failed - " + e.getMessage());
        }

        return true;
    }
}
