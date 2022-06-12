package org.sapient.exercise.card.credit.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CREDIT_CARD")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreditCardEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @NotNull
    @Column(name = "CARD_NUMBER", nullable = false, unique = true)
    private String cardNumber;
    @Column(name = "TOTAL_LIMIT")
    private Double limit;
    @Column(name = "BALANCE")
    private Double balance;
}
