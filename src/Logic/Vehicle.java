package Logic;

public interface Vehicle {
    public static final String number="";
    public static final String type="";
    public static final int maxWeight=0;
    public static final int numOfPassenger=0;
    public static final String parkTime=null;
    public static final String leaveTime=null;
    Driver driver=null;

    public void park(String vehicleNo,String type);
    public void leavePark(String vehicleNo,String type);
    public String getNumber();

    public String getType();

    public int getMaxWeight();

    public int getNumOfPassenger();

    public String getParkTime();

    public void setParkTime(String parkTime);

    public String getLeaveTime();

    public void setLeaveTime(String leaveTime);

    public void setDriver(Driver driver);

    public Driver getDriver();

}