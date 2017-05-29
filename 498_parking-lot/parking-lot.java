/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/parking-lot
@Language: Java
@Datetime: 16-08-05 08:01
*/

// enum type for Vehicle
enum VehicleSize {
    Motorcycle,
    Compact,
    Large,
}

abstract class Vehicle {
    // Write your code here
    protected VehicleSize size;
    protected int spots_needed;
    ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
    public int getSpotsNeeded() {
        return spots_needed;
    }
    public VehicleSize getSize() {
        return size;
    }
    public void parkInSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }
    public void clearSpots() {
        for (ParkingSpot spot : parkingSpots) {
            spot.removeVehicle();
        }
        parkingSpots.clear();
    }
    public abstract boolean canFitInSpot(ParkingSpot spot);
}

class Motorcycle extends Vehicle {
    // Write your code here
    public Motorcycle() {
        size = VehicleSize.Motorcycle;
        spots_needed = 1;
    }
    public boolean canFitInSpot(ParkingSpot spot) {
        return true;
    }
}

class Car extends Vehicle {
    // Write your code here
    public Car() {
        size = VehicleSize.Compact;
        spots_needed = 1;
    }
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact;
    }
}

class Bus extends Vehicle {
    // Write your code here
    public Bus() {
        size = VehicleSize.Large;
        spots_needed = 5;
    }
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large;
    }
}

class ParkingSpot {
    private Vehicle vehicle = null;
    private VehicleSize size;
    private int spotNumber;//index
    private int row;
    private Level level;
    public ParkingSpot(Level level, int row, int spotNumber, VehicleSize size) {
        this.level = level;
        this.row = row;
        this.spotNumber = spotNumber;
        this.size = size;
    }
    public boolean isAvailable() {
        return vehicle == null;
    }
    public boolean canFitVehicle(Vehicle vehicle) {
        if (!isAvailable()) {
            return false;
        }
        if (vehicle.canFitInSpot(this)) {
            return true;
        }
        return false;
    }
    public VehicleSize getSize() {
        return size;
    }
    public boolean park(Vehicle vehicle) {
        if (!canFitVehicle(vehicle)) {
            return false;
        }
        this.vehicle = vehicle;
        vehicle.parkInSpot(this);
        return true;
    }
    public void removeVehicle() {
        level.spotFreed();
        this.vehicle = null;
    }
    public int getRow() {
        return row;
    }
    public int getSpotNumber() {
        return spotNumber;
    }
}
/* Represents a level in a parking garage */
class Level {
    // Write your code here
    private int floor;
    private int num_rows;
    private int spots_per_row;
    private int availableSpots;
    private ParkingSpot[] spots;
    public Level(int floor, int num_rows, int spots_per_row) {
        this.floor = floor;
        this.num_rows = num_rows;
        this.spots_per_row = spots_per_row;
        this.availableSpots = 0;
        int numberSpots = 0;
        spots = new ParkingSpot[num_rows * spots_per_row];
        for (int row = 0; row < num_rows; ++row) {
            for (int spot = 0; spot < spots_per_row / 4; ++spot) {
                VehicleSize sz = VehicleSize.Motorcycle;
                spots[numberSpots] = new ParkingSpot(this, row, numberSpots, sz);
                numberSpots ++;
            }
            for (int spot = spots_per_row / 4; spot < spots_per_row / 4 * 3; ++spot) {
                VehicleSize sz = VehicleSize.Compact;
                spots[numberSpots] = new ParkingSpot(this, row, numberSpots, sz);
                numberSpots ++;
            }
            for (int spot = spots_per_row / 4 * 3; spot < spots_per_row; ++spot) {
                VehicleSize sz = VehicleSize.Large;
                spots[numberSpots] = new ParkingSpot(this, row, numberSpots, sz);
                numberSpots ++;
            }
        }
        this.availableSpots = numberSpots;
    }
    public boolean parkVehicle(Vehicle vehicle) {
        if (availableSpots < vehicle.getSpotsNeeded()) {
            return false;
        }
        int spotNumber = findAvailableSpots(vehicle);
        if (spotNumber < 0) {
            return false;
        }
        return parkStartingAtSpot(spotNumber, vehicle);
    }
    
    private int findAvailableSpots(Vehicle vehicle) {
        int spotsNeeded = vehicle.getSpotsNeeded();
        int preRow = -1;
        int spotsFound = 0;
        for (int i = 0; i < spots.length; i++) {
            int curRow = spots[i].getRow();
            if (preRow != curRow) {
                spotsFound = 0;
                preRow = curRow;
            }
            if (spots[i].canFitVehicle(vehicle)) {
                spotsFound++;
            } else {
                spotsFound = 0;
            }
            if (spotsFound == spotsNeeded) {
                return i - spotsNeeded + 1;
            }
        }
        return -1;
    }
    
    private boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle) {
        vehicle.clearSpots();//change a place to park
        boolean success = true;
        for (int i = spotNumber; i < spotNumber + vehicle.getSpotsNeeded(); i++) {
			 success &= spots[i].park(vehicle);
		}
		
		availableSpots -= vehicle.getSpotsNeeded();
		return success;
    }
    
    public void spotFreed() {
        availableSpots++;
    }
    
    public int availableSpots() {
        return availableSpots;
    }
}

public class ParkingLot {
    private Level[] levels;
    private int num_level;
    // @param n number of leves
    // @param num_rows  each level has num_rows rows of spots
    // @param spots_per_row each row has spots_per_row spots
    public ParkingLot(int n, int num_rows, int spots_per_row) {
        // Write your code here
        this.num_level = n;
        levels = new Level[num_level];
        for (int i = 0; i < num_level; i++) {
            levels[i] = new Level(i, num_rows, spots_per_row);
        }
    }

    // Park the vehicle in a spot (or multiple spots)
    // Return false if failed
    public boolean parkVehicle(Vehicle vehicle) {
        // Write your code here
        for (int i = 0; i < levels.length; i++) {
            if (levels[i].parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    // unPark the vehicle
    public void unParkVehicle(Vehicle vehicle) {
        // Write your code here
        vehicle.clearSpots();
    }
}