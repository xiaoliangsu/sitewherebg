package model.AllDevice;

import java.util.List;

public class State {
    public State(){}
    private String lastInteractionDate;

    private String presenceMissingDate;

    private List<LatestMeasurements> latestMeasurements ;

    private List<LatestAlerts> latestAlerts ;

    public void setLastInteractionDate(String lastInteractionDate){
        this.lastInteractionDate = lastInteractionDate;
    }
    public String getLastInteractionDate(){
        return this.lastInteractionDate;
    }
    public void setPresenceMissingDate(String presenceMissingDate){
        this.presenceMissingDate = presenceMissingDate;
    }
    public String getPresenceMissingDate(){
        return this.presenceMissingDate;
    }
    public void setLatestMeasurements(List<LatestMeasurements> latestMeasurements){
        this.latestMeasurements = latestMeasurements;
    }
    public List<LatestMeasurements> getLatestMeasurements(){
        return this.latestMeasurements;
    }
    public void setLatestAlerts(List<LatestAlerts> latestAlerts){
        this.latestAlerts = latestAlerts;
    }
    public List<LatestAlerts> getLatestAlerts(){
        return this.latestAlerts;
    }
}
