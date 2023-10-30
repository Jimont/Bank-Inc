package com.bank.controller;

import com.bank.commons.Constants;
import com.bank.model.dto.card.*;

import com.bank.service.card.ICardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CardController {
    private final ICardService cardService;


    public CardController(ICardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/card/{productId}/number")
    public ResponseEntity<CardDto>  create(@PathVariable String productId){
        CardDto cardCreate = cardService.save(productId);
        return new ResponseEntity<>(cardCreate, HttpStatus.CREATED);
    }

    @PostMapping("/card/enroll")
    public ResponseEntity<String>  activateCard(@RequestBody CardEnrollDto cardEnrollDto){
        cardService.cardStatusChange(cardEnrollDto.getCardId(), 1);
        return new ResponseEntity<>(Constants.ACTIVE_CARD, HttpStatus.OK);
    }

    @DeleteMapping("/card/{cardId}")
    public ResponseEntity<String>  lockCard(@PathVariable String cardId){
        cardService.cardStatusChange(cardId, 0);
        return new ResponseEntity<>(Constants.LOCK_CARD, HttpStatus.OK);
    }

    @PostMapping("/card/balance")
    public ResponseEntity<String>  balanceRecharge(@RequestBody CardBalanceDto cardBalanceDto){
        cardService.loadBalace(cardBalanceDto);
        return new ResponseEntity<>(Constants.BALANCE_RECHARGE, HttpStatus.OK);
    }

    @GetMapping("/card/balance/{cardId}")
    public BalanceCardDto getBalace(@PathVariable String cardId){
        return cardService.getBalance(cardId);
    }

}
