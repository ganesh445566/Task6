package com.airline.main;


import com.airline.management.*;
import com.airline.utilities.*;

public class Main {
    public static void main(String[] args) {
        Airline airline = new Airline();

        // Adding flights
        Flight flight1 = new Flight("F001", "NYC", "LAX", "08:00", "11:00", true);
        Flight flight2 = new Flight("F002", "LAX", "SFO", "12:00", "13:30", true);
        Flight flight3 = new Flight("F003", "SFO", "SEA", "15:00", "17:00", true);
        airline.addFlight(flight1);
        airline.addFlight(flight2);
        airline.addFlight(flight3);

        // Registering passengers
        Passenger passenger1 = new Passenger("Alice", "P001");
        Passenger passenger2 = new Passenger("Bob", "P002");
        airline.registerPassenger(passenger1);
        airline.registerPassenger(passenger2);

        // Booking flights
        airline.bookFlight("P001", "F001");
        airline.bookFlight("P002", "F002");

        // Canceling booking
        airline.cancelBooking("P001", "F001");

        // Listing available and booked flights
        System.out.println("Available Flights:");
        for (Flight flight : airline.listAvailableFlights()) {
            System.out.println(flight);
        }

        System.out.println("\nBooked Flights:");
        for (Flight flight : airline.listBookedFlights()) {
            System.out.println(flight);
        }

        // String Utility Tests
        System.out.println("\nString Utilities:");
        System.out.println("Count Occurrences: " + StringUtil.countOccurrences("Hello World", 'o'));
        System.out.println("Reverse String: " + StringUtil.reverseString("Hello"));
        System.out.println("Is Palindrome: " + StringUtil.isPalindrome("madam"));
        System.out.println("Capitalize Words: " + StringUtil.capitalizeWords("hello world"));

        // Wrapper Utility Tests
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.0, 2.0, 3.0, 4.0, 5.0};
        System.out.println("\nWrapper Utilities:");
        System.out.println("Find Max: " + WrapperUtil.findMax(intArray));
        System.out.println("Calculate Average: " + WrapperUtil.calculateAverage(doubleArray));
        System.out.println("Convert to Boolean Array: " + java.util.Arrays.toString(WrapperUtil.convertToBooleanArray("1101")));
        Boolean[] boolArray = {true, false, true, false};
        System.out.println("Convert to Binary String: " + WrapperUtil.convertToBinaryString(boolArray));
    }
}
