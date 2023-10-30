package com.bank.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tbl_card")
public class Card {
    @Id
    @Column(name="CUSTOMER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @Column(name="CARD_ID")
    private String cardId;
    @Column(name="PRODUCT_ID")
    private String productId;
    @Column(name="CREATION_DATE")
    private LocalDate creationDate;
    @Column(name="EXPIRY_DATE")
    private LocalDate expiryDate;
    @Column(name="BALANCE")
    private Double balance;
    @Column(name="CARD_STATUS")
    private String cardStatus;
}
