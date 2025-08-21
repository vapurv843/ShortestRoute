package org.example;

public class Location {
    double latitude, longitude;

    Location(double lat, double lon) {
        this.latitude = lat;
        this.longitude = lon;
    }

    public double distanceTo(Location other) {
        final int EARTH_RADIUS = 6371;
        double latDistance = Math.toRadians(other.latitude - this.latitude);
        double lonDistance = Math.toRadians(other.longitude - this.longitude);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(other.latitude))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        return EARTH_RADIUS * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    }

    public double travelTimeTo(Location other) {
        return distanceTo(other) / 20.0;
    }
}
