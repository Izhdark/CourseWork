package ru.mainDerictory.tables;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Кирилл on 09.12.2016.
 */
public class table1_12 {
    private static String U;
    private static String attitude;
    private static String fileName="C://Users/Кирилл/IdeaProjects/CourseWork/src/main/resources/files/table1_12.txt";

    public static void setAttitude(String attitude) {
        table1_12.attitude = attitude;
    }

    public static void setU(String u) {
        U = u;
    }

    public static String chooser(){
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((line=reader.readLine())!=null) {
                String[] value= line.split(";");
                if(value[0].equals(attitude)&&value[1].equals(U)){
                  return value[2];
                }
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
