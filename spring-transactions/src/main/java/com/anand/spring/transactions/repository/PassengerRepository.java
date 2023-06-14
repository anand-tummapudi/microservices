package com.anand.spring.transactions.repository;

import com.anand.spring.transactions.entity.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerEntity,Long> {
}
