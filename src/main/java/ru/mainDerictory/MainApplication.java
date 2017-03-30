package ru.mainDerictory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by Кирилл on 02.12.2016.
 */
public class MainApplication extends Application{

    private static Image icon;

    public static void main(String[] args) {
        launch(MainApplication.class,args);
    }

    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/mainWindow.fxml"));
        Parent root = fxmlLoader.load();
        icon = new Image(MainApplication.class.getResource("/images/icon.png").toExternalForm());
        primaryStage.getIcons().add(icon);
       // primaryStage.getIcons().add(new Image(MainApplication.class.getResourceAsStream("images/back.jpg")));
        primaryStage.setTitle("Расчет");
        primaryStage.setScene(new Scene(root,687,556));
        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(550);
        primaryStage.show();
    }
}
