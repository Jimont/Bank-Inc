package com.bank.model.dao;

import com.bank.model.entity.Card;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CardDao extends CrudRepository<Card, Long> {
    @Query("select c from Card c where c.cardId = ?1")
    Card getCardByIdCard(String cardId);
}
