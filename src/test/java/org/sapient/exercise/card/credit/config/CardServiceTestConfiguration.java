package org.sapient.exercise.card.credit.config;

import org.sapient.exercise.card.credit.repository.CreditCardRepository;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.sapient.exercise.card.credit"})
public class CardServiceTestConfiguration {
    @MockBean
    CreditCardRepository creditCardRepository;
}
