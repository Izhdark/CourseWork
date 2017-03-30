package ru.mainDerictory.communication;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.mainDerictory.calculate.GetValue;
import ru.mainDerictory.controllers.calculateController;
import ru.mainDerictory.controllers.mainWindowController;
import ru.mainDerictory.storage.ValueStorage;

/**
 * Created by Кирилл on 06.12.2016.
 */
public class ShowTable {
    private static mainWindowController main;

    public void init(mainWindowController mainWindowController) {
        main=mainWindowController;
    }
    public static void show(){
        main.getColumnD1().setCellValueFactory(new PropertyValueFactory<ValueStorage, Double>("D1"));
        main.getColumnSigma().setCellValueFactory(new PropertyValueFactory<ValueStorage, Double>("thiknessOftheBelt"));
        main.getColumnSigmace().setCellValueFactory(new PropertyValueFactory<ValueStorage, Double>("bendingStress"));
        main.getColumnF().setCellValueFactory(new PropertyValueFactory<ValueStorage, Double>("F"));
        main.getColumnUsefulVoltage().setCellValueFactory(new PropertyValueFactory<ValueStorage, Double>("usefulVoltage1"));
        main.getColumnB().setCellValueFactory(new PropertyValueFactory<ValueStorage, Double>("b"));
        main.getColumnSigma0().setCellValueFactory(new PropertyValueFactory<ValueStorage, Double>("Sigma0"));
        main.getColumnSigmap().setCellValueFactory(new PropertyValueFactory<ValueStorage, Double>("sigmap"));
        main.getColumnSigmaMax().setCellValueFactory(new PropertyValueFactory<ValueStorage, Double>("sigmaMax"));
        main.getColumnTch0().setCellValueFactory(new PropertyValueFactory<ValueStorage, Double>("tch0"));
        main.getColumnCp().setCellValueFactory(new PropertyValueFactory<ValueStorage, Double>("Cp"));
        main.getColumnCu().setCellValueFactory(new PropertyValueFactory<ValueStorage, Double>("Cu"));
        main.getColumnTch().setCellValueFactory(new PropertyValueFactory<ValueStorage, Double>("tch"));
        main.getTableView().setItems(GetValue.getTableList());
    }
    public static void deleteElement(){

        GetValue.deleteElement(main.getTableView().getSelectionModel().getSelectedItem());
    }
}
