```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/mini-uber
@Language: Markdown
@Datetime: 16-08-23 23:08
```

class Location {
    double lat;
    double lng;
    public Location(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
public class MiniUber {
    private HashMap<Integer, Trip> onTripDriver;
    private HashMap<Integer, Location> freeDriver;

    public MiniUber() {
        // initialize your data structure here.
        this.onTripDriver = new HashMap<Integer, Trip>();
        this.freeDriver = new HashMap<Integer, Location>();
    }

    // @param driver_id an integer
    // @param lat, lng driver's location
    // return matched trip information if there have matched rider or null
    public Trip report(int driver_id, double lat, double lng) {
        // Write your code here
        if (onTripDriver.containsKey(driver_id)) {
            return onTripDriver.get(driver_id);
        }
        if (freeDriver.containsKey(driver_id)) {
            freeDriver.get(driver_id).lat = lat;
            freeDriver.get(driver_id).lng = lng;
        } else {
            freeDriver.put(driver_id, new Location(lat, lng));
        }
        return null;
    }

    // @param rider_id an integer
    // @param lat, lng rider's location
    // return a trip
    public Trip request(int rider_id, double lat, double lng) {
        // Write your code here
        Trip trip = new Trip(rider_id, lat, lng);
        double distance = -1;
        int driver_id = -1;
        for (Map.Entry<Integer, Location> entry : freeDriver.entrySet()) {
            Location location = entry.getValue();
            double dis = Helper.get_distance(location.lat, location.lng, lat, lng);
            if (distance < 0 || distance > dis) {
                driver_id = entry.getKey();
                distance = dis;
            }
        }

        if (driver_id != -1) {
            freeDriver.remove(driver_id);
        }
        trip.driver_id = driver_id;
        onTripDriver.put(driver_id, trip);
        return trip;
    }
}