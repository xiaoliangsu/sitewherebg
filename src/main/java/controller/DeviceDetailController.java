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
import model.Measure.MeasureBean;
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
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
@ComponentScan
@Configuration
@EnableAutoConfiguration
@RestController
@RequestMapping("/deviceInfo")
@Import(GlobalCorsConfig.class)
public class DeviceDetailController {
    private String resultDetail = null;

    //获取device Detail
    @RequestMapping(value = "/getDetail", method = RequestMethod.GET)
    public String getDetail(@RequestParam(value="hardwareId",required = true) String hardwareId,@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){

        String url = "http://localhost:8080/sitewhere/api/devices/"+hardwareId;
        NetworkUtils.doGet(url, sitewhereToken, new ResultInfoInterface() {
            @Override
            public void onResponse(String result) {
                System.out.println(result);
                resultDetail = result;
//                List<MeasureBean> measureBean=JSON.toJavaObject(JSON.parseObject(result), MeasureBean.class);


            }
        });
        while(resultDetail == null){
            continue;
        }
        return resultDetail;
    }

}
