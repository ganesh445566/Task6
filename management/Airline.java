package com.airline.management;


import java.util.ArrayList;
import java.util.List;

public class Airline {
 private List<Flight> flights;
 private List<Passenger> passengers;

 public Airline() {
     this.flights = new ArrayList<>();
     this.passengers = new ArrayList<>();
 }

 public void addFlight(Flight flight) {
     flights.add(flight);
 }

 public void removeFlight(String flightNumber) {
     flights.removeIf(flight -> flight.getFlightNumber().equals(flightNumber));
 }

 public void registerPassenger(Passenger passenger) {
     passengers.add(passenger);
 }

 public void unregisterPassenger(String passportNumber) {
     passengers.removeIf(passenger -> passenger.getPassportNumber().equals(passportNumber));
 }

 public void bookFlight(String passportNumber, String flightNumber) {
     Passenger passenger = passengers.stream()
             .filter(p -> p.getPassportNumber().equals(passportNumber))
             .findFirst()
             .orElse(null);

     Flight flight = flights.stream()
             .filter(f -> f.getFlightNumber().equals(flightNumber) && f.isAvailable())
             .findFirst()
             .orElse(null);

     if (passenger != null && flight != null) {
         passenger.bookFlight(flight);
     }
 }

 public void cancelBooking(String passportNumber, String flightNumber) {
     Passenger passenger = passengers.stream()
             .filter(p -> p.getPassportNumber().equals(passportNumber))
             .findFirst()
             .orElse(null);

     Flight flight = flights.stream()
             .filter(f -> f.getFlightNumber().equals(flightNumber))
             .findFirst()
             .orElse(null);

     if (passenger != null && flight != null) {
         passenger.cancelBooking(flight);
     }
 }

 public List<Flight> listAvailableFlights() {
     List<Flight> availableFlights = new ArrayList<>();
     for (Flight flight : flights) {
         if (flight.isAvailable()) {
             availableFlights.add(flight);
         }
     }
     return availableFlights;
 }

 public List<Flight> listBookedFlights() {
     List<Flight> bookedFlights = new ArrayList<>();
     for (Flight flight : flights) {
         if (!flight.isAvailable()) {
             bookedFlights.add(flight);
         }
     }
     return bookedFlights;
 }
}
