package model;

public class MotorBike extends Vehicle {
    public MotorBike(int vehicleId, String licensePlate, String model, String color, int year) {
        super(vehicleId, licensePlate, model, color, year);
    }

    @Override
    public double getPricePerKm() {
        return 8000;
    }
}
