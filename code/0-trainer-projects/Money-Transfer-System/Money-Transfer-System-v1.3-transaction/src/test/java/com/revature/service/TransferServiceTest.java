package com.revature.service;

import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.BalanceException;
import com.revature.model.Account;
import com.revature.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class TransferServiceTest {

    private TransferService transferService;
    private AccountRepository accountRepositoryMock;

    // Arrange
    @BeforeEach
    public void setup() {
        accountRepositoryMock = Mockito.mock(AccountRepository.class);
        transferService = new TransferServiceImpl(accountRepositoryMock);
    }

    @Test
    public void invalidAccountTest() {
        Mockito.when(accountRepositoryMock.loadAccount("123")).thenReturn(Optional.empty());
        Assertions.assertThrows(AccountNotFoundException.class, () -> {
            transferService.transfer(100.00, "123", "2");
        });
    }

    @Test
    public void invalidAmountTest() {
        Mockito.when(accountRepositoryMock.loadAccount("1")).thenReturn(Optional.of(new Account("1", 1000.00)));
        Mockito.when(accountRepositoryMock.loadAccount("2")).thenReturn(Optional.of(new Account("2", 1000.00)));
        Assertions.assertThrows(BalanceException.class, () -> {
            transferService.transfer(2000.00, "1", "2");
        });
    }

    @Test
    public void validTransferTest() {
        Mockito.when(accountRepositoryMock.loadAccount("1")).thenReturn(Optional.of(new Account("1", 1000.00)));
        Mockito.when(accountRepositoryMock.loadAccount("2")).thenReturn(Optional.of(new Account("2", 1000.00)));
        boolean txtStatus = transferService.transfer(1000.00, "1", "2");
        Assertions.assertTrue(txtStatus);
    }

}
