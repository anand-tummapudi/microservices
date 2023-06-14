package com.anand.spring.transactions.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerEntity {
    @Id
    @GeneratedValue
    private long pId;
    private String name;
    private String email;
    private String source;
    private String destination;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date travelDate;
    private String pickupTime;
    private String arrivalTime;
    private double fare;
}
