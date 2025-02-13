package com.app.entites;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "credit_cards")
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long creditCardId;

    @OneToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @NotBlank
    @Size(min = 16, max = 16, message = "Card Number must be exactly 16 digits long")
	@Pattern(regexp = "^\\d{16}$", message = "Card Number must contain only Numbers")
	private String cardNumber;

    @NotBlank
	@Size(min = 3, max = 3, message = "CVC must be exactly 3 digits long")
	@Pattern(regexp = "^\\d{3}$", message = "CVC must contain only Numbers")
    private String cvc;
}