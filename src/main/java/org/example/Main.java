package org.example;

import java.util.Arrays;
import java.util.List;

import static org.example.BestRouteFinderN.generatePermutations;
import static org.example.BestRouteFinderN.greedyRoute;


public class Main {
    public static void main(String[] args) {
        Location amanStart = new Location(12.9352, 77.6245);
        Order o1 = new Order("C1", new Location(12.9600, 77.6387),
                "R1", new Location(12.9355, 77.6141), 15);
        Order o2 = new Order("C2", new Location(12.9500, 77.6300),
                "R2", new Location(12.9321, 77.6200), 10);
        Order o3 = new Order("C3", new Location(12.9400, 77.6350),
                "R3", new Location(12.9310, 77.6100), 12);

        List<Order> orders = Arrays.asList(o1, o2, o3);
        DeliveryExecutive aman = new DeliveryExecutive(amanStart);

        if (orders.size() <= 8) {
            List<List<Order>> permutations = generatePermutations(orders);
            double bestTime = Double.MAX_VALUE;
            List<Order> bestRoute = null;

            for (List<Order> seq : permutations) {
                double time = aman.calculateRouteTime(seq);
                if (time < bestTime) {
                    bestTime = time;
                    bestRoute = seq;
                }
            }

            System.out.println("Optimal route :");
            for (Order o : bestRoute) {
                System.out.println("Pickup " + o.restaurantName + " → Deliver " + o.consumerName);
            }
            System.out.printf("Total time: %.2f minutes%n", bestTime * 60);

        } else {
            List<Order> route = greedyRoute(orders, aman);
            double totalTime = aman.calculateRouteTime(route);

            System.out.println("Approximate route for large dataset:");
            for (Order o : route) {
                System.out.println("Pickup " + o.restaurantName + " → Deliver " + o.consumerName);
            }
            System.out.printf("Total time: %.2f minutes%n", totalTime * 60);
        }
    }

}
