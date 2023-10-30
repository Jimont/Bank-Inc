package com.bank.service.transaction;

import com.bank.commons.Constants;
import com.bank.commons.MapperUtils;
import com.bank.exception.BussinesException;
import com.bank.model.dao.CardDao;
import com.bank.model.dao.TransactionDao;
import com.bank.model.dto.transaction.TransactionAnulationDto;
import com.bank.model.dto.transaction.TransactionDto;
import com.bank.model.dto.transaction.TransactionPurchaseDto;
import com.bank.model.entity.Card;
import com.bank.model.entity.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class TransactionImpl implements ITransactionService{
    Logger logger = LoggerFactory.getLogger(TransactionImpl.class);
    private final TransactionDao transactionDao;
    private final CardDao cardDao;
    private final MapperUtils mapper;

    public TransactionImpl(TransactionDao transactionDao, CardDao cardDao, MapperUtils mapper) {
        this.transactionDao = transactionDao;
        this.cardDao = cardDao;
        this.mapper = mapper;
    }

    @Transactional
    public TransactionDto saveTransaction(TransactionPurchaseDto transactionPurchaseDto) {
        Transaction transaction = new Transaction();
        transaction.setCardId(transactionPurchaseDto.getCardId());
        transaction.setPrice(transactionPurchaseDto.getPrice());
        transaction.setTransactionDate(Timestamp.valueOf(LocalDateTime.now()));
        transaction.setTransactionStatus(Constants.SUCCESFUL_TRANSACTION);
        Transaction transactionReturn = transactionDao.save(transaction);
        return mapper.map(transactionReturn, TransactionDto.class);
    }
    @Transactional
    @Override
    public TransactionDto transactionBuy(TransactionPurchaseDto transactionPurchaseDto) {
        Card cardTransaction = cardDao.getCardByIdCard(transactionPurchaseDto.getCardId());

        if (cardTransaction!= null){
            LocalDate datetime = LocalDate.now();
            Double balanceCard = cardTransaction.getBalance();
            if ((balanceCard > 0) && (balanceCard > transactionPurchaseDto.getPrice())){
                if (cardTransaction.getCardStatus().equals(Constants.ACTIVE_STATUS_CARD)){
                    if (datetime.isBefore(cardTransaction.getExpiryDate())) {
                        Double newBalace = balanceCard - transactionPurchaseDto.getPrice();
                        cardTransaction.setBalance(newBalace);
                        cardDao.save(cardTransaction);
                        return this.saveTransaction(transactionPurchaseDto);
                    }else {throw new BussinesException("-1", HttpStatus.INTERNAL_SERVER_ERROR, Constants.CAR_EXPIRY);}
                }else {throw new BussinesException("-1", HttpStatus.INTERNAL_SERVER_ERROR, Constants.NO_ACTIVE_STATUS_CARD);}
            } else {throw new BussinesException("-1", HttpStatus.INTERNAL_SERVER_ERROR, Constants.INSUFFICIENT_BALANCE);}
        }else {throw new BussinesException("-1", HttpStatus.INTERNAL_SERVER_ERROR, Constants.RECORD_NOT_FOUND);}
    }
    @Transactional
    @Override
    public TransactionDto findTransactionById(Long Id) {
        Transaction transactionReturn = transactionDao.findById(Id).orElse(null);
        if (transactionReturn != null){
            return mapper.map(transactionReturn, TransactionDto.class);
        }else {throw new BussinesException("-1", HttpStatus.INTERNAL_SERVER_ERROR, Constants.RECORD_NOT_FOUND);}
    }

    @Override
    public TransactionDto anulationTransaction(TransactionAnulationDto transactionAnulationDto) {
        Card card = cardDao.getCardByIdCard(transactionAnulationDto.getCardId());
        Transaction transaction = transactionDao.findById(transactionAnulationDto.getTransactionId()).orElse(null);
        if (card!= null && transaction!=null){
            Double blanceCard = card.getBalance();
            Double blanceTransaction = transaction.getPrice();
            Double newBalance = blanceCard + blanceTransaction;
            card.setBalance(newBalance);
            cardDao.save(card);
            transaction.setTransactionStatus(Constants.VOIDED_TRANSACTION);
            transactionDao.save(transaction);
        }else {throw new BussinesException("-1", HttpStatus.INTERNAL_SERVER_ERROR, Constants.RECORD_NOT_FOUND);}
        return mapper.map(transaction, TransactionDto.class);
    }

}
