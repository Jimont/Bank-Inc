package com.bank.model.dto.transaction;


import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.hibernate.validator.constraints.Length;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TransactionDto {

    private Long transactionId;
    @Length(min = 16, message = "Minimo 16 caracteres")
    private String cardId;
    @DecimalMin(value = "1.00", message = "El valor debe ser mayor a cero")
    private Double price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp transactionDate;
    private String transactionStatus;
}
