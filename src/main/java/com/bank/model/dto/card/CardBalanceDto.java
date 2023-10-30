package com.bank.model.dto.card;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CardBalanceDto {
    private String cardId;
    private Double balance;
}
