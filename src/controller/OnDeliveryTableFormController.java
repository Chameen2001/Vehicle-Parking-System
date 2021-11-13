package controller;

import Logic.Controller;
import TableDataClasses.OnDeliveryData;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.util.Arrays;

public class OnDeliveryTableFormController {

    public BorderPane onDeliveryTableFormContext;
    public TableView onDeliveryTable;
    public TableColumn vehicleNumberClm;
    public TableColumn vehicleTypeClm;
    public TableColumn driverNameClm;
    public TableColumn leftTimeClm;

    OnDeliveryData[] deliveryData = new OnDeliveryData[14];
    int nextIndex=0;

    Controller controller;

    public void initialize(){

    }

    public void setController(Controller controller){
        this.controller=controller;

        vehicleNumberClm.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        vehicleTypeClm.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        driverNameClm.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        leftTimeClm.setCellValueFactory(new PropertyValueFactory<>("leftTime"));

        for(int i = 0 ; i < controller.leaving.vehiclesArray.length; i++){
            if(controller.leaving.vehiclesArray[i]!=null){
                deliveryData[nextIndex++]=new OnDeliveryData(controller.leaving.vehiclesArray[i].getNumber(),controller.leaving.vehiclesArray[i].getType(),controller.leaving.vehiclesArray[i].getDriver().getDriverName(),controller.leaving.vehiclesArray[i].getLeaveTime());
                onDeliveryTable.setItems(FXCollections.observableArrayList(Arrays.asList(deliveryData)));
            }
        }



    }

}
