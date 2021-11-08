package com.revature.repository;

import com.revature.model.Account;

import java.util.Optional;

public interface AccountRepository {

    Optional<Account> loadAccount(String accountNumber);
    void updateAccount(Account account);

}
