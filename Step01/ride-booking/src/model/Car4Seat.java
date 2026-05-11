package model;

public class Car4Seat extends Vehicle{
    public Car4Seat(int vehicleId, String licensePlate, String model, String color, int year) {
        super(vehicleId, licensePlate, model, color, year);
    }
    @Override
    public double getPricePerKm() {
        return 12000;
    }
}
