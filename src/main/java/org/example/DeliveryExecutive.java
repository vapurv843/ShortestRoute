package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeliveryExecutive {
    Location startLocation;

    DeliveryExecutive(Location start) {
        this.startLocation = start;
    }

    public double calculateRouteTime(List<Order> sequence) {
        double currentTime = 0.0;
        Location position = startLocation;
        Set<Order> pickedUp = new HashSet<>();

        for (Order order : sequence) {
            if (!pickedUp.contains(order)) {
                currentTime += position.travelTimeTo(order.restaurantLocation);
                position = order.restaurantLocation;

                currentTime = Math.max(currentTime, order.preparationTime);

                pickedUp.add(order);
            }

            currentTime += position.travelTimeTo(order.consumerLocation);
            position = order.consumerLocation;
        }
        return currentTime;
    }
}
