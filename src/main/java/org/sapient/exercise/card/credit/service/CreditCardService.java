package org.sapient.exercise.card.credit.service;

import lombok.SneakyThrows;
import org.sapient.exercise.card.credit.dto.CreditCard;
import org.sapient.exercise.card.credit.dto.CreditCardRequest;
import org.sapient.exercise.card.credit.entity.CreditCardEntity;
import org.sapient.exercise.card.credit.mapper.CreditCardMapper;
import org.sapient.exercise.card.credit.repository.CreditCardRepository;
import org.sapient.exercise.card.credit.validator.CreditCardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.InvalidAlgorithmParameterException;
import java.util.List;

/**
 * @author Yogesh
 */
@Service
public class CreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;

    @Autowired
    CreditCardMapper cardMapper;

    @Autowired
    CreditCardValidator cardValidator;

    public List<CreditCard> getCards() {
        return cardMapper.toCreditCardDtoList((List<CreditCardEntity>) creditCardRepository.findAll());
    }

    public CreditCard addCard(CreditCardRequest card) {
        return cardMapper.toCreditCardDto(creditCardRepository.save(new CreditCardEntity(null, card.getName(),
                card.getCardNumber(), card.getLimit(), 0.0)));
    }
}
