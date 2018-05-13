package model.SpecToken;

import java.util.List;

public class SpecTokensBean {
    private List<SpecTokenBean> specToken ;

    public SpecTokensBean(){}
    public void setSpecToken(List<SpecTokenBean> specToken){
        this.specToken = specToken;
    }
    public List<SpecTokenBean> getSpecToken(){
        return this.specToken;
    }
}
