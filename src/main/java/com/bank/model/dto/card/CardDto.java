package com.bank.model.dto.card;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CardDto {
    private Long customerId;
    private String cardId;
    private String productId;
    private LocalDate creationDate;
    private LocalDate expiryDate;
    private Double balance;
    private String cardStatus;
}
