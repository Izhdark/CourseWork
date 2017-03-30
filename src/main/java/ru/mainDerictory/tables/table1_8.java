package ru.mainDerictory.tables;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Кирилл on 05.12.2016.
 */
public class table1_8 {
    private static String character;
    private static String typeOfEngine;

    public static void setCharacter(String character) {
        table1_8.character = character;
    }

    public static void setTypeOfEngine(String typeOfEngine) {
        table1_8.typeOfEngine = typeOfEngine;
    }

    private static boolean checkCharacter(String value){
        Pattern pat = Pattern.compile(value);
        Matcher mat =pat.matcher(character);
        if(mat.matches())
            return true;
        return false;
    }
    private static boolean checkTypeOfEngine(String value){
        Pattern pat = Pattern.compile(value);
        Matcher mat =pat.matcher(typeOfEngine);
        if(mat.matches())
            return true;
        return false;
    }
    public static String chooser(){
        if(typeOfEngine==null)
            return null;
        switch (typeOfEngine) {
            case "Электродвиатель постоянного тока, переменного тока однофазные":
                if (checkCharacter("Спокойная нагрузка"))
                    return "1";
                if(checkCharacter("Умеренные колебания нагрузки"))
                    return "0.9";
                if(checkCharacter("Значительные колебания нагрузки"))
                    return "0.8";
                if(checkCharacter("Весьма неравномерная и уарная нагрузка"))
                    return "0.7";
            case"Электродвиатель переменного тока синхронные":
                if (checkCharacter("Спокойная нагрузка"))
                    return "0.9";
                if(checkCharacter("Умеренные колебания нагрузки"))
                    return "0.8";
                if(checkCharacter("Значительные колебания нагрузки"))
                    return "0.7";
                if(checkCharacter("Весьма неравномерная и уарная нагрузка"))
                    return "0.6";
        }
        return null;
    }
}
