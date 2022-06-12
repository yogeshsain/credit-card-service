package org.sapient.exercise.card.credit.config;

import org.junit.jupiter.api.extension.ExtendWith;
import org.sapient.exercise.card.credit.controller.CreditCardController;
import org.sapient.exercise.card.credit.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CardServiceTestConfiguration.class)
public abstract class AbstractCardServiceTest {

    @Autowired
    protected CreditCardController creditCardController;

    @Autowired
    protected CreditCardRepository creditCardRepository;
}
