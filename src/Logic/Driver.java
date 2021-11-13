package Logic;

public class Driver {
    private String driverName;
    private String NIC;
    private String drivingLicenseNum;
    private String address;
    private int contactNum;

    public Driver(String driverName, String NIC, String drivingLicenseNum, String address, int contactNum) {
        this.driverName = driverName;
        this.NIC = NIC;
        this.drivingLicenseNum = drivingLicenseNum;
        this.address = address;
        this.contactNum = contactNum;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getDrivingLicenseNum() {
        return drivingLicenseNum;
    }

    public void setDrivingLicenseNum(String drivingLicenseNum) {
        this.drivingLicenseNum = drivingLicenseNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContactNum() {
        return contactNum;
    }

    public void setContactNum(int contactNum) {
        this.contactNum = contactNum;
    }
}
