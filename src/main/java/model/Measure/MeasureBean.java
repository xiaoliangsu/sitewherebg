package model.Measure;

import java.util.List;

public class MeasureBean {
    public MeasureBean(){}
    private String measurementId;

    private List<Entries> entries ;

    public void setMeasurementId(String measurementId){
        this.measurementId = measurementId;
    }
    public String getMeasurementId(){
        return this.measurementId;
    }
    public void setEntries(List<Entries> entries){
        this.entries = entries;
    }
    public List<Entries> getEntries(){
        return this.entries;
    }
}
