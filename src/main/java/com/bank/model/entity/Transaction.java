package com.bank.model.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tbl_transaction")
public class Transaction {
    @Id
    @Column(name="TRANSACTION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    @Column(name="CARD_ID")
    private String cardId;
    @Column(name="PRICE")
    private Double price;
    @Column(name="TRANSACTION_DATE")
    private Timestamp transactionDate;
    @Column(name="TRANSACTION_STATUS")
    private String transactionStatus;
}
