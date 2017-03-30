package ru.mainDerictory.errors;

import com.jfoenix.controls.JFXDialog;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Кирилл on 10.12.2016.
 */
public class errors {

    private Alert alert = new Alert(Alert.AlertType.ERROR);
    private int count=0;
    private Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

    private void showErrorsDialog(){
        stage.getIcons().add(new Image("/images/icon.png"));
        alert.setTitle("Ошибка");
        alert.setHeaderText("Неправильно введено поле!");
        alert.showAndWait();
    }

    private boolean commonRegularExpression(String expression, String value){
        Pattern pat = Pattern.compile(expression);
        Matcher mat = pat.matcher(value);
        return mat.matches();
    }

    public boolean checkOnErrorsFirstPart(String text, String tfPowerText, String tfRotationFrequencyеText, Object type, Object comboParamValue) {
        if(!commonRegularExpression("(\\d)+",text)){
            alert.setContentText("Введите корректные данные значения отношения D1/δ ");
            showErrorsDialog();
            return false;
        }
        if(!commonRegularExpression("(\\d)+",tfPowerText)){
            alert.setContentText("Введите корректные данные мощности ");
            showErrorsDialog();
            return false;
        }
        if(!commonRegularExpression("(\\d)+",tfRotationFrequencyеText)){
            alert.setContentText("Введите корректные данные частоты меньшего шкива n1");
            showErrorsDialog();
            return false;
        }
        return true;
    }

    public boolean checkOnErrorsSeconfPart(String tfAngle, String tfSecondPartAngleText, String tfSpeedText) {
        if(!commonRegularExpression("(\\d)+",tfSecondPartAngleText)){
            alert.setContentText("Введите корректные данные для угла обхвата α на малом шкиве");
            showErrorsDialog();
            return false;
        }
        if(!commonRegularExpression("(\\d)+",tfSpeedText)){
            alert.setContentText("Введите корректные данные скорости ремня");
            showErrorsDialog();
            return false;
        }
        return true;
    }
    public boolean checkOnErrorsThirdPart(String tfAttitude){
        if(!commonRegularExpression("(\\d)+",tfAttitude)){
            alert.setContentText("Введите корректные данные отношения D1/δ");
            showErrorsDialog();
            return false;
        }
        return true;
    }

    public void setCount() {
        count+=1;
    }

    public boolean alerts(){
        if(count<4) {
            stage.getIcons().add(new Image("/images/icon.png"));
            alert.setTitle("Иноформация");
            alert.setHeaderText("Записать данные в таблицу не получилось");
            alert.setContentText("Сначала рассчитайте все коэффициенты");
            alert.showAndWait();
            return false;
        }
        else
            return true;
    }
}
