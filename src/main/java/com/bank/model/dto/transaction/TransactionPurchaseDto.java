package com.bank.model.dto.transaction;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TransactionPurchaseDto {
    private String cardId;
    private Double price;
}
