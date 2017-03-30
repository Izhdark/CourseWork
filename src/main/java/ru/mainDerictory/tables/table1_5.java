package ru.mainDerictory.tables;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

/**
 * Created by Кирилл on 04.12.2016.
 */
public class table1_5 {
    private static String firstValue;
    private static String typeOfBelts;
    private static String A;
    private static String W;
    private static String line;
    private static String fileName = "C://Users/Кирилл/IdeaProjects/CourseWork/src/main/resources/files/table1_5.txt";

    public static void setFirstValue(String firstValue) {
        table1_5.firstValue = firstValue;
    }

    public static void setTypeOfBelts(String typeOfBelts) {
        table1_5.typeOfBelts = typeOfBelts;
    }

    public static String chooseCoefficients(int flag) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(fileName));
            while ((line = bf.readLine()) != null) {
                String[] values = line.split(";");
                if (values[1].equals(firstValue)) {
                    switch (flag) {
                        case 1:
                            return values[2];
                        case 2:
                            return values[3];
                    }
                }
            }
            bf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}
