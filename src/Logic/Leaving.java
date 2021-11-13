package Logic;

import controller.MainFormController;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Leaving {
    public static Vehicle[] vehiclesArray = new Vehicle[14];

    public int vehicleIndex=0;
    MainFormController mainFormController;

    public Leaving() {
    }

    public void setMainFormController(MainFormController mainFormController){
        this.mainFormController=mainFormController;
    }

    public void addVehicle(Vehicle vehicle,Driver driver){
        vehicle.setLeaveTime(getTime());
        vehicle.setDriver(driver);
        vehiclesArray[vehicleIndex++]=vehicle;
    }

    public void remove(Vehicle vehicle){
        for(int i = 0 ; i < vehicleIndex; i++){
            if(vehicle==vehiclesArray[i]){
                for (int j=i; j<vehiclesArray.length-1;j++){
                    vehiclesArray[j]=vehiclesArray[j+1];
                }
                vehicleIndex--;
                break;
            }
        }
    }

    public void checkInLeave(Vehicle vehicle) {
        for(int i = 0;i<vehicleIndex;i++){
            if(vehicle==vehiclesArray[i]){
                mainFormController.leaveBtn.setDisable(true);
                break;
            }
            mainFormController.leaveBtn.setDisable(false);
        }
    }
    private String getTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }
}