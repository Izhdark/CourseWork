package ru.mainDerictory.tables;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Кирилл on 05.12.2016.
 */
public class table1_7 {
    private static String typeOfBelts;
    private static String speed;
    private static String fileName="C://Users/Кирилл/IdeaProjects/CourseWork/src/main/resources/files/table1_7.txt";
    private static String line;

    public static void setTypeOfBelts(String typeOfBelts) {
        table1_7.typeOfBelts = typeOfBelts;
    }

    public static void setSpeed(String speed) {
        table1_7.speed = speed;
    }

    public static String chooser() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((line=reader.readLine())!=null){
                String[] value=line.split(";");
                if(value[0].equals(typeOfBelts)&&speed.equals(value[1])) {
                    if(value[2].equals("-"))
                        return "При такой скорости значения коэффициента С2 нет";
                    return value[2];
                }
                if(value[0].equals(typeOfBelts)&&speed.equals(value[1]))
                    return value[2];
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
