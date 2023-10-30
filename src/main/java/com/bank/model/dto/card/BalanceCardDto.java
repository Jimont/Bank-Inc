package com.bank.model.dto.card;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BalanceCardDto {

    private String cardId;
    private Double balance;
}
