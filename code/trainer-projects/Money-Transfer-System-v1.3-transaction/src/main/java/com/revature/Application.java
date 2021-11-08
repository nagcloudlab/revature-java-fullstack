package com.revature;

import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.BalanceException;
import com.revature.repository.AccountRepository;
import com.revature.repository.JdbcAccountRepository;
import com.revature.service.TransferService;
import com.revature.service.TransferServiceImpl;
import org.apache.log4j.Logger;

public class Application {

    private static final Logger logger = Logger.getLogger("mts"); // singleton

    public static void main(String[] args) {

        logger.info("application - started");

        //-------------------------------------
        // init phase
        //-------------------------------------

        AccountRepository accountRepository = new JdbcAccountRepository(); // dependency
        TransferService transferService = new TransferServiceImpl(accountRepository); // dependent

        //-------------------------------------
        // use phase
        //-------------------------------------

        try {
            transferService.transfer(300, "1", "2");
        } catch (AccountNotFoundException e) {
            logger.error("Account not found - " + e.getMessage());
        } catch (BalanceException e) {
            logger.error("No enough balance in FROM account current balance= " + e.getMessage());
        }

        logger.info("application - ended");
    }

}
