package ru.mainDerictory.tables;

/**
 * Created by Кирилл on 03.12.2016.
 */
public class table1_1 {
    private static String typeOfStrap;
    private static String typRratio;

    public static String getTypeOfStrap() {
        return typeOfStrap;
    }
    public static void setValue(String value) {
        table1_1.typRratio = value;
    }
    public static void setTypeOfStrap(String typeOfStrap) {
        table1_1.typeOfStrap = typeOfStrap;
    }

    public static String chooser() {
        if(typRratio==null||typeOfStrap==null)
            return null;
        if(typeOfStrap.equals("Тканевые прорезиненные")){
            if(typRratio.equals("Допускаемое"))
                return "Введите значение = 30";
            else
                return "Введите значение = 40";
        }
        else{
            if(typRratio.equals("Допускаемое"))
                return "Введите значение от 50 до 70";
            else
                return "Введите значение от 100 до 150";
        }
    }
}
