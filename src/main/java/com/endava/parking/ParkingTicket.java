package com.endava.parking;

import java.time.LocalDateTime;

public class ParkingTicket {

    private int spotNumber;
    private LocalDateTime issueTime;

    public ParkingTicket(int spotNumber, LocalDateTime issueTime) {
        this.spotNumber = spotNumber;
        this.issueTime = issueTime;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public LocalDateTime getIssueTime() {
        return issueTime;
    }
}
