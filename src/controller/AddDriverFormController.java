package controller;

import Logic.Controller;
import Logic.Driver;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class AddDriverFormController {

    public JFXTextField driverNametxt;
    public JFXTextField nicTxt;
    public JFXTextField drivingLicenseNotxt;
    public JFXTextArea addressTxt;
    public JFXTextField contactNoTxt;
    private Controller controller;

    public void addDriverMeth(ActionEvent actionEvent) {

        if(driverNametxt.getText().equals("") || nicTxt.getText().equals("") || drivingLicenseNotxt.getText().equals("") || addressTxt.getText().equals("") || contactNoTxt.getText().equals("")){
            new Alert(Alert.AlertType.WARNING,"Some field or fields are empty",ButtonType.OK).show();
        }else {
            controller.addDriver(new Driver(driverNametxt.getText(),nicTxt.getText(),drivingLicenseNotxt.getText(),addressTxt.getText(),Integer.parseInt(contactNoTxt.getText())));
            Stage stage = (Stage) driverNametxt.getScene().getWindow();
            stage.close();
            new Alert(Alert.AlertType.CONFIRMATION,"Driver Added Successfully", ButtonType.OK).show();

        }



    }

    public void setController(Controller controller){
        this.controller=controller;
    }

}
