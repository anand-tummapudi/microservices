package com.anand.spring.transactions.repository;

import com.anand.spring.transactions.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity,String> {
}
