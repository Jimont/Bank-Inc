package com.bank.service.card;

import com.bank.model.dto.card.BalanceCardDto;
import com.bank.model.dto.card.CardBalanceDto;
import com.bank.model.dto.card.CardDto;

public interface ICardService {
    CardDto save(String productId);
    CardDto cardStatusChange(String cardId, int flag);
    CardDto loadBalace(CardBalanceDto cardBalanceDto);
    BalanceCardDto getBalance(String  cardId);

}
