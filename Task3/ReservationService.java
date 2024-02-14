package za.co.protogen.core;

import za.co.protogen.domain.Reservation;

import java.util.List;

public interface ReservationService {
    void addReservation(Reservation reservation);
    void removeReservation(long id);
    Reservation getReservationById(long id);
    List<Reservation> getAllReservations();
    void updateReservation(long id, Reservation updatedReservation);
    List<Reservation> searchReservations(long userId, long carId);
}
