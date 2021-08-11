package com.example.systemgms.model;

public class Bookings {


        private String eventName;
        private int bookingId;
        private String username;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Bookings(String eventName, int bookingId, String username) {
        this.eventName = eventName;
        this.bookingId = bookingId;
        this.username = username;
    }
}

