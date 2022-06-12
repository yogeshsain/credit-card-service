package org.sapient.exercise.card.credit.flow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sapient.exercise.card.credit.config.AbstractCardServiceTest;
import org.sapient.exercise.card.credit.dto.CreditCard;
import org.sapient.exercise.card.credit.dto.CreditCardRequest;
import org.sapient.exercise.card.credit.entity.CreditCardEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Flow test to add new card")
class AddNewCardTest extends AbstractCardServiceTest {

    @Test
    @DisplayName("Add new card with valid details")
    void addNewCard() {
        when(creditCardRepository.save(new CreditCardEntity(null, "Credit card 1", "378282246310005",
                0.0, 200.0))).thenReturn(mockCardData());
        final ResponseEntity<CreditCard> actualResponse = creditCardController.addCard(CreditCardRequest.builder()
                .cardNumber("378282246310005").name("Credit card 1").limit(200.0).build());
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        verify(creditCardRepository).save(any(CreditCardEntity.class));
    }

    @Test
    @DisplayName("Validate card number with Luhn 10 for credit card request")
    void validateNewCardWithValidCardNumber() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<CreditCardRequest>> violations = validator.validate(CreditCardRequest.builder()
                .cardNumber("378282246310005").name("Credit card 1").limit(200.0).build());
        assertTrue(violations.isEmpty());
    }

    @Test
    @DisplayName("Validate card number with Luhn 10 for invalid credit card request")
    void addNewCardWithInvalidDetails() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<CreditCardRequest>> violations = validator.validate(CreditCardRequest.builder()
                .cardNumber("37828224631000").name("Credit card 1").limit(200.0).build());
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(a -> a.getMessage().equals("Invalid card : provided card number is invalid.")));
    }


    private CreditCardEntity mockCardData() {
        return new CreditCardEntity(1L, "Credit card 1", "378282246310005", 0.0, 200.0);
    }

}
