package controller;

import Logic.*;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class AddVehicleFormController {


    public JFXTextField vehicleNumberTxt;
    public JFXTextField maximumWeightTxt;
    public JFXTextField noOfPassengersTxt;
    public JFXComboBox vehicleTypeCmb;
    Controller controller;
    String type;

    public void initialize(){

        vehicleTypeCmb.getItems().addAll("Van","Bus","CargoLorry");

        vehicleTypeCmb.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            type= (String) newValue;
        });

    }

    public void setController(Controller controller){
        this.controller=controller;
    }

    public void addVehicleMeth(ActionEvent actionEvent) {
        if(vehicleNumberTxt.getText().equals("") || maximumWeightTxt.getText().equals("") || noOfPassengersTxt.getText().equals("") || vehicleTypeCmb.getSelectionModel().getSelectedItem()==null){
            new Alert(Alert.AlertType.WARNING,"Some field or fields are empty",ButtonType.OK).show();
        }else {
            if(type.equals("Van")){
                controller.addVehicle(new Van(vehicleNumberTxt.getText(),"Van",Integer.parseInt(maximumWeightTxt.getText()),Integer.parseInt(noOfPassengersTxt.getText())));
            }else if(type.equals("CargoLorry")){
                controller.addVehicle(new CargoLorry(vehicleNumberTxt.getText(),"Cargo Lorry",Integer.parseInt(maximumWeightTxt.getText()),Integer.parseInt(noOfPassengersTxt.getText())));
            }else {
                controller.addVehicle(new Bus(vehicleNumberTxt.getText(),"Bus",Integer.parseInt(maximumWeightTxt.getText()),Integer.parseInt(noOfPassengersTxt.getText())));
            }
            Stage stage = (Stage) vehicleNumberTxt.getScene().getWindow();
            stage.close();
            new Alert(Alert.AlertType.CONFIRMATION,"Driver Added Successfully", ButtonType.OK).show();
        }




    }
}
