package model;

public class Car7Seat extends Vehicle {
    public Car7Seat(int vehicleId, String licensePlate, String model, String color, int year) {
        super(vehicleId, licensePlate, model, color, year);
    }
    @Override
    public double getPricePerKm() {
        return 15000;
    }
}
