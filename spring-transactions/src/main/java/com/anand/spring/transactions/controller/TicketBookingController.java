package com.anand.spring.transactions.controller;

import com.anand.spring.transactions.dto.TicketBookingRequest;
import com.anand.spring.transactions.dto.TicketBookingStatus;
import com.anand.spring.transactions.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketBookingController {

    @Autowired
    private TicketBookingService ticketBookingService;
    @PostMapping("/bookTicket")
    public TicketBookingStatus bookTicket(@RequestBody TicketBookingRequest ticketBookingRequest){
        return ticketBookingService.bookTicket(ticketBookingRequest);
    }
}
