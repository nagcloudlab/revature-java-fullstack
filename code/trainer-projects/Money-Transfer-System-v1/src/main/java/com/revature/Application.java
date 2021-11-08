package com.revature;

import com.revature.repository.AccountRepository;
import com.revature.repository.InMemoryAccountRepository;
import com.revature.repository.JdbcAccountRepository;
import com.revature.service.NEFTTransferService;
import com.revature.service.TransferService;

public class Application {

    public static void main(String[] args) {

        //-------------------------------------
        // init phase
        //-------------------------------------

        AccountRepository accountRepository=new JdbcAccountRepository(); // dependency
        TransferService transferService=new NEFTTransferService(accountRepository); // dependent

        System.out.println();

        //-------------------------------------
        // use phase
        //-------------------------------------

        transferService.transfer(300,"1","2");

    }

}
