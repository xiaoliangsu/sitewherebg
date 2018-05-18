package model.Measure;

public class Entries {
    public Entries(){}
    private double value;

    private String measurementDate;

    public void setValue(double value){
        this.value = value;
    }
    public double getValue(){
        return this.value;
    }
    public void setMeasurementDate(String measurementDate){
        this.measurementDate = measurementDate;
    }
    public String getMeasurementDate(){
        return this.measurementDate;
    }
}
