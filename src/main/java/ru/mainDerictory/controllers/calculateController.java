package ru.mainDerictory.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jfoenix.validation.base.ValidatorBase;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ru.mainDerictory.calculate.GetValue;
import ru.mainDerictory.communication.ShowTable;
import ru.mainDerictory.errors.errors;
import ru.mainDerictory.tables.*;

import java.net.URL;
import java.util.ResourceBundle;
/**
 * Created by Кирилл on 03.12.2016.
 */
public class calculateController implements Initializable{
    @FXML
    private JFXComboBox<String> comboType;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXTextField tfRotationFrequencyе;

    @FXML
    private JFXButton btnRecordTable;

    @FXML
    private JFXButton btnCalculate;

    @FXML
    private JFXTextField tfPower;

    @FXML
    private JFXComboBox<String> comboParam;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXTextField tfThiknessOftheBelt;

    @FXML
    private JFXTextField tfBendingStress;

    @FXML
    private JFXTextField tfD1;

    @FXML
    private JFXTextField tfOneValue;

    @FXML
    private ComboBox<String> comboInitialVoltage;

    @FXML
    private ComboBox<String> comboA;

    @FXML
    private ComboBox<String> comboW;

    @FXML
    private JFXRadioButton radio1;

    @FXML
    private JFXRadioButton radio2;

    @FXML
    private JFXTextField tfAngle;

    @FXML
    private ComboBox<String> comboC0;

    @FXML
    private JFXTextField tfSecondPartAngle;

    @FXML
    private ComboBox<String> comboSecondPartC1;

    @FXML
    private ComboBox<String> comboSecondPartC2;

    @FXML
    private JFXTextField tfSpeed;

    @FXML
    private ComboBox<String> comboSecondPartCharacter;

    @FXML
    private ComboBox<String> comboTypeOfEngine;

    @FXML
    private ComboBox<String> comboSecondPartC3;

    @FXML
    private JFXTextField tfusefulVoltage1;

    @FXML
    private JFXTextField tfb;

    @FXML
    private JFXTextField tfF;

    @FXML
    private JFXTextField tfsigmap;

    @FXML
    private JFXTextField tfAttitude;

    @FXML
    private ComboBox<String> combotch0;

    @FXML
    private JFXTextField tfAnswerThirdPart;

    @FXML
    private ComboBox<String> comboSigmap;

    @FXML
    private ComboBox<String> comboTreatment;

    @FXML
    private ComboBox<String> comboU;

    @FXML
    private ComboBox<String> comboCu;

    @FXML
    private JFXTextField tfTch;

    @FXML
    private JFXTextField tfCu;

    @FXML
    private JFXTextField tfCp;

    @FXML
    private Tab tapSigmap;

    @FXML
    private Tab tabTch;

    private GetValue getValue = new GetValue();
    private errors err = new errors();
    private  RequiredFieldValidator validator = new RequiredFieldValidator();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboType.getItems().addAll("Тканевые прорезиненные","Синтетичесие капроновые");
        comboParam.getItems().addAll("Допускаемое","Рекомендуемое");
        setVisibeTextFields();
        setEditablePane();
        chooseType();

        secondPart();
        secondPartAnother();

        thirdPart();

        fourthPart();
        setTextValidate();
    }

    private void setTextValidate() {
    }

    private void fourthPart() {
        comboTreatment.getItems().addAll("0.75","1.0","1.5");
        comboU.getItems().addAll("1","1.12","1.26","1.41","1.56","2","2.52","3","4");
        comboCu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                comboCu.getItems().clear();
                if(event.getClickCount()>=1){
                    table1_12.setAttitude( comboTreatment.getValue());
                    table1_12.setU(comboU.getValue());
                    comboCu.getItems().addAll(table1_12.chooser());
                }
            }
        });
    }

    private void thirdPart() {
        comboSigmap.getItems().addAll(getValue.getListOfSigmaP());
        combotch0.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                combotch0.getItems().clear();
                table1_11.setSigmap( comboSigmap.getValue());
                table1_11.setRatio(tfAttitude.getText());
                combotch0.getItems().addAll(table1_11.chooser());
            }
        });
    }

    private void secondPart() {
        comboInitialVoltage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comboA.getItems().clear();
                comboW.getItems().clear();
                table1_5.setFirstValue(comboInitialVoltage.getValue());
                table1_5.setTypeOfBelts(getValue.getTypeOfStrap());
                comboA.getItems().addAll(table1_5.chooseCoefficients(1));
                comboW.getItems().addAll(table1_5.chooseCoefficients(2));
            }
        });
        comboC0.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                comboC0.getItems().clear();
                if(event.getClickCount()>=1){
                    if(tfAngle.isVisible())
                        ElementsSelection.setAngle(tfAngle.getText());
                    comboC0.getItems().addAll(ElementsSelection.chooser());
                }
            }
        });

    }
    public void radioSelect(ActionEvent actionEvent) {
        if(radio1.isSelected()) {
            ElementsSelection.setMethodOfTension(radio1.getText());
            tfAngle.setVisible(false);
        }
        if(radio2.isSelected()){
            ElementsSelection.setMethodOfTension(radio2.getText());
            tfAngle.setVisible(true);
        }
    }

    private void secondPartAnother() {
        comboSecondPartC1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                comboSecondPartC1.getItems().clear();
                if(event.getClickCount()>=1){
                    table1_6.setWrapAngle(tfSecondPartAngle.getText());
                    comboSecondPartC1.getItems().addAll(table1_6.chooser());
                }
            }
        });
        comboSecondPartC2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                comboSecondPartC2.getItems().clear();
                if(event.getClickCount()>=1){
                    table1_7.setSpeed(tfSpeed.getText());
                    table1_7.setTypeOfBelts(getValue.getTypeOfStrap());
                    comboSecondPartC2.getItems().addAll(table1_7.chooser());
                }
            }
        });
        comboSecondPartCharacter.getItems().addAll(getValue.getCharacterLoads());
        comboSecondPartCharacter.setOnAction(e->table1_8.setCharacter( comboSecondPartCharacter.getValue()));
        comboTypeOfEngine.getItems().addAll(getValue.getTypeOfEngine());
        comboTypeOfEngine.setOnAction(e->table1_8.setTypeOfEngine( comboTypeOfEngine.getValue()));
        comboSecondPartC3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                comboSecondPartC3.getItems().clear();
                if(event.getClickCount()>=1){
                    comboSecondPartC3.getItems().addAll(table1_8.chooser());
                }
            }
        });
    }

    private void setVisibeTextFields() {
        tfD1.setVisible(false);
        tfBendingStress.setVisible(false);
        tfThiknessOftheBelt.setVisible(false);
        tfAngle.setVisible(false);

        tfusefulVoltage1.setVisible(false);
        tfb.setVisible(false);
        tfF.setVisible(false);
        tfsigmap.setVisible(false);

        tfAnswerThirdPart.setVisible(false);

        tfTch.setVisible(false);
        tfCu.setVisible(false);
        tfCp.setVisible(false);
    }

    private void setEditablePane() {
        tapSigmap.setDisable(true);
        tabTch.setDisable(true);
    }

    private void chooseType() {
        comboType.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                table1_1.setTypeOfStrap( comboType.getValue());
                tfOneValue.setPromptText(table1_1.chooser());
            }
        });
        comboParam.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                table1_1.setValue( comboParam.getValue());
                tfOneValue.setPromptText(table1_1.chooser());
            }
        });
    }

    public void actionCalculate(ActionEvent actionEvent) {
        if(!err.checkOnErrorsFirstPart(tfOneValue.getText(),tfPower.getText(),tfRotationFrequencyе.getText(),comboType.getValue(),comboParam.getValue()))
            return;
        getValue.calculate(tfOneValue.getText(),tfPower.getText(),tfRotationFrequencyе.getText(),table1_1.getTypeOfStrap());
        recordTextFields();
        recordToComboBoxes();
        tapSigmap.setDisable(false);
        err.setCount();
    }

    public void actionCalculateSecondPart(ActionEvent actionEvent) {
        if(!err.checkOnErrorsSeconfPart(tfAngle.getText(),tfSecondPartAngle.getText(),tfSpeed.getText()))
            return;
        getValue.calculateSecondPart(comboInitialVoltage.getValue(),comboA.getValue(),comboW.getValue(),comboC0.getValue(),comboSecondPartC1.getValue(),comboSecondPartC2.getValue(),comboSecondPartC3.getValue(),tfSpeed.getText(),tfPower.getText(),comboInitialVoltage.getValue());
        recordTextFieldsSecondPart();
        tabTch.setDisable(false);
        err.setCount();
    }

    public void actionCalculateThirdPart(ActionEvent actionEvent) {
        if(!err.checkOnErrorsThirdPart(tfAttitude.getText()))
            return;
        getValue.calculateThirdPart(combotch0.getValue());
        tfAnswerThirdPart.setVisible(true);
        tfAnswerThirdPart.setText("tч0="+getValue.getTch0());
        err.setCount();
    }

    public void calculateForthPart(ActionEvent actionEvent) {
        getValue.calculateFourthPart(comboCu.getValue());
        recordTextFieldsFourthPart();
        err.setCount();
    }
    private void recordTextFieldsSecondPart() {
        tfusefulVoltage1.setVisible(true);
        tfb.setVisible(true);
        tfF.setVisible(true);
        tfsigmap.setVisible(true);
        tfusefulVoltage1.setText("[δF]="+Double.toString(getValue.getUsefulVoltage1()));
        tfb.setText("b="+Double.toString(getValue.getB()));
        tfF.setText("F="+Double.toString(getValue.getF()));
        tfsigmap.setText("δр="+Double.toString(getValue.getSigmap()));
    }

    private void recordToComboBoxes() {
        comboInitialVoltage.getItems().clear();
        comboInitialVoltage.getItems().addAll(getValue.getTheList());
    }
    private void recordTextFieldsFourthPart() {
        tfTch.setText("tч="+getValue.getTch());
        tfCu.setText("Cu="+getValue.getCu());
        tfCp.setText("Cp="+getValue.getCp());
        tfTch.setVisible(true);
        tfCu.setVisible(true);
        tfCp.setVisible(true);
    }
    private void recordTextFields() {
        tfD1.setVisible(true);
        tfBendingStress.setVisible(true);
        tfThiknessOftheBelt.setVisible(true);
        tfD1.setText("D1="+Double.toString(getValue.getD1()));
        tfThiknessOftheBelt.setText("δ="+Double.toString(getValue.getThiknessOftheBelt()));
        tfBendingStress.setText("δц="+Double.toString(getValue.getBendingStress()));
    }

    public void actionRecord(ActionEvent actionEvent) {
        if(!err.alerts())
            return;
        getValue.createListToShow();
        ShowTable.show();
        actionCancel(actionEvent);
    }


    public void actionCancel(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

}
