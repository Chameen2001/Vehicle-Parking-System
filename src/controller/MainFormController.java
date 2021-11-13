package controller;

import Logic.Controller;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class MainFormController{



    public JFXComboBox vehicleCmb;
    public Label slotLabel;
    public Label typeLabel;
    public JFXButton parkBtn;
    public JFXButton leaveBtn;
    public Label timeLabel;
    public Label dateLabel;
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

    Controller controller;

    public void initialize(){

        initClock();

        vehicleCmb.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            typeLabel.setText(controller.getVehicle((String) newValue));

        });

    }

    public void parkVehicleMeth(ActionEvent actionEvent) {
        int slot=controller.park();
        switch (slot){
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
        slotLabel.setText(String.valueOf(slot==0?"SLOT":slot));
        reset();
    }

    public void leaveVehicleMeth(ActionEvent actionEvent) throws IOException {
        if(controller.vehicle!=null){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/EnterNameForm.fxml"));
            Parent parent = fxmlLoader.load();
            EnterNameFormController controller = fxmlLoader.getController();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Enter Name");
            stage.show();

            controller.setController(this.controller);

        }else{
            new Alert(Alert.AlertType.ERROR,"Please Select The Vehicle", ButtonType.OK).show();
        }


    }



    private void initClock() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy:MM:dd");
            timeLabel.setText(LocalDateTime.now().format(formatter));
            dateLabel.setText(LocalDateTime.now().format(formatter1));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void managementLogInMeth(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ManagementLogInForm.fxml"));
        Parent parent = fxmlLoader.load();
        ManagementLogInFormController controller = fxmlLoader.getController();
        controller.setController(this.controller,slotLabel);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Management LogIn Form");
        stage.show();
    }

    public void setController(Controller controller){
        this.controller=controller;
        controller.setMainFormController(this);

        String[] comboData = new String[controller.dataBase.nextVehicle];
        for(int i = 0 ; i < controller.dataBase.nextVehicle; i++){
            comboData[i]=controller.dataBase.vehiclesArray[i].getNumber();
        }
        vehicleCmb.setItems(FXCollections.observableArrayList(Arrays.asList(comboData)));
    }

    private void slotOpacityReduce(){
        slot1.setOpacity(0.16);
        slot2.setOpacity(0.16);
        slot3.setOpacity(0.16);
        slot4.setOpacity(0.16);
        slot5.setOpacity(0.16);
        slot6.setOpacity(0.16);
        slot7.setOpacity(0.16);
        slot8.setOpacity(0.16);
        slot9.setOpacity(0.16);
        slot10.setOpacity(0.16);
        slot11.setOpacity(0.16);
        slot12.setOpacity(0.16);
        slot13.setOpacity(0.16);
        slot14.setOpacity(0.16);

    }

    long time=0;

    public void reset(){
        time=System.currentTimeMillis();
        Timeline clock = new Timeline(new KeyFrame(Duration.seconds(1), e -> {

            if(System.currentTimeMillis()-time>3000){
                slotOpacityReduce();
                slotLabel.setText("SLOT");
                typeLabel.setText("TYPE");
            }


        }));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

    }

}
