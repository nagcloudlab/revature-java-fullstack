package com.revature.repository;

import com.revature.model.Account;

public interface AccountRepository {

    Account loadAccount(String accountNumber);
    void updateAccount(Account account);

}
