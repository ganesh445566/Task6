package com.airline.management;



import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private String passportNumber;
    private List<Flight> bookedFlights;

    public Passenger(String name, String passportNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.bookedFlights = new ArrayList<>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }

    public List<Flight> getBookedFlights() { return bookedFlights; }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", bookedFlights=" + bookedFlights +
                '}';
    }

    public void bookFlight(Flight flight) {
        bookedFlights.add(flight);
        flight.bookFlight();
    }

    public void cancelBooking(Flight flight) {
        bookedFlights.remove(flight);
        flight.cancelBooking();
    }
}
