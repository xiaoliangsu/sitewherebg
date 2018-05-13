package model.AddSite.Map;

public class Map {
    private String type;

    private Metadata metadata;

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setMetadata(Metadata metadata){
        this.metadata = metadata;
    }
    public Metadata getMetadata(){
        return this.metadata;
    }
}
