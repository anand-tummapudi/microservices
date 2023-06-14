package com.anand.spring.transactions.dto;

import com.anand.spring.transactions.entity.PassengerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketBookingStatus {
    private String status;
    private double totalFare;
    private String pnrNo;
    private PassengerEntity passengerEntity;
}
