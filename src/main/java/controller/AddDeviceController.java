package controller;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.regexp.internal.RE;
import db.DbManager;
import interfaces.ResultInfoInterface;
import model.*;
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
    private String result1 = "";
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
        while(result1 != null){
           return result1;
        }
        return result1;


    }


}
