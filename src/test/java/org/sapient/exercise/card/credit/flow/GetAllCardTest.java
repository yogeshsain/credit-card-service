package org.sapient.exercise.card.credit.flow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sapient.exercise.card.credit.config.AbstractCardServiceTest;
import org.sapient.exercise.card.credit.dto.CreditCard;
import org.sapient.exercise.card.credit.entity.CreditCardEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Flow test to get all the cards")
class GetAllCardTest extends AbstractCardServiceTest {

    @Test
    @DisplayName("Get all the cards")
    void getAllCards(){
        when(creditCardRepository.findAll()).thenReturn(mockCardsData());
        final ResponseEntity<List<CreditCard>> actualResponse = creditCardController.getCreditCards();
        verify(creditCardRepository).findAll();
    }

    private List<CreditCardEntity> mockCardsData() {
        return List.of(new CreditCardEntity(1l, "Credit card 1", "378282246310005",0.0,200.0),
                new CreditCardEntity(1l, "Credit card 2", "374245455400126",0.0,400.0));
    }

}
