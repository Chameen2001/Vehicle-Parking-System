package Logic;

import controller.MainFormController;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parking {

    public static Van[] vansArray = new Van[6];
    public static Bus[] busesArray = new Bus[1];
    public static CargoLorry[] cargoLorriesArray = new CargoLorry[7];


    MainFormController mainFormController;
    Parking(){
    }

    public void setMainFormController(MainFormController mainFormController){
        this.mainFormController=mainFormController;
    }

    public String checkType(Vehicle vehicle){
        if(vehicle.getType().equals("Van")){
            return "Van";
        }else if(vehicle.getType().equals("Bus")){
            return "Bus";
        }else {
            return "CargoLorry";
        }
    }

    public int park(Vehicle vehicle){
        int slot=-1;
        if(checkType(vehicle).equals("Van")){
            for (int i=0;i<vansArray.length;i++){
                if(vansArray[i]==null){
                    vehicle.setParkTime(getTime());
                    vansArray[i]=(Van) vehicle;
                    mainFormController.parkBtn.setDisable(true);
                    mainFormController.leaveBtn.setDisable(false);
                    return i;
                }
            }
        }else if(checkType(vehicle).equals("Bus")){
            vehicle.setParkTime(getTime());
            busesArray[0]=(Bus)vehicle;
            mainFormController.parkBtn.setDisable(true);
            mainFormController.leaveBtn.setDisable(false);
            return -1;
        }else{
            for (int i=0;i<cargoLorriesArray.length;i++){
                if (cargoLorriesArray[i]==null){
                    vehicle.setParkTime(getTime());
                    cargoLorriesArray[i]= (CargoLorry) vehicle;
                    mainFormController.parkBtn.setDisable(true);
                    mainFormController.leaveBtn.setDisable(false);
                    return i+10;
                }
            }
        }
        return slot;
    }

    public void remove(Vehicle vehicle){
        if(vehicle.getType().equals("Van")){

            for (int i = 0 ; i < vansArray.length ; i++){
                if(vehicle==vansArray[i]){
                    vansArray[i]=null;
                    break;
                }
            }

        }else if(vehicle.getType().equals("Cargo Lorry")){
            for (int i= 0 ; i< cargoLorriesArray.length ; i++){
                if(vehicle==cargoLorriesArray[i]){
                    cargoLorriesArray[i]=null;
                    break;
                }
            }
        }else {
            busesArray[0]=null;
        }

    }

    public void checkInPark(Vehicle vehicle){
        if(checkType(vehicle).equals("Van")){
            for (int i = 0 ; i < vansArray.length; i++ ){
                if(vehicle==vansArray[i]){
                    mainFormController.parkBtn.setDisable(true);
                    break;
                }
                mainFormController.parkBtn.setDisable(false);
            }
        }else if (checkType(vehicle).equals("Bus")){
            if(busesArray[0]==vehicle){
                mainFormController.parkBtn.setDisable(true);
            }else {
                mainFormController.parkBtn.setDisable(false);
            }

        }else {
            for (int i = 0 ; i< cargoLorriesArray.length;i++){
                if(vehicle==cargoLorriesArray[i]){
                    mainFormController.parkBtn.setDisable(true);
                    break;
                }
                mainFormController.parkBtn.setDisable(false);
            }
        }
    }

    private String getTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

}