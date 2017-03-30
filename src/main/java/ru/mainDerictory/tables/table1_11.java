package ru.mainDerictory.tables;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Кирилл on 06.12.2016.
 */
public class table1_11 {
    private static String sigmap;
    private static String ratio;
    private static String fileName="C://Users/Кирилл/IdeaProjects/CourseWork/src/main/resources/files/table1_11.txt";
    private static String line;

    public static void setSigmap(String sigmap) {
        table1_11.sigmap = sigmap;
    }

    public static void setRatio(String ratio) {
        table1_11.ratio = ratio;
    }

    public static String chooser(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((line=reader.readLine())!=null) {
                String[] value= line.split(";");
                if(value[0].equals(sigmap)&&value[1].equals(ratio)){
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
