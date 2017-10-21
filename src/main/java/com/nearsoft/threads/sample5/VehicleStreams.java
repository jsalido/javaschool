package com.nearsoft.threads.sample5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class VehicleStreams {

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(VehicleType.CAR, "VTX1234", "red"));
        vehicles.add(new Vehicle(VehicleType.CAR, "VTV4221", "white", 8));
        vehicles.add(new Vehicle(VehicleType.CAR, "VYD3920", "blue"));
        vehicles.add(new Vehicle(VehicleType.CAR, "VTX3999", "white", 2));
        vehicles.add(new Vehicle(VehicleType.CAR, "VTZ1211", "green"));
        vehicles.add(new Vehicle(VehicleType.CAR, "VTV0001", "white"));

        // Use a stream to get only white vehicles
        List<Vehicle> whiteVehicles = vehicles.stream()
                .peek(v -> System.out.println("Current vehicle is " + v.getColor()))
                .filter(v -> v.getColor().equals("white"))
//                .filter(v -> v.getMaxPassengers() > 6)
                .collect(Collectors.toList());

        for (Vehicle v : whiteVehicles) {
            System.out.println(v);
        }

        System.out.println("count: " + whiteVehicles.stream().count());

        System.out.println("max: " + whiteVehicles.stream().max(new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                if (o1.getMaxPassengers() == o2.getMaxPassengers()) return 0;
                if (o1.getMaxPassengers() >= o2.getMaxPassengers()) {
                    return 1;
                }
                return -1;
            }
        }));

        System.out.println("min: " + whiteVehicles.stream().min(new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                if (o1.getMaxPassengers() == o2.getMaxPassengers()) return 0;
                if (o1.getMaxPassengers() >= o2.getMaxPassengers()) {
                    return 1;
                }
                return -1;
            }
        }));

        System.out.println("anyMatch (white): " + whiteVehicles.stream()
                .anyMatch(v -> v.getColor().equalsIgnoreCase("white")));
        System.out.println("anyMatch (blue): " + whiteVehicles.stream()
                .anyMatch(v -> v.getColor().equalsIgnoreCase("blue")));

        System.out.println("allMatch (white): " + whiteVehicles.stream()
                .allMatch(v -> v.getColor().equalsIgnoreCase("white")));
        System.out.println("allMatch (blue): " + whiteVehicles.stream()
                .allMatch(v -> v.getColor().equalsIgnoreCase("blue")));

        System.out.println("noneMatch (white): " + whiteVehicles.stream()
                .noneMatch(v -> v.getColor().equalsIgnoreCase("white")));
        System.out.println("noneMatch (blue): " + whiteVehicles.stream()
                .noneMatch(v -> v.getColor().equalsIgnoreCase("blue")));

        whiteVehicles.stream().forEach(v -> System.out.println(v.getLicensePlates()));

        System.out.println(whiteVehicles.stream().toArray().length);


        ConcurrentMap<String, List<Vehicle>> map = vehicles.parallelStream()
                .filter(v -> v.getType().equals(VehicleType.CAR))
                .collect(Collectors.groupingByConcurrent(Vehicle::getColor));

        map.forEach((k, l) -> System.out.println(k + ": " + l.size()));

        DoubleSummaryStatistics statistics = vehicles.parallelStream()
                .filter(v->v.getType().equals(VehicleType.CAR))
                .collect(Collectors.summarizingDouble(Vehicle::getMaxPassengers));
        System.out.println("Count: " + statistics.getCount());
        System.out.println("Min: " + statistics.getMin());
        System.out.println("Max: " + statistics.getMax());
        System.out.println("Avg: " + statistics.getAverage());
        System.out.println("Simple sum: " + statistics.getSum());

    }

}
