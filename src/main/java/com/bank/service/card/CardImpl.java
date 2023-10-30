package com.bank.service.card;

import com.bank.commons.Constants;
import com.bank.commons.MapperUtils;
import com.bank.model.dao.CardDao;
import com.bank.model.dto.card.BalanceCardDto;
import com.bank.model.dto.card.CardBalanceDto;
import com.bank.model.dto.card.CardDto;
import com.bank.model.entity.Card;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Formatter;

@Service
public class CardImpl implements ICardService {
    private final CardDao cardDao;
    private final MapperUtils mapper;

    public CardImpl(CardDao cardDao, MapperUtils mapper) {
        this.cardDao = cardDao;
        this.mapper = mapper;
    }
    @Transactional
    @Override
    public CardDto save(String productId) {
        LocalDate datetime = LocalDate.now();
        Card card = new Card();
        card.setProductId(productId);
        card.setCreationDate(datetime);
        card.setExpiryDate(card.getCreationDate().plusYears(Constants.YEARS_VALIDITY_CARD));
        card.setBalance(Constants.DEFALUT_BALANCE_CARD);
        card.setCardStatus(Constants.DEFAULT_STATUS_CARD);
        Card cardReturn = cardDao.save(card);
        cardReturn.setCardId(cardReturn.getProductId() + this.addCero(cardReturn.getCustomerId()));
        Card cardFull = cardDao.save(cardReturn);
        return mapper.map(cardFull, CardDto.class);
    }

    @Transactional
    @Override
    public CardDto cardStatusChange(String  cardId, int flag) {
        Card cardToActivate = cardDao.getCardByIdCard(cardId);

        if (flag != 1) {
            cardToActivate.setCardStatus(Constants.BLOCK_STATUS_CARD);
        }else {
            cardToActivate.setCardStatus(Constants.ACTIVE_STATUS_CARD);
        }
        Card cardActive = cardDao.save(cardToActivate);
        return mapper.map(cardActive, CardDto.class);
    }

    @Override
    public CardDto loadBalace(CardBalanceDto cardBalanceDto) {
        Card cardToLoad = cardDao.getCardByIdCard(cardBalanceDto.getCardId());
        cardToLoad.setBalance(cardBalanceDto.getBalance());
        Card balanceUpdate = cardDao.save(cardToLoad);
        return mapper.map(balanceUpdate, CardDto.class);
    }

    @Transactional
    @Override
    public BalanceCardDto getBalance(String  cardId) {
        Card getBalaceByIdCArd = cardDao.getCardByIdCard(cardId);
        return mapper.map(getBalaceByIdCArd, BalanceCardDto.class);
    }

    public String addCero(Long num){
        Formatter obj = new Formatter();
        return String.valueOf(obj.format("%010d", num));
    }


}
