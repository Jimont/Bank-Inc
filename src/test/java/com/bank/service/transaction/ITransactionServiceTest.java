package com.bank.service.transaction;




import com.bank.model.dto.transaction.TransactionDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ITransactionServiceTest {
    @MockBean
    private ITransactionService transactionService;

    @BeforeEach
    void setUp() {
        long time = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(time);
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setTransactionId(1L);
        transactionDto.setCardId("10203000000000001");
        transactionDto.setPrice(100.0);
        transactionDto.setTransactionDate(timestamp);
        transactionDto.setTransactionStatus("Exitosa");

        Mockito.when(transactionService.findTransactionById(1L)).thenReturn(transactionDto);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findTransactionById() {
        String cardId = "10203000000000001";
        TransactionDto TransactionDtoById = transactionService.findTransactionById(1L);
        assertEquals(cardId, TransactionDtoById.getCardId());
    }

}