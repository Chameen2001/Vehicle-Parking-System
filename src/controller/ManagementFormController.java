package controller;

import Logic.Controller;
import TableDataClasses.InParkingData;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public class ManagementFormController {
    public BorderPane managementFormContext;
    public JFXComboBox optionCmb;
    public BorderPane tableContext;
    public TableView onParkingTable;
    public TableColumn vehicleNumberClm;
    public TableColumn vehicleTypeClm;
    public TableColumn parkinSlotClm;
    public TableColumn parkedTimeClm;
    public BorderPane tableAndMapPane;

    public Pane slot1;
    public Pane slot2;
    public Pane slot3;
    public Pane slot4;
    public Pane slot5;
    public Pane slot6;
    public Pane slot7;
    public Pane slot8;
    public Pane slot9;
    public Pane slot10;
    public Pane slot11;
    public Pane slot12;
    public Pane slot13;
    public Pane slot14;

    Pane[] panes = new Pane[]{slot1,slot2,slot3,slot4,slot5,slot6,slot7,slot8,slot9,slot10,slot11,slot12,slot13,slot14};


    MainFormController mainFormController;

    InParkingData[] parkingData = new InParkingData[14];
    int nextIndex=0;

    Controller controller;
    OnDeliveryTableFormController onDeliveryTableFormController;

    public void initialize(){
        optionCmb.getItems().addAll("In Parking","On Delivery");
        optionCmb.setValue("In Parking");

        optionCmb.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals("In Parking")){
                tableContext.getChildren().clear();
                tableContext.centerProperty().set(tableAndMapPane);
            }else {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/OnDeliveryTableForm.fxml"));
                try {
                    Parent parent = fxmlLoader.load();
                    tableContext.getChildren().clear();
                    tableContext.centerProperty().set(parent);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                onDeliveryTableFormController= fxmlLoader.getController();
                onDeliveryTableFormController.setController(controller);
            }
        });
    }

    public void addVehicleMeth(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AddVehicleForm.fxml"));
        Parent parent = fxmlLoader.load();
        AddVehicleFormController addVehicleFormController = fxmlLoader.getController();
        addVehicleFormController.setController(this.controller);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add Vehicle");
        stage.show();
    }

    public void addDriverMeth(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AddDriverForm.fxml"));
        Parent parent = fxmlLoader.load();
        AddDriverFormController addDriverFormController = fxmlLoader.getController();
        addDriverFormController.setController(this.controller);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add Driver");
        stage.show();
    }

    public void logOutMeth(ActionEvent actionEvent) throws IOException {
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION
                , "Are you sure want to log out?", yes, no);
        alert.setTitle("Confirmation Alert");
        /*1.8-->(windows null pointer exception)-->java-1.8*/
        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(no) == yes) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MainForm.fxml"));
            Parent parent = fxmlLoader.load();
            mainFormController=fxmlLoader.getController();
            mainFormController.setController(controller);
            Scene scene = new Scene(parent);
            Stage stage = (Stage) managementFormContext.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Parking System");
            stage.show();

        } else {

        }


    }
    public void setController(Controller controller){
        this.controller=controller;

        vehicleNumberClm.setCellValueFactory(new PropertyValueFactory("vehicleNumber"));
        vehicleTypeClm.setCellValueFactory(new PropertyValueFactory("vehicleType"));
        parkinSlotClm.setCellValueFactory(new PropertyValueFactory("slot"));
        parkedTimeClm.setCellValueFactory(new PropertyValueFactory("parkedTime"));


        for(int i = 0 ; i<controller.parking.vansArray.length; i++){
            if(controller.parking.vansArray[i]!=null){
                parkingData[nextIndex++]=new InParkingData(controller.parking.vansArray[i].getNumber(),controller.parking.vansArray[i].getType(),i<=3?i+1:i+8,controller.parking.vansArray[i].getParkTime());
                onParkingTable.setItems(FXCollections.observableArrayList(Arrays.asList(parkingData)));
            }
        }
        for(int i = 0 ; i<controller.parking.cargoLorriesArray.length; i++){
            if(controller.parking.cargoLorriesArray[i]!=null){
                parkingData[nextIndex++]=new InParkingData(controller.parking.cargoLorriesArray[i].getNumber(),controller.parking.cargoLorriesArray[i].getType(),i+5,controller.parking.cargoLorriesArray[i].getParkTime());
                onParkingTable.setItems(FXCollections.observableArrayList(Arrays.asList(parkingData)));
            }
        }
        for(int i = 0 ; i<controller.parking.busesArray.length; i++){
            if(controller.parking.busesArray[i]!=null){
                System.out.println("awa");
                parkingData[nextIndex++]=new InParkingData(controller.parking.busesArray[i].getNumber(),controller.parking.busesArray[i].getType(),i+14,controller.parking.busesArray[i].getParkTime());
                onParkingTable.setItems(FXCollections.observableArrayList(Arrays.asList(parkingData)));
            }
        }

        System.out.println(nextIndex);
        for(int i=0;i<nextIndex;i++){

            switch (parkingData[i].getSlot()){
                case 1 : slot1.setOpacity(1); break;
                case 2 : slot2.setOpacity(1); break;
                case 3 : slot3.setOpacity(1); break;
                case 4 : slot4.setOpacity(1); break;
                case 5 : slot5.setOpacity(1); break;
                case 6 : slot6.setOpacity(1); break;
                case 7 : slot7.setOpacity(1); break;
                case 8 : slot8.setOpacity(1); break;
                case 9 : slot9.setOpacity(1); break;
                case 10 : slot10.setOpacity(1); break;
                case 11 : slot11.setOpacity(1); break;
                case 12 : slot12.setOpacity(1); break;
                case 13 : slot13.setOpacity(1); break;
                case 14 : slot14.setOpacity(1); break;
            }

        }

    }

    public void dataBaseMeth(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/DataBaseTableForm.fxml"));
        Parent load = fxmlLoader.load();
        DataBaseTableFormController dataBaseTableFormController = fxmlLoader.getController();
        dataBaseTableFormController.setController(controller);
        Scene scene = new Scene(load);
        Stage stage = (Stage) managementFormContext.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("DataBase");
        stage.show();
    }
}
