package repository;

import model.Booking;

import java.util.List;

public interface BookingRepository {
    void save(Booking booking);
    Booking findById(int id);
    List<Booking> findByCustomerId(int customerId);
}
