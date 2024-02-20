
package za.co.protogen.core.impl;

import za.co.protogen.core.ReservationService;
import za.co.protogen.domain.Reservation;
import za.co.protogen.utility.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationServiceImpl implements ReservationService {

    @Override
    public void addReservation(Reservation reservation) {
        Constant.reservations.add(reservation);
    }

    @Override
    public void removeReservation(long id) {
        Constant.reservations.removeIf(reservation -> reservation.getId() == id);
    }

    @Override
    public Reservation getReservationById(long id) {
        return Constant.reservations.stream()
                .filter(reservation -> reservation.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return new ArrayList<>(Constant.reservations);
    }

    @Override
    public void updateReservation(long id, Reservation updatedReservation) {
        Reservation reservationToUpdate = getReservationById(id);
        if (reservationToUpdate != null) {
            reservationToUpdate.setUserId(updatedReservation.getUserId());
            reservationToUpdate.setCarId(updatedReservation.getCarId());
            reservationToUpdate.setFromDate(updatedReservation.getFromDate());
            reservationToUpdate.setToDate(updatedReservation.getToDate());
            reservationToUpdate.setPickUpLocation(updatedReservation.getPickUpLocation());
            reservationToUpdate.setDropoffLocation(updatedReservation.getDropoffLocation());
        }
    }

    @Override
    public List<Reservation> searchReservations(long userId, long carId) {
        return Constant.reservations.stream()
                .filter(reservation -> (userId == 0 || reservation.getUserId() == userId) &&
                        (carId == 0 || reservation.getCarId() == carId))
                .collect(Collectors.toList());
    }
}
