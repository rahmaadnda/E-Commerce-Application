package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entites.CreditCard;

@Repository
public interface CreditCardRepo extends JpaRepository<CreditCard, Long>{

}

