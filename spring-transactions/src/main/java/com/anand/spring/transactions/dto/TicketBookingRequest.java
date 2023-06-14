package com.anand.spring.transactions.dto;

import com.anand.spring.transactions.entity.PassengerEntity;
import com.anand.spring.transactions.entity.PaymentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketBookingRequest {

    private PassengerEntity passengerEntity;
    private PaymentEntity paymentEntity;

}
