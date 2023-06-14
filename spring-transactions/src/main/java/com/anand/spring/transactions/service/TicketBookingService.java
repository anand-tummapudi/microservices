package com.anand.spring.transactions.service;

import com.anand.spring.transactions.dto.TicketBookingRequest;
import com.anand.spring.transactions.dto.TicketBookingStatus;
import com.anand.spring.transactions.entity.PassengerEntity;
import com.anand.spring.transactions.entity.PaymentEntity;
import com.anand.spring.transactions.repository.PassengerRepository;
import com.anand.spring.transactions.repository.PaymentRepository;
import com.anand.spring.transactions.util.PaymentValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class TicketBookingService {

    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private PaymentRepository paymentRepository;

  @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public TicketBookingStatus bookTicket(TicketBookingRequest ticketBookingRequest){

        PassengerEntity passengerEntity = ticketBookingRequest.getPassengerEntity();
        passengerRepository.save(passengerEntity);

        PaymentEntity paymentEntity = ticketBookingRequest.getPaymentEntity();
       boolean payValidate =  PaymentValidationUtil.validateCreditLimit(paymentEntity.getAccountNo(),passengerEntity.getFare());
        if(payValidate) {
            paymentEntity.setPassengerId(passengerEntity.getPId());
            paymentEntity.setAmount(passengerEntity.getFare());
            paymentRepository.save(paymentEntity);
        }
        return new TicketBookingStatus("Success",paymentEntity.getAmount(), UUID.randomUUID().toString().split("-")[0],passengerEntity);
    }
}
