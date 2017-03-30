package ru.mainDerictory.controllers;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.mainDerictory.communication.ShowTable;
import ru.mainDerictory.storage.ValueStorage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Кирилл on 02.12.2016.
 */
public class mainWindowController implements Initializable {

    @FXML
    private JFXDrawer drawerId;

    @FXML
    private AnchorPane anchorPaneId;

    @FXML
    private JFXHamburger hamburgerId;

    @FXML
    private TableColumn<ValueStorage,Double> columnSigma;

    @FXML
    private TableColumn<ValueStorage,Double> columnD1;

    @FXML
    private TableColumn<ValueStorage,Double> columnSigmace;

    @FXML
    private TableColumn<ValueStorage,Double> columnSigma0;

    @FXML
    private TableColumn<ValueStorage,Double> columnSigmap;

    @FXML
    private TableColumn<ValueStorage,Double> columnF;

    @FXML
    private TableColumn<ValueStorage,Double> columnSigmaMax;

    @FXML
    private TableColumn<ValueStorage,Double> columnTch0;

    @FXML
    private TableColumn<ValueStorage,Double> columnCp;

    @FXML
    private TableColumn<ValueStorage,Double> columnB;

    @FXML
    private TableColumn<ValueStorage,Double> columnTch;

    @FXML
    private TableColumn<ValueStorage,Double> columnUsefulVoltage;

    @FXML
    private TableColumn<ValueStorage,Double> columnCu;

    @FXML
    private TableView<ValueStorage> tableView;

    private ShowTable show = new ShowTable();

    public void initialize(URL location, ResourceBundle resources) {

        show.init(this);
        try {
            AnchorPane anchor = FXMLLoader.load(getClass().getResource("/fxml/drawer.fxml"));
            drawerId.setSidePane(anchor);
            HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburgerId);
            transition.setRate(-1);
            hamburgerId.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                transition.setRate(transition.getRate() * -1);
                transition.play();
                if(drawerId.isDisable()){
                    drawerId.open();
                    drawerId.setDisable(false);
                }
                else{
                    drawerId.close();
                    drawerId.setDisable(true);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
}
    public TableColumn<ValueStorage, Double> getColumnSigma() {
        return columnSigma;
    }

    public TableColumn<ValueStorage, Double> getColumnD1() {
        return columnD1;
    }
    public TableView<ValueStorage> getTableView() {
        return tableView;
    }

    public TableColumn<ValueStorage, Double> getColumnSigmace() {
        return columnSigmace;
    }

    public TableColumn<ValueStorage, Double> getColumnSigma0() {
        return columnSigma0;
    }

    public TableColumn<ValueStorage, Double> getColumnSigmap() {
        return columnSigmap;
    }

    public TableColumn<ValueStorage, Double> getColumnF() {
        return columnF;
    }

    public TableColumn<ValueStorage, Double> getColumnSigmaMax() {
        return columnSigmaMax;
    }

    public TableColumn<ValueStorage, Double> getColumnTch0() {
        return columnTch0;
    }

    public TableColumn<ValueStorage, Double> getColumnCp() {
        return columnCp;
    }

    public TableColumn<ValueStorage, Double> getColumnB() {
        return columnB;
    }

    public TableColumn<ValueStorage, Double> getColumnTch() {
        return columnTch;
    }

    public TableColumn<ValueStorage, Double> getColumnUsefulVoltage() {
        return columnUsefulVoltage;
    }

    public TableColumn<ValueStorage, Double> getColumnCu() {
        return columnCu;
    }
}
