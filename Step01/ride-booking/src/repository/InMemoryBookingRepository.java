package repository;

import model.Booking;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookingRepository implements BookingRepository {
    private List<Booking> bookings = new ArrayList<>();
    @Override
    public void save(Booking booking) {
        this.bookings.add(booking);
    }
    @Override
    public Booking findById(int id) {
        for (Booking book : bookings) {
            if(book.getId() == id) {
                return book;
            }
        }
        return null;
    }
    @Override
    public List<Booking> findByCustomerId(int customerId) {
        List<Booking> result = new ArrayList<>();

        for (Booking booking : bookings) {
            if (booking.getCustomer().getCustomerId() == customerId) {
                result.add(booking);
            }
        }

        return result;
    }
}
