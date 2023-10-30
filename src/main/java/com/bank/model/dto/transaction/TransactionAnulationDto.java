package com.bank.model.dto.transaction;


import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TransactionAnulationDto {
    private String cardId;
    private Long transactionId;
}
