package controller;

import Logic.Controller;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Arrays;

public class EnterNameFormController {
    public AnchorPane nameContext;
    public JFXComboBox nameCmb;
    String name=null ;
    Controller controller;

    public void initialize(){

        nameCmb.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            boolean checker=false;
            for(int i = 0 ; i < controller.leaving.vehicleIndex; i++){
                if(newValue.equals(controller.leaving.vehiclesArray[i].getDriver().getDriverName())){
                    checker=true;
                    break;
                }
            }
            if(checker){
                name=null;
                new Alert(Alert.AlertType.WARNING,"This Driver has busy right now\nChoose another",ButtonType.OK).show();
            }else {
                name= (String) newValue;
            }

        });

    }

    public void setController(Controller controller){
        this.controller=controller;
        String[] driverArray = new String[controller.dataBase.nextDriver];
        for(int i=0;i<controller.dataBase.nextDriver; i++){
            driverArray[i]=controller.dataBase.driversArray[i].getDriverName();
        }

        nameCmb.setItems(FXCollections.observableArrayList(Arrays.asList(driverArray)));

    }

    public void okMeth(ActionEvent actionEvent) {
        if(name!=null){
            controller.setLeaving(name);
            Stage stage = (Stage) nameContext.getScene().getWindow();
            stage.close();
        }else {
            new Alert(Alert.AlertType.WARNING,"Please select driver name first", ButtonType.OK).show();
        }

    }
}
