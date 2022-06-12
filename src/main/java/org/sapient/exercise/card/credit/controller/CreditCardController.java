package org.sapient.exercise.card.credit.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.sapient.exercise.card.credit.dto.CreditCard;
import org.sapient.exercise.card.credit.dto.CreditCardRequest;
import org.sapient.exercise.card.credit.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Slf4j
@RequestMapping("api/cards")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @Operation(summary = "Get All Credit cards", description = "Get all the credit cards.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "204", content = @Content(schema = @Schema(implementation = Void.class)))
    })
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CreditCard>> getCreditCards() {
        List<CreditCard> cards = creditCardService.getCards();
        return CollectionUtils.isEmpty(cards)? ResponseEntity.noContent().build() : ResponseEntity.ok(cards);
    }

    @Operation(summary = "Add Credit Card", description = "Add a new credit card.")
    @ApiResponse(responseCode = "200")
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCard> addCard(@Valid @RequestBody CreditCardRequest cardRequest) {
        return ResponseEntity.ok(creditCardService.addCard(cardRequest));
    }
}
