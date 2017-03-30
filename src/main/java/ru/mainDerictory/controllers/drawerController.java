package ru.mainDerictory.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.mainDerictory.communication.ShowTable;

import java.io.IOException;

/**
 * Created by Кирилл on 03.12.2016.
 */
public class drawerController {

    public void actionCalculate(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/calculate.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.getIcons().add(new Image("/images/icon.png"));
            stage.setTitle("Подсчет коэффициентов");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setMinWidth(500);
            stage.setMinHeight(300);
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnExit(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void actionDelete(ActionEvent actionEvent) {
        ShowTable.deleteElement();
    }
}
