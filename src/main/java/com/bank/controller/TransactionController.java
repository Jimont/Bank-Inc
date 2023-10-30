package com.bank.controller;

import com.bank.model.dto.transaction.TransactionAnulationDto;
import com.bank.model.dto.transaction.TransactionDto;
import com.bank.model.dto.transaction.TransactionPurchaseDto;
import com.bank.service.transaction.ITransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {
    private final ITransactionService transactionService;

    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transaction/purchase")
    public ResponseEntity create(@Valid @RequestBody TransactionPurchaseDto transactionPurchaseDto){
        TransactionDto transactionCreate = transactionService.transactionBuy(transactionPurchaseDto);
        return new ResponseEntity<>(transactionCreate, HttpStatus.OK);
    }

    @GetMapping("/transaction/{transactionId}")
    public ResponseEntity getTransactionById(@Valid @PathVariable Long transactionId){
        TransactionDto getTransaction = transactionService.findTransactionById(transactionId);
        return new ResponseEntity<>(getTransaction, HttpStatus.OK);
    }

    @PostMapping("/transaction/anulation")
    public ResponseEntity anulation(@Valid @RequestBody TransactionAnulationDto transactionAnulationDto){
        TransactionDto transactionAnulate = transactionService.anulationTransaction(transactionAnulationDto);
        return new ResponseEntity<>(transactionAnulate, HttpStatus.OK);
    }






}
