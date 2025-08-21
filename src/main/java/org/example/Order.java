package org.example;

public class Order {
    String consumerName;
    Location consumerLocation;
    String restaurantName;
    Location restaurantLocation;
    double preparationTime;

    Order(String consumerName, Location cLoc, String restaurantName, Location rLoc, double prepTimeMinutes) {
        this.consumerName = consumerName;
        this.consumerLocation = cLoc;
        this.restaurantName = restaurantName;
        this.restaurantLocation = rLoc;
        this.preparationTime = prepTimeMinutes / 60.0;
    }
}
