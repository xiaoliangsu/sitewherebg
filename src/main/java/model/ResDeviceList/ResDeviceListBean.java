package model.ResDeviceList;

import java.util.List;

public class ResDeviceListBean {
    public ResDeviceListBean(){}

    private int numResults;

    private List<ResultBean> results ;

    public void setNumResults(int numResults){
        this.numResults = numResults;
    }
    public int getNumResults(){
        return this.numResults;
    }
    public void setResults(List<ResultBean> results){
        this.results = results;
    }
    public List<ResultBean> getResults(){
        return this.results;
    }
}
