package controller;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.regexp.internal.RE;
import config.GlobalCorsConfig;
import db.DbDeviceManage;
import db.DbManager;
import interfaces.ResultInfoInterface;
import model.*;
import model.AddPerson.AddPersonBean;
import model.AddSite.AddSiteBean;
import model.AssociaPerson.AssociaPersonBean;
import model.AssociaPerson.Metadata;
import model.CreateDevice.CreateDeviceBean;
import model.DeviceList.Data;
import model.DeviceList.DeviceList;
import model.ResDeviceList.ResDeviceListBean;
import model.ResDeviceList.ResultBean;
import model.SpecToken.SpecTokenBean;
import model.SpecToken.SpecTokensBean;
import network.NetworkUtils;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
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
@Import(GlobalCorsConfig.class)
public class AddDeviceController {
    private Boolean includeAssignments;
    private Boolean includeZones;
    private int page;
    private int pageSize;
    private String result1 = null;
    DeviceList deviceList = new DeviceList();
    DeviceList deviceListResult= null;
    DeviceList siteDevices = new DeviceList();
    DeviceList siteDevicesResult = null;
    private String resultTemp = null;
    private String allDeviceList = null;
    private String siteDeviceList = null;

    //获取site列表
    @RequestMapping(value = "/getSite", method = RequestMethod.GET)
    public String register2(@RequestParam(value="page",required=true)int page,@RequestParam(value="pageSize",required=true)int pageSize,@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){
        this.page =page;
        this.pageSize=pageSize;
        result1 = null;
        String url1 = "http://localhost:8080/sitewhere/api/sites?includeAssignments=false&includeZones=false&page=";
        String url2 ="&pageSize=";
        String url = url1+this.page+url2+this.pageSize;

        NetworkUtils.doGet(url, sitewhereToken, new ResultInfoInterface() {
					@Override
					public void onResponse(String result) {
                            result1 = result;

					    }
				});
        while(result1 == null){
           continue;
        }
        System.out.println(result1);
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
    //添加assetperson 安全管理员并建立连接

    @RequestMapping(value = "/addSafePerson",method = RequestMethod.POST)
    public String addSafePerson(@RequestBody final AddPersonBean addPersonBean){
        String addPerson=JSON.toJSONString(addPersonBean);
        String resultFinal = null;
        NetworkUtils.doPost("http://localhost:8080/sitewhere/api/assets/categories/default-person-asset/persons", addPerson, addPersonBean.getSitewhereToken(), new ResultInfoInterface() {
            @Override
            public void onResponse(String result) {
                AssociaPersonBean associaPersonBean = new AssociaPersonBean();
                associaPersonBean.setAssetId(addPersonBean.getId());
                associaPersonBean.setAssetModuleId("default-person-asset");
                associaPersonBean.setAssignmentType("Associated");
                associaPersonBean.setDeviceHardwareId(addPersonBean.getDeviceHardwareId());
                associaPersonBean.setMetadata(new Metadata());
                String associaPerson=JSON.toJSONString(associaPersonBean);
                NetworkUtils.doPost("http://localhost:8080/sitewhere/api/assignments", associaPerson, addPersonBean.getSitewhereToken(), new ResultInfoInterface() {
                    @Override
                    public void onResponse(String result) {
//                        System.out.println(result);
                        result1 = result;

                    }
                });
            }
        });
        while(result1 == null){
            continue;
        }
        return result1;
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

    //获取devicelist
    @RequestMapping(value = "/getDeviceList", method = RequestMethod.GET)
    public String getDeviceList(@RequestParam(value="page",required=true)int page,@RequestParam(value="pageSize",required=true)int pageSize,@RequestParam(value="siteToken",required = true) String siteToken,@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){
        this.page =page;
        this.pageSize=pageSize;
        deviceListResult = null;
        String url1 = "http://localhost:8080/sitewhere/api/sites/" +siteToken+
                "/assignments?includeDevice=true&includeAsset=true&page=";
        String url2 ="&pageSize=";
        String url = url1+this.page+url2+this.pageSize;
        NetworkUtils.doGet(url, sitewhereToken, new ResultInfoInterface() {
            @Override
            public void onResponse(String result) {
                List<Data> dataList = new ArrayList<Data>();
                ResDeviceListBean resDeviceListBean=JSON.toJavaObject(JSON.parseObject(result), ResDeviceListBean.class);
                for(int i=0;i<resDeviceListBean.getResults().size();i++){
                    Data data = new Data();
                    ResultBean res = resDeviceListBean.getResults().get(i);
                    data.setAssetName(res.getAssetName());
                    data.setComments(res.getDevice().getComments());
                    data.setHardwareId(res.getDeviceHardwareId());
                    data.setName(res.getAssociatedPerson().getName());
                    data.setId(res.getAssociatedPerson().getId());
                    data.setEmailAddress(res.getAssociatedPerson().getEmailAddress());
                    data.setLocationCity(res.getDevice().getMetadata().getLocationCity());
                    data.setLocationDetial(res.getDevice().getMetadata().getLocationDetial());
                    data.setCenterLatitude(res.getDevice().getMetadata().getCenterLatitude());
                    data.setCenterLongitude(res.getDevice().getMetadata().getCenterLongitude());
                    data.setAssignToken(res.getToken());
                    dataList.add(data);
                }
                deviceList.setData(dataList);
                deviceListResult = deviceList;


            }
        });
        while(deviceListResult  == null){
            continue;
        }
        return JSON.toJSONString(deviceListResult);
    }

    //获取devicelist  筛选by sitetoken
    @RequestMapping(value = "/getSiteDevices", method = RequestMethod.GET)
    public String getSiteDevices(@RequestParam(value="siteToken",required = true) String siteToken,@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){
        siteDevicesResult = null;
        String url = "http://localhost:8080/sitewhere/api/sites/" +siteToken+
                "/assignments?includeDevice=true&includeAsset=true";
        NetworkUtils.doGet(url, sitewhereToken, new ResultInfoInterface() {
            @Override
            public void onResponse(String result) {

                List<Data> dataList = new ArrayList<Data>();
                ResDeviceListBean resDeviceListBean=JSON.toJavaObject(JSON.parseObject(result), ResDeviceListBean.class);
                for(int i=0;i<resDeviceListBean.getResults().size();i++){
                    Data data = new Data();
                    ResultBean res = resDeviceListBean.getResults().get(i);
                    data.setAssetName(res.getAssetName());
                    data.setComments(res.getDevice().getComments());
                    data.setHardwareId(res.getDeviceHardwareId());
                    data.setName(res.getAssociatedPerson().getName());
                    data.setId(res.getAssociatedPerson().getId());
                    data.setEmailAddress(res.getAssociatedPerson().getEmailAddress());
                    data.setLocationCity(res.getDevice().getMetadata().getLocationCity());
                    data.setLocationDetial(res.getDevice().getMetadata().getLocationDetial());
                    data.setCenterLatitude(res.getDevice().getMetadata().getCenterLatitude());
                    data.setCenterLongitude(res.getDevice().getMetadata().getCenterLongitude());
                    data.setAssignToken(res.getToken());
                    dataList.add(data);
                }
                siteDevices.setData(dataList);
                siteDevicesResult=siteDevices;
            }
        });
        while(siteDevicesResult == null){
            continue;
        }
        return JSON.toJSONString(siteDevicesResult);
    }



    @RequestMapping(value = "/getAllDeviceList", method = RequestMethod.GET)
    public String getAllDeviceList(@RequestParam(value="page",required=true)int page,@RequestParam(value="pageSize",required=true)int pageSize,@RequestParam(value="siteToken",required = true) String siteToken,@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){
        this.page =page;
        this.pageSize=pageSize;
        String url1 = "http://localhost:8080/sitewhere/api/devices?includeDeleted=false&excludeAssigned=false&includeSpecification=true&includeAssignment=true&page=";
        String url2 ="&pageSize=";
        String url = url1+this.page+url2+this.pageSize;
        NetworkUtils.doGet(url, sitewhereToken, new ResultInfoInterface() {
            @Override
            public void onResponse(String result) {
                allDeviceList=result;
            }
        });
        while(allDeviceList == null){
            continue;
        }
        return allDeviceList;
    }

    //获取site的device
    @RequestMapping(value = "/getSiteDeviceList", method = RequestMethod.GET)
    public String getSiteDeviceList(@RequestParam(value="page",required=true)int page,@RequestParam(value="pageSize",required=true)int pageSize,@RequestParam(value="siteToken",required = true) String siteToken,@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){
        this.page =page;
        siteDeviceList = null;
        this.pageSize=pageSize;
        String url1 = "http://localhost:8080/sitewhere/api/devices?includeDeleted=false&excludeAssigned=false&includeSpecification=true&includeAssignment=true&site="+siteToken+"&page=";
        String url2 ="&pageSize=";
        String url = url1+this.page+url2+this.pageSize;
        NetworkUtils.doGet(url, sitewhereToken, new ResultInfoInterface() {
            @Override
            public void onResponse(String result) {
                System.out.println(result);
                siteDeviceList=result;
            }
        });
        while(siteDeviceList == null){
            continue;
        }
        return siteDeviceList;
    }



    @RequestMapping(value = "/getTempVal", method = RequestMethod.GET)
    public String getTempVal(@RequestParam(value="assignToken",required = true) String assignToken,@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){
        String url = "http://localhost:8080/sitewhere/api/assignments/" +assignToken+
                "/measurements/series";
        NetworkUtils.doGet(url, sitewhereToken, new ResultInfoInterface() {
            @Override
            public void onResponse(String result) {
                resultTemp = result;
                System.out.println(result);

            }
        });

        while(resultTemp == null){
            continue;
        }
        return resultTemp;
    }

}
