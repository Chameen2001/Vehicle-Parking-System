package controller;

import Logic.Controller;
import Logic.DataBase;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class DataBaseTableFormController {
    public TableView vehicleTbl;
    public TableColumn vehicleNumberClm;
    public TableColumn typeClm;
    public TableColumn weightClm;
    public TableColumn noPassengerClm;


    public TableView driverTbl;
    public TableColumn nameClm;
    public TableColumn nicClm;
    public TableColumn licenseClm;
    public TableColumn addressClm;
    public TableColumn contactNoClm;

    Controller controller;

    public void initialize(){
        vehicleNumberClm.setCellValueFactory(new PropertyValueFactory<>("number"));
        typeClm.setCellValueFactory(new PropertyValueFactory<>("type"));
        weightClm.setCellValueFactory(new PropertyValueFactory<>("maxWeight"));
        noPassengerClm.setCellValueFactory(new PropertyValueFactory<>("numOfPassenger"));


        nameClm.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        nicClm.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        licenseClm.setCellValueFactory(new PropertyValueFactory<>("drivingLicenseNum"));
        addressClm.setCellValueFactory(new PropertyValueFactory<>("address"));
        contactNoClm.setCellValueFactory(new PropertyValueFactory<>("contactNum"));



    }

    public void backMeth(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ManagementForm.fxml"));
        Parent load = fxmlLoader.load();
        ManagementFormController managementFormController = fxmlLoader.getController();
        managementFormController.setController(controller);
        Scene scene = new Scene(load);
        Stage stage = (Stage) vehicleTbl.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Management Form");
        stage.show();
    }

    public void setController(Controller controller) {
        this.controller=controller;
        vehicleTbl.setItems(FXCollections.observableArrayList(controller.dataBase.vehiclesArray));
        driverTbl.setItems(FXCollections.observableArrayList(controller.dataBase.driversArray));
    }
}