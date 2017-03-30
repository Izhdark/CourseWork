package ru.mainDerictory.storage;

/**
 * Created by Кирилл on 04.12.2016.
 */
public class ValueStorage {

    private int elasticModule;

    private double thiknessOftheBelt;
    private double D1;
    private double bendingStress;
    private String typeOfStrap;
    private int ratioValue;


    private double F;
    private double usefulVoltage1;
    private double b;
    private double Sigma0;
    private  double sigmap;
    private double sigmaMax;

    private double attitude;

    private double tch0;

    private double Cp;
    private double Cu;
    private double tch;

    public double getThiknessOftheBelt() {
        return thiknessOftheBelt;
    }
    public double getD1() {
        return D1;
    }
    public double getBendingStress() {
        return bendingStress;
    }
    public String getTypeOfStrap(){
        return typeOfStrap;
    }
    public int getRatioValue() {
        return ratioValue;
    }

    public double getF() {
        return F;
    }

    public double getUsefulVoltage1() {
        return usefulVoltage1;
    }

    public double getB() {
        return b;
    }

    public double getSigma0() {
        return Sigma0;
    }

    public double getSigmap() {
        return sigmap;
    }
    public double getAttitude() {
        return attitude;
    }

    public double getSigmaMax() {
        return sigmaMax;
    }

    public double getTch0() {
        return tch0;
    }

    public double getCp() {
        return Cp;
    }

    public double getCu() {
        return Cu;
    }

    public double getTch() {
        return tch;
    }

    public void setElasticModule(String typeOfStrap) {
        if(typeOfStrap.equals("Тканевые прорезиненные")) {
            elasticModule = 140;
            this.typeOfStrap=typeOfStrap;
        }
        else {
            elasticModule = 500;
            this.typeOfStrap=typeOfStrap;
        }
    }

    public int getElasticModule() {
        return elasticModule;
    }

    public void setElements(double d1, double thiknessOftheBelt,double bendingStress,String ratio) {
        this.D1=d1;
        this.thiknessOftheBelt=thiknessOftheBelt;
        this.bendingStress=bendingStress;
        this.ratioValue=Integer.parseInt(ratio);

        System.out.println(thiknessOftheBelt);
        System.out.println(D1);
        System.out.println(bendingStress);
        System.out.println(typeOfStrap);
        System.out.println(ratioValue);
    }

    public void setElementsSecondPart(double F, double usefulVoltage1, double b, double Sigma0, double sigmap,double attitude, double sigmaMax) {
        this.F=F;
        this.usefulVoltage1=usefulVoltage1;
        this.b=b;
        this.Sigma0=Sigma0;
        this.sigmap=sigmap;
        this.attitude=attitude;
        this.sigmaMax=sigmaMax;
    }
    public void setTch0(double tch0) {
        this.tch0 = tch0;
    }

    public void setElementsForthPart(double cp, double tch, double comboCuValue) {
        this.Cp=cp;
        this.tch=tch;
        this.Cu= comboCuValue;
    }
}
