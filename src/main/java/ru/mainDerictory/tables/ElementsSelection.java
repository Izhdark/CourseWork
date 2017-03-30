package ru.mainDerictory.tables;

/**
 * Created by Кирилл on 04.12.2016.
 */
public class ElementsSelection {

    private static String methodOfTension;
    private static int angle;

    public static String getMethodOfTension() {
        return methodOfTension;
    }

    public static void setMethodOfTension(String methodOfTension) {
        ElementsSelection.methodOfTension = methodOfTension;
    }

    public static void setAngle(String angle) {
        ElementsSelection.angle = Integer.parseInt(angle);
    }

    public static String chooser(){
        if(methodOfTension==null)
            return null;
        if(methodOfTension.equals("Автоматическое натяжение")){
            return "1";
        }
        else{
            if(angle>=0&&angle<60)
                return "1";
            if(angle>=60&&angle<80)
                return "0.9";
            if(angle>=80&&angle<=90)
                return "0.8";
        }
        return null;
    }

}
