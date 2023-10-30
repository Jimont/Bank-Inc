package com.bank.service.transaction;

import com.bank.model.dto.transaction.TransactionAnulationDto;
import com.bank.model.dto.transaction.TransactionDto;
import com.bank.model.dto.transaction.TransactionPurchaseDto;

public interface ITransactionService {

    TransactionDto transactionBuy(TransactionPurchaseDto transactionPurchaseDto);

    TransactionDto findTransactionById(Long Id);

    TransactionDto anulationTransaction(TransactionAnulationDto transactionAnulationDto);
}
