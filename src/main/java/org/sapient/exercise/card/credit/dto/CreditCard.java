package org.sapient.exercise.card.credit.dto;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Value
@Builder
public class CreditCard {
    String name;
    String cardNumber;
    Double limit;
    Double balance;
}
