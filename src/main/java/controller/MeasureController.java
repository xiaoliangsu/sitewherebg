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
@RequestMapping("/measure")
@Import(GlobalCorsConfig.class)
public class MeasureController {

    private String result1 = null;

    private String StartMeasuresResult = null;
    private String StartAlertResult = null;

    //获取measures
    @RequestMapping(value = "/getMeasures", method = RequestMethod.GET)
    public String getMeasures(@RequestParam(value="assignToken",required = true) String assignToken,@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){

        String url = "http://localhost:8080/sitewhere/api/assignments/"+assignToken+"/measurements/series";
        NetworkUtils.doGet(url, sitewhereToken, new ResultInfoInterface() {
            @Override
            public void onResponse(String result) {
                System.out.println(result);
                result1 = result;
//                List<MeasureBean> measureBean=JSON.toJavaObject(JSON.parseObject(result), MeasureBean.class);


            }
        });
        while(result1 == null){
            continue;
        }
        return result1;
    }


    //获取某时间点以后measures
    @RequestMapping(value = "/getStartMeasures", method = RequestMethod.GET)
    public String getStartMeasures(@RequestParam(value="startDate",required = true) String startDate,@RequestParam(value="assignToken",required = true) String assignToken,@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){

        String url = "http://localhost:8080/sitewhere/api/assignments/"+assignToken+"/measurements/series?startDate="+startDate;
        NetworkUtils.doGet(url, sitewhereToken, new ResultInfoInterface() {
            @Override
            public void onResponse(String result) {
                System.out.println(result);
                StartMeasuresResult = result;
//                List<MeasureBean> measureBean=JSON.toJavaObject(JSON.parseObject(result), MeasureBean.class);


            }
        });
        while(StartMeasuresResult == null){
            continue;
        }
        return StartMeasuresResult;
    }

    private String getDatafromFile(String fileName) {

        String Path="/Users/zhangyunlong/Downloads/china-main-city/" + fileName+ ".json";
        BufferedReader reader = null;
        String laststr = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }

    @RequestMapping(value = "/getCityJson", method = RequestMethod.GET)
    public String getCityJson(@RequestParam(value="cityName",required = false) String cityName,@RequestParam(value="sitewhereToken",required = false) String sitewhereToken){

        String resultCity = null;

        resultCity=getDatafromFile(cityName);
        return resultCity;
    }

    @RequestMapping(value = "/getStartAlert", method = RequestMethod.GET)
    public String getStartAlert(@RequestParam(value="startDate",required = true) String startDate,@RequestParam(value="siteToken",required = true) String siteToken,@RequestParam(value="sitewhereToken",required = true) String sitewhereToken){

        String url = "http://localhost:8080/sitewhere/api/sites/"+siteToken+"/alerts?startDate="+startDate;
        NetworkUtils.doGet(url, sitewhereToken, new ResultInfoInterface() {
            @Override
            public void onResponse(String result) {
                System.out.println(result);
                StartAlertResult = result;
//                List<MeasureBean> measureBean=JSON.toJavaObject(JSON.parseObject(result), MeasureBean.class);


            }
        });
        while(StartAlertResult == null){
            continue;
        }
        return StartAlertResult;
    }






}
