package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TransferServiceImpl implements TransferService {

    private AccountRepository accountRepository;

    public TransferServiceImpl(AccountRepository accountRepository) {
        this.accountRepository=accountRepository;
        log.info("TransferServiceImpl instance created...");
    }

    public void transfer(double amount, String fromAccNum, String toAccNum) {
        log.info("transfer initiated.");
        Account fromAccount = accountRepository.loadAccount(fromAccNum);
        Account toAccount = accountRepository.loadAccount(toAccNum);

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.updateAccount(fromAccount);
        accountRepository.updateAccount(toAccount);
        log.info("transfer finished.");
    }
}
