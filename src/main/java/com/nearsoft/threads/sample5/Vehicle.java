package com.nearsoft.threads.sample5;

public class Vehicle {

    private VehicleType type;
    private String licensePlates;
    private String color;
    private int maxPassengers;

    public Vehicle(VehicleType type, String licensePlates, String color) {
        this.type = type;
        this.licensePlates = licensePlates;
        this.color = color;
        this.maxPassengers = 5;
    }

    public Vehicle(VehicleType type, String licensePlates, String color, int maxPassengers) {
        this.type = type;
        this.licensePlates = licensePlates;
        this.color = color;
        this.maxPassengers = maxPassengers;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type=" + type +
                ", licensePlates='" + licensePlates + '\'' +
                ", color='" + color + '\'' +
                ", maxPassengers=" + maxPassengers +
                '}';
    }


}
