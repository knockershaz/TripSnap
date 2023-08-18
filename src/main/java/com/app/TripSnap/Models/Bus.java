package com.app.TripSnap.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.HashMap;
import java.sql.Array;
import java.util.List;

@Entity
public class Bus {
    @Id
    private String busNo;
    private String busName;
    private String source;
    private String destination;
    @Column(name = "Distance(KM)")
    private int distance;
    private Date departure;
    private Date arrival;
    private String duration;

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public String getBusClass() {
        return busClass;
    }

    public void setBusClass(String busClass) {
        this.busClass = busClass;
    }

    public int[] getSeats() {
        return seats;
    }

    public void setSeats(int[] seats) {
        this.seats = seats;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    private String fare;
    public Bus(String busNo, String busName, String source, String destination, int distance, Date departure, Date arrival, String duration, String fare, Float rating, List<String> amenities, String busClass, HashMap<Integer, Integer> seats, int totalSeats) {
        this.busNo = busNo;
        this.busName = busName;
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.departure = departure;
        this.arrival = arrival;
        this.duration = duration;
        this.fare = fare;
        this.rating = rating;
        this.amenities = amenities;
        this.busClass = busClass;
        this.seats = new int[totalSeats+1];
        this.totalSeats = totalSeats;
    }

    private Float rating;
    private List<String> amenities;
    private String busClass;
    private int[] seats;
    private int totalSeats;
}
