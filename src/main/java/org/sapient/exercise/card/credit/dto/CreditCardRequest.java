package org.sapient.exercise.card.credit.dto;

import lombok.Builder;
import lombok.Value;
import org.sapient.exercise.card.credit.validator.LuhnValidation;

import javax.validation.constraints.*;

@Value
@Builder
public class CreditCardRequest {

    @NotBlank
    String name;

    @Size(min = 1, max = 19, message = " Card Number must be less than 19 characters")
    @LuhnValidation()
    @Pattern(regexp = "\\d+", message = "Provided number must only contains digit")
    String cardNumber;

    @NotNull
    Double limit;
}
