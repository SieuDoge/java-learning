package model;

public abstract class Vehicle {
    private int vehicleId;
    private String licensePlate;
    private String model;
    private String color;
    private int year;

    public Vehicle(int vehicleId, String licensePlate, String model, String color, int year) {
        this.vehicleId = vehicleId;
        this.licensePlate = licensePlate;
        this.model = model;
        this.color = color;
        this.year = year;
    }

    public abstract double getPricePerKm();

    public double calculateFare(double distanceKm) {
        return distanceKm * getPricePerKm();
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }
}
