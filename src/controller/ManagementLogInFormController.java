package controller;

import Logic.Controller;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagementLogInFormController {
    public AnchorPane logInContext;
    public JFXTextField userNametxt;
    public JFXPasswordField passwordPwd;
    Controller controller;
    Label slotLabel;

    public void initialize(){
        userNametxt.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            if(newValue.contains(" ")){
                userNametxt.setFocusColor(Color.RED);
                userNametxt.setUnFocusColor(Color.RED);
            }else{
                userNametxt.setFocusColor(Color.WHITE);
                userNametxt.setUnFocusColor(Color.WHITE);
            }
        });

    }

    public void logInMeth(ActionEvent actionEvent) throws IOException {
        if(userNametxt.getFocusColor()==Color.RED){
            new Alert(Alert.AlertType.WARNING,"Invalid Input", ButtonType.OK).show();
        }else{
            if(userNametxt.getText().equals("") && passwordPwd.getText().equals("")){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ManagementForm.fxml"));
                Parent parent = fxmlLoader.load();
                Scene scene = new Scene(parent);
                ManagementFormController managementFormController = fxmlLoader.getController();
                managementFormController.setController(controller);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Management Form");
                stage.show();


                Stage stage1 = (Stage) logInContext.getScene().getWindow();
                stage1.close();
                Stage stage2 = (Stage)slotLabel.getScene().getWindow();
                stage2.close();

            }
        }

    }

    public void cancelMeth(ActionEvent actionEvent) {
        Stage stage = (Stage) logInContext.getScene().getWindow();
        stage.close();
    }

    public void setController(Controller controller, Label slotLabel){
        this.controller=controller;
        this.slotLabel=slotLabel;
    }

}
