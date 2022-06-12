package org.sapient.exercise.card.credit.validator;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

@Component
public class CreditCardValidator implements ConstraintValidator<LuhnValidation, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return isLuhn(value);
    }

    private boolean isLuhn(String num) {
        int[] a = {num.length() % 2 == 0 ? 1 : 2};        // 1 if length even, 2 otherwise
        return num.chars()
                .map(i -> i - '0')                        // convert to the int equivalent
                .map(n -> n * (a[0] = a[0] == 1 ? 2 : 1)) // multiply by 1, 2 alternating
                .map(n -> n > 9 ? n - 9 : n)              // handle sum of digits
                .sum() % 10 == 0;                         // mod 10 should be zero
    }
}
