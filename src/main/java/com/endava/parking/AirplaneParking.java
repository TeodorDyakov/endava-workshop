package com.endava.parking;

import com.endava.PaymentProcessor;
import com.endava.domainModel.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class AirplaneParking {
    private final int CAPACITY;
    private final BigDecimal PRICE_PER_MINUTE;
    private Map<Vehicle, ParkingTicket> parkedVehicles = new HashMap<>();
    private List<Integer> freeSpots = new ArrayList<>();
    //injected through constructor
    private PaymentProcessor paymentProcessor;

    public AirplaneParking(int capacity, PaymentProcessor paymentProcessor, BigDecimal PRICE_PER_MINUTE){
        this.CAPACITY = capacity;
        IntStream.range(0, capacity).forEach(i -> freeSpots.add(i));
        this.PRICE_PER_MINUTE = PRICE_PER_MINUTE;
        this.paymentProcessor = paymentProcessor;
    }

    public boolean enterVehicle(Vehicle v){
        if(getNumberOfFreeSpots() > 0){
            Random rng = new Random();
            int spot = rng.nextInt(freeSpots.size());
            freeSpots.remove(spot);
            parkedVehicles.put(v, new ParkingTicket(spot, LocalDateTime.now()));
            return true;
        }
        return false;
    }

    public BigDecimal getPriceToPay(ParkingTicket ticket){
        long durationMinutes = ChronoUnit.MINUTES.between(ticket.getIssueTime(), LocalDateTime.now());
        return PRICE_PER_MINUTE.multiply(new BigDecimal(durationMinutes));
    }
    public boolean exitVehicle(Vehicle v){
        ParkingTicket ticket = parkedVehicles.get(v);
        BigDecimal priceToPay = getPriceToPay(ticket);

        if(paymentProcessor.payPrice(priceToPay)){
            parkedVehicles.remove(v);
            freeSpots.add(ticket.getSpotNumber());
            return true;
        }

        return false;
    }

    public int getNumberOfFreeSpots(){
        return freeSpots.size();
    }
}
