package org.sapient.exercise.card.credit.repository;

import org.sapient.exercise.card.credit.entity.CreditCardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCardEntity, Long> {

}
