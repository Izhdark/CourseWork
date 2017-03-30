package ru.mainDerictory.calculate;
import java.lang.Math;
import java.util.Collection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.mainDerictory.storage.ValueStorage;

import static java.lang.Math.*;

/**
 * Created by Кирилл on 03.12.2016.
 */
public class GetValue {

    private static ObservableList<ValueStorage> tableList= FXCollections.observableArrayList();
    private ObservableList<String> list;

    private ValueStorage storage = new ValueStorage();

    public double getD1() {
        return storage.getD1();
    }

    public double getThiknessOftheBelt() {
        return storage.getThiknessOftheBelt();
    }

    public double getBendingStress() {
        return storage.getBendingStress();
    }

    public String getTypeOfStrap(){
        return storage.getTypeOfStrap();
    }

    public double getF() {
        return storage.getF();
    }

    public double getUsefulVoltage1() {
        return storage.getUsefulVoltage1();
    }

    public double getB() {
        return storage.getB();
    }

    public double getSigma0() {
        return storage.getSigma0();
    }

    public double getSigmap() {
        return storage.getSigmap();
    }

    public double getTch0() {
        return storage.getTch0();
    }

    public static ObservableList<ValueStorage> getTableList() {
        return tableList;
    }

    public double getAttitude() {
        return storage.getAttitude();
    }

    public double getCp() {
        return storage.getCp();
    }

    public double getCu() {
        return storage.getCu();
    }

    public double getTch() {
        return storage.getTch();
    }

    public void calculate(String text, String text1, String text2,String TypeOfStrap) {
        double D1;
        double thiknessOftheBelt;
        double bendingStress;
        storage.setElasticModule(TypeOfStrap);
        D1=Math.rint(120*cbrt((Integer.parseInt(text1)*1000)/Integer.parseInt(text2)));
        thiknessOftheBelt=D1/Integer.parseInt(text);
        bendingStress=(storage.getElasticModule()*thiknessOftheBelt)/D1;
        storage.setElements(D1,thiknessOftheBelt,bendingStress,text);
    }

    public void calculateSecondPart(Object InitialVoltage, String A, String W, String C0, String SecondPartC1, String SecondPartC2, String SecondPartC3,String Speed,String N,String Sigma0) {
        double F=(1000*Integer.parseInt(N))/Integer.parseInt(Speed);
        double usefulVoltage0=Double.parseDouble(A)-(Double.parseDouble(W)* storage.getThiknessOftheBelt())/storage.getD1();
        double usefulVoltage1=usefulVoltage0*Double.parseDouble(C0)*Double.parseDouble(SecondPartC1)*Double.parseDouble( SecondPartC2)*Double.parseDouble( SecondPartC3);
        double b=F/(storage.getThiknessOftheBelt()*usefulVoltage1);
        double sigmap =Double.parseDouble(Sigma0)+F/(2*b*storage.getThiknessOftheBelt())+storage.getBendingStress();
        double sigmaMax=sigmap+storage.getBendingStress();
        double attitude=storage.getD1()/storage.getThiknessOftheBelt();
        storage.setElementsSecondPart(F,usefulVoltage1,b,Double.parseDouble(Sigma0),sigmap,attitude,sigmaMax);
        //tableList.add(storage);
    }
    public void calculateThirdPart(String value) {
        storage.setTch0(Double.parseDouble(value));
    }

    public void calculateFourthPart( String comboCuValue) {
        int i=5;
        double Cp=i/pow((25/storage.getSigmaMax()),6);
        double tch=(storage.getTch0()/5)*Cp*Double.parseDouble(comboCuValue);
        storage.setElementsForthPart(Cp,tch,Double.parseDouble(comboCuValue));

    }
    public void createListToShow() {
        tableList.add(storage);
    }

    public static void deleteElement(ValueStorage selectedItem){
        tableList.remove(selectedItem);
    }

    public ObservableList<String> getTheList() {
        list = FXCollections.observableArrayList();
        if(storage.getTypeOfStrap().equals("Тканевые прорезиненные"))
            list.addAll("1.6","1.8","2.0","2.4");
        if(storage.getTypeOfStrap().equals("Синтетичесие капроновые")){
            if(storage.getRatioValue()<=80)
                list.addAll("4.0","5.0");
            if(storage.getRatioValue()>80&&storage.getRatioValue()<=100)
                list.add("7.5");
            if(storage.getRatioValue()>100)
                list.add("10.0");
        }
        return list;
    }
    public ObservableList<String> getCharacterLoads(){
        list=FXCollections.observableArrayList();
        list.addAll("Спокойная нагрузка",
                    "Умеренные колебания нагрузки",
                    "Значительные колебания нагрузки",
                    "Весьма неравномерная и уарная нагрузка");
        return list;
    }
    public ObservableList<String> getTypeOfEngine(){
        list=FXCollections.observableArrayList();
        list.addAll("Электродвиатель постоянного тока, переменного тока однофазные",
                "Электродвиатель переменного тока синхронные");
        return list;
    }

    public ObservableList<String> getListOfSigmaP() {
        list=FXCollections.observableArrayList();
        list.addAll("2.4","2.8","3.2","3.6","4.0","4.4","4.8");
        return list;
    }

}
