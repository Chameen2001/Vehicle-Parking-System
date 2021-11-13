package Logic;

public class CargoLorry implements Vehicle {
    private final String number;
    private final String type;
    private final int maxWeight;
    private final int numOfPassenger;
    private String parkTime;
    private String leaveTime;
    private  Driver driver;

    public CargoLorry(String number, String type, int maxWeight, int numOfPassenger) {
        this.number = number;
        this.type = type;
        this.maxWeight = maxWeight;
        this.numOfPassenger = numOfPassenger;
    }

    @Override
    public void park(String vehicleNo, String type) {

    }

    @Override
    public void leavePark(String vehicleNo, String type) {

    }

    public int getNumOfPassenger() {
        return numOfPassenger;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public String getType() {
        return type;
    }

    public int getMaxWeight() {
        return maxWeight;
    }


    @Override
    public String getParkTime() {
        return parkTime;
    }

    @Override
    public void setParkTime(String parkTime) {
        this.parkTime = parkTime;
    }

    @Override
    public String getLeaveTime() {
        return leaveTime;
    }

    @Override
    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }
    @Override
    public void setDriver(Driver driver) {
        this.driver=driver;
    }

    @Override
    public Driver getDriver() {
        return driver;
    }
}