import Logic.Controller;
import controller.MainFormController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Controller controller = new Controller();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/MainForm.fxml"));
        Parent parent = fxmlLoader.load();
        MainFormController mainFormController=fxmlLoader.getController();
        mainFormController.setController(controller);
        Scene scene = new Scene(parent);
        scene.getStylesheets().add("css/styleSheet1.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Parking System");
        primaryStage.show();

    }
}
