package Logic;

import controller.MainFormController;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Scanner;

public class Controller {
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    public DataBase dataBase = new DataBase();
    public Parking parking = new Parking();
    public Leaving leaving = new Leaving();
    public Vehicle vehicle=null;
    MainFormController mainFormController;
    public Controller(){

    }



    public String getVehicle(String vehicleNo) {
        for(int i = 0; i< dataBase.vehiclesArray.length; i++){
            if(dataBase.vehiclesArray[i].getNumber().equals(vehicleNo)){
                vehicle= dataBase.vehiclesArray[i];
                parking.checkInPark(vehicle);
                leaving.checkInLeave(vehicle);
                return vehicle.getType();
            }

        }
        return "";
    }



    public int park(){
        int slot;
        if(vehicle!=null){
            leaving.remove(vehicle);
            slot=parking.park(vehicle);
            if(slot>=0 & slot<=3){
                return (slot+1);
            }else if(slot==-1){
                return 14;
            }else if(slot==4 || slot==5){
                return slot+8;
            }else {
                return slot-5;
            }
        }else{
            new Alert(Alert.AlertType.ERROR,"Please Select The Vehicle Number", ButtonType.OK).show();
        }

        return slot=0;
    }

    public void addVehicle(Vehicle vehicle){
        dataBase.addVehicle(vehicle);
    }
    public void addDriver(Driver driver){
        dataBase.addDriver(driver);
    }


    public void setLeaving(String name1){
        String name = name1;
        for (int i = 0 ; i < dataBase.driversArray.length ; i++){
            if(name.equals(dataBase.driversArray[i].getDriverName())){
                Driver driver = dataBase.driversArray[i];
                leaving.addVehicle(vehicle,driver);
                parking.remove(vehicle);
                mainFormController.parkBtn.setDisable(false);
                mainFormController.leaveBtn.setDisable(true);
                break;
            }
        }

    }

    public void setMainFormController(MainFormController mainFormController){
        this.mainFormController=mainFormController;
        parking.setMainFormController(this.mainFormController);
        leaving.setMainFormController(this.mainFormController);
    }

}
