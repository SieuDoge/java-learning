package service;

import model.Booking;
import payment.PaymentMethod;
import repository.BookingRepository;

public class BookingService {
    private final BookingRepository bookingRepository;
    private final PaymentMethod payment;
    public BookingService(BookingRepository bookingRepository, PaymentMethod payment) {
        this.bookingRepository = bookingRepository;
        this.payment = payment;
    }

    public void placeBooking(Booking booking) {
        bookingRepository.save(booking);
        boolean success = payment.pay(booking.calculateFare());
        if (success) System.out.println("Booking placed successfully");
        else System.out.println("Booking failed");

    }
}
