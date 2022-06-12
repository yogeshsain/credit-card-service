package org.sapient.exercise.card.credit.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.sapient.exercise.card.credit.dto.CreditCard;
import org.sapient.exercise.card.credit.entity.CreditCardEntity;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditCardMapper {
    CreditCard toCreditCardDto(CreditCardEntity creditCardEntityList);

    List<CreditCard> toCreditCardDtoList (List<CreditCardEntity> creditCardEntityList);
}
