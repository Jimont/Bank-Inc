package com.bank.service.card;

import com.bank.model.dto.card.BalanceCardDto;
import com.bank.model.dto.card.CardDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ICardServiceTest {
    @MockBean
    private ICardService cardService;

    @BeforeEach
    void setUp() {
        LocalDate datetime = LocalDate.now();
        CardDto cardDto = new CardDto();
        cardDto.setProductId("102030");
        cardDto.setCardId("10203000000000001");
        cardDto.setCreationDate(datetime);
        cardDto.setExpiryDate(datetime.plusYears(3));
        cardDto.setBalance(0.0);
        cardDto.setCardStatus("Inactiva");


        BalanceCardDto balanceCardDto = new BalanceCardDto();
        balanceCardDto.setCardId("10203000000000001");
        balanceCardDto.setBalance(1000.0);

        Mockito.when(cardService.save("102030")).thenReturn(cardDto);
        Mockito.when(cardService.getBalance("10203000000000001")).thenReturn(balanceCardDto);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        String cId = "10203000000000001";
        CardDto Cdto = cardService.save("102030");
        assertEquals(cId, Cdto.getCardId());
    }

    @Test
    void loadBalace() {
        Double balance = 1000.0;
        BalanceCardDto balanceCardDto = cardService.getBalance("10203000000000001");
        assertEquals(balance, balanceCardDto.getBalance());

    }

}