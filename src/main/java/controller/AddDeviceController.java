package controller;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.regexp.internal.RE;
import db.DbDeviceManage;
import db.DbManager;
import interfaces.ResultInfoInterface;
import model.*;
import model.AddPerson.AddPersonBean;
import model.AddSite.AddSiteBean;
import model.CreateDevice.CreateDeviceBean;
import model.SpecToken.SpecTokenBean;
import model.SpecToken.SpecTokensBean;
import network.NetworkUtils;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sun.nio.ch.Net;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
@ComponentScan
@Configuration
@EnableAutoConfiguration
@RestController
@RequestMapping("/device")
public class AddDeviceController {
    private Boolean includeAssignments;
    private Boolean includeZones;
    private int page;
    private int pageSize;
    private String result1 = null;
    //获取site列表
    @RequestMapping(value = "/getSite", method = RequestMethod.GET)
    public String register2(@RequestParam(value="page",required=true)int page,@RequestParam(value="pageSize",required=true)int pageSize,@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){
        this.page =page;
        this.pageSize=pageSize;
        String url1 = "http://localhost:8080/sitewhere/api/sites?includeAssignments=false&includeZones=false&page=";
        String url2 ="&pageSize=";
        String url = url1+this.page+url2+this.pageSize;

        NetworkUtils.doGet(url, sitewhereToken, new ResultInfoInterface() {
					@Override
					public void onResponse(String result) {
                        System.out.println(result);
                            result1 = result;

					    }
				});
        while(result1 == null){
           continue;
        }
        return result1;
    }
    //添加site
    @RequestMapping(value = "/addSite",method = RequestMethod.POST)
    public String regist(@RequestBody AddSiteBean addSiteBean){
        String addSite=JSON.toJSONString(addSiteBean);
        NetworkUtils.doPost("http://localhost:8080/sitewhere/api/sites", addSite, addSiteBean.getSitewhereToken(), new ResultInfoInterface() {
            @Override
            public void onResponse(String result) {
                System.out.println(result);
            }
        });
        return JSON.toJSONString(addSiteBean);
    }
    //添加设备
    @RequestMapping(value = "/addDevice",method = RequestMethod.POST)
    public String addDevice(@RequestBody CreateDeviceBean createDeviceBean){
        String createDevice=JSON.toJSONString(createDeviceBean);
        NetworkUtils.doPost("http://localhost:8080/sitewhere/api/devices", createDevice, createDeviceBean.getSitewhereToken(), new ResultInfoInterface() {
            @Override
            public void onResponse(String result) {
                System.out.println(result);
            }
        });
        return createDevice;
    }
    //添加assetperson 安全管理员
    @RequestMapping(value = "/addSafePerson",method = RequestMethod.POST)
    public String addSafePerson(@RequestBody AddPersonBean addPersonBean){
        String addPerson=JSON.toJSONString(addPersonBean);
        NetworkUtils.doPost("http://localhost:8080/sitewhere/api/assets/categories/default-person-asset/persons", addPerson, addPersonBean.getSitewhereToken(), new ResultInfoInterface() {
            @Override
            public void onResponse(String result) {
                System.out.println(result);
            }
        });
        return addPerson;
    }
    //查询用户的spectoken
    @RequestMapping(value = "/getSpecToken", method = RequestMethod.GET)
    public String getSpecToken(@RequestParam(value="name",required=true)String name){
        DbDeviceManage.getInstance().init();
        SpecTokensBean specTokensBean = new SpecTokensBean();
        List<SpecTokenBean> specToken = new ArrayList<SpecTokenBean>();
        List<DeviceInfoBean> deviceInfoBeans = DbDeviceManage.getInstance().select(name);
        if(deviceInfoBeans.size() != 0 ){
            for(int i=0;i<deviceInfoBeans.size();i++){
                SpecTokenBean specTokenBean=new SpecTokenBean();
                specTokenBean.setLabel(deviceInfoBeans.get(i).getSpecName());
                specTokenBean.setValue(deviceInfoBeans.get(i).getSpecificationToken());
                specToken.add(specTokenBean);

            }
            specTokensBean.setSpecToken(specToken);

        }
        DbDeviceManage.getInstance().close();

        return JSON.toJSONString(specTokensBean);
    }


}
