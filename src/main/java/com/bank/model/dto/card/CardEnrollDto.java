package com.bank.model.dto.card;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CardEnrollDto {
    private String cardId;
}
