package com.example.repository;

import com.example.entity.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("jdbc")
public class JdbcAccountRepository implements AccountRepository{


    @Override
    public Account loadAccount(String number) {
        return null;
    }

    @Override
    public void updateAccount(Account account) {

    }
}
