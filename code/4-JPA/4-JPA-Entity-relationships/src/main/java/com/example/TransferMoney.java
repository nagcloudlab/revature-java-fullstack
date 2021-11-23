package com.example;

import com.example.entity.Account;
import com.example.entity.Transaction;
import com.example.entity.TransactionType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class TransferMoney {

    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Account fromAccount=entityManager.find(Account.class,"2");
        Account toAccount=entityManager.find(Account.class,"1");

        fromAccount.balance= fromAccount.getBalance()-100.00;
        toAccount.balance= toAccount.getBalance()+100.00;

        entityManager.merge(fromAccount);
        entityManager.merge(toAccount);

        Transaction debitTxn=new Transaction();
        debitTxn.type= TransactionType.DEBIT;
        debitTxn.amount=100.00;
        debitTxn.date=new Date();
        debitTxn.account=fromAccount;

        Transaction creditTxn=new Transaction();
        creditTxn.type= TransactionType.CREDIT;
        creditTxn.amount=100.00;
        creditTxn.date=new Date();
        creditTxn.account=toAccount;

        entityManager.persist(debitTxn);
        entityManager.persist(creditTxn);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();


    }

}
