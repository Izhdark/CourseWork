package ru.mainDerictory.tables;

/**
 * Created by Кирилл on 05.12.2016.
 */
public class table1_6 {

    public static String wrapAngle;

    public static void setWrapAngle(String wrapAngle) {
        table1_6.wrapAngle = wrapAngle;
    }

    public static String chooser() {
        switch (wrapAngle){
            case "110":
                return "0.79";
            case "120":
                return "0.82";
            case "130":
                return "0.85";
            case "140":
                return "0.88";
            case "150":
                return "0.91";
            case "160":
                return "0.94";
            case "170":
                return "0.97";
            case "180":
                return "1";
        }
        return null;
    }
}
