package model;

public class Booking {
    private int id;
    private Customer customer;
    private Driver driver;
    private Vehicle vehicle;
    private String from;
    private String to;
    private double distance;

    public Booking(int id, Customer customer, Driver driver, Vehicle vehicle,
                   String from, String to, double distance) {
        this.id = id;
        this.customer = customer;
        this.driver = driver;
        this.vehicle = vehicle;
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public double calculateFare() {
        return vehicle.calculateFare(distance);
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }
}
