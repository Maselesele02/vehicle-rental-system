package za.co.protogen;

import za.co.protogen.core.ReservationService;
import za.co.protogen.core.impl.ReservationServiceImpl;
import za.co.protogen.domain.Reservation;

import java.time.LocalDate;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        ReservationService reservationService = new ReservationServiceImpl();

        // Adding reservations
        Reservation reservation1 = new Reservation(1L, 1L, 1L, LocalDate.of(2023, 6, 10),
                LocalDate.of(2023, 6, 15), "New York", "Los Angeles");
        Reservation reservation2 = new Reservation(2L, 2L, 2L, LocalDate.of(2023, 6, 12),
                LocalDate.of(2023, 6, 18), "London", "Paris");

        reservationService.addReservation(reservation1);
        reservationService.addReservation(reservation2);

        // Retrieving reservations
        System.out.println("All Reservations:");
        List<Reservation> allReservations = reservationService.getAllReservations();
        displayReservationInformation(allReservations);

        // Get reservation by ID
        System.out.println("\nReservation with ID 1:");
        Reservation reservationById = reservationService.getReservationById(1);
        if (reservationById != null) {
            displayReservationInformation(List.of(reservationById));
        } else {
            System.out.println("Reservation not found.");
        }

        // Removing a reservation
        reservationService.removeReservation(2);

        // Retrieving reservations after removal
        System.out.println("\nAll Reservations after removal:");
        allReservations = reservationService.getAllReservations();
        displayReservationInformation(allReservations);
    }

    // method to display reservation information
    public static void displayReservationInformation(List<Reservation> reservations) {
        for (Reservation reservation : reservations) {
            System.out.println("ID: " + reservation.getId());
            System.out.println("User ID: " + reservation.getUserId());
            System.out.println("Car ID: " + reservation.getCarId());
            System.out.println("From Date: " + reservation.getFromDate());
            System.out.println("To Date: " + reservation.getToDate());
            System.out.println("Pickup Location: " + reservation.getPickUpLocation());
            System.out.println("Dropoff Location: " + reservation.getDropoffLocation());
            System.out.println();
        }
    }
}
