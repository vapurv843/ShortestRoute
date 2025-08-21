package org.example;

import java.util.*;

public class BestRouteFinderN {
    public static List<List<Order>> generatePermutations(List<Order> orders) {
        List<List<Order>> results = new ArrayList<>();
        permute(orders, 0, results);
        return results;
    }

    private static void permute(List<Order> arr, int k, List<List<Order>> results) {
        if (k == arr.size() - 1) {
            results.add(new ArrayList<>(arr));
        } else {
            for (int i = k; i < arr.size(); i++) {
                Collections.swap(arr, i, k);
                permute(arr, k + 1, results);
                Collections.swap(arr, k, i);
            }
        }
    }
    public static List<Order> greedyRoute(List<Order> orders, DeliveryExecutive aman) {
        List<Order> route = new ArrayList<>();
        Set<Order> delivered = new HashSet<>();
        Location current = aman.startLocation;
        double currentTime = 0.0;

        while (delivered.size() < orders.size()) {
            Order next = null;
            double bestCost = Double.MAX_VALUE;

            for (Order order : orders) {
                if (!delivered.contains(order)) {
                    double travelToR = current.travelTimeTo(order.restaurantLocation);
                    double waitTime = Math.max(0, order.preparationTime - (currentTime + travelToR));
                    double travelToC = order.restaurantLocation.travelTimeTo(order.consumerLocation);
                    double totalCost = travelToR + waitTime + travelToC;

                    if (totalCost < bestCost) {
                        bestCost = totalCost;
                        next = order;
                    }
                }
            }
            currentTime += current.travelTimeTo(next.restaurantLocation);
            current = next.restaurantLocation;
            currentTime = Math.max(currentTime, next.preparationTime);
            currentTime += current.travelTimeTo(next.consumerLocation);
            current = next.consumerLocation;

            delivered.add(next);
            route.add(next);
        }
        return route;
    }
}
