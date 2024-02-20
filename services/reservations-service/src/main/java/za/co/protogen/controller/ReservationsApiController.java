package za.co.protogen.controller;

import org.springframework.web.bind.annotation.*;
import za.co.protogen.domain.Reservation;
import za.co.protogen.utility.Constant;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationsApiController {

    // Retrieving all reservations
    @GetMapping
    public List<Reservation> getAllReservations() {
        return Constant.getReservations(); 
    }

    // Retrieving a reservation by ID
    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable long id) {
        return Constant.getReservations().stream()
                .filter(reservation -> reservation.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Adding a new reservation
    @PostMapping
    public void addReservation(@RequestBody Reservation reservation) {
        Constant.getReservations().add(reservation); 
    }

    // Updating an existing reservation
    @PutMapping("/{id}")
    public void updateReservation(@PathVariable long id, @RequestBody Reservation updatedReservation) {
        List<Reservation> reservations = Constant.getReservations(); 
        for (int i = 0; i < reservations.size(); i++) {
            Reservation reservation = reservations.get(i);
            if (reservation.getId() == id) {
                reservations.set(i, updatedReservation);
                return;
            }
        }
    }

    // Deleting a reservation by ID
    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable long id) {
        Constant.getReservations().removeIf(reservation -> reservation.getId() == id); 
    }
}
