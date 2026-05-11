import model.*;
import payment.MomoPayment;
import payment.PaymentMethod;
import repository.BookingRepository;
import repository.InMemoryBookingRepository;
import service.BookingService;

import java.awt.print.Book;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Vehicle car4 = new Car4Seat(2, "456", "Toyota Vios", "Black", 2020);
        Vehicle car7 = new Car7Seat(3, "789", "Toyota Innova", "Silver", 2021);
        Vehicle bike = new MotorBike(1, "123", "Honda Vision", "White", 2016);

        Customer Khach1 = new Customer(1, "Huynh", "Nguyen", "0888444666");
        Driver Driver1 = new Driver(1, "Ryan", "Nguyen", "036366767");
        Booking Book1 = new Booking(1, Khach1, Driver1, car4, "SaiGon", "DaLat", 278);

        BookingRepository repository = new InMemoryBookingRepository();
        PaymentMethod payment = new MomoPayment();

        BookingService bookingService = new BookingService(repository, payment);

        bookingService.placeBooking(Book1);
    }
}