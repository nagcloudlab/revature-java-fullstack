package com.revature;

import com.revature.repository.AccountRepository;
import com.revature.repository.InMemoryAccountRepository;
import com.revature.repository.JdbcAccountRepository;
import com.revature.service.NEFTTransferService;
import com.revature.service.TransferService;
import org.apache.log4j.Logger;

public class Application {

    private static final Logger logger = Logger.getLogger("mts"); // singleton

    public static void main(String[] args) {

        logger.info("application - started");

        //-------------------------------------
        // init phase
        //-------------------------------------

        AccountRepository accountRepository = new JdbcAccountRepository(); // dependency
        TransferService transferService = new NEFTTransferService(accountRepository); // dependent

        //-------------------------------------
        // use phase
        //-------------------------------------

        transferService.transfer(300, "11", "2");


        logger.info("application - ended");
    }

}
