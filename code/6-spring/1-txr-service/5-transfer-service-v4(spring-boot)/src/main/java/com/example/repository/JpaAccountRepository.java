package com.example.repository;

import com.example.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Qualifier("jpa")
public class JpaAccountRepository implements AccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public JpaAccountRepository() {
    }

    @Override
    public Account loadAccount(String number) {
        return entityManager.find(Account.class,number);
    }

    @Override
    public void updateAccount(Account account) {
        entityManager.merge(account);
    }

}
