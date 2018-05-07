package controller;
import com.alibaba.fastjson.JSON;
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

import java.util.ArrayList;
import java.util.List;

@ComponentScan
@Configuration
@EnableAutoConfiguration
@RestController
@RequestMapping("/user")
public class UserController {
    private String name;
    private int pwd;
    
    @GetMapping(value="/index")
	public String index(){
    	/*String url="http://localhost:8080/sitewhere/api/assets/categories";
		NetworkUtils.doGet(url, new ResultInfoInterface() {
			@Override
			public void onResponse(String result) {
				//返回实体类对象
				*//*UserBean userBean=JSON.parseObject(result, UserBean.class);
				userBean.getName();
				List<UserBean> userList=JSON.parseArray(result, UserBean.class);
				userList.get(0).getName();
				userList.size();//大小*//*
			}
		});*/
		//连接siteware
		/*AssetsBean assetsBean=new AssetsBean();
		assetsBean.setAssetType("Device");
		assetsBean.setId("my-devices");
		assetsBean.setName("MY Device");
		String ass=JSON.toJSONString(assetsBean);
		//连接siteware
		NetworkUtils.doPost("http://localhost:8080/sitewhere/api/assets/categories", ass, new ResultInfoInterface() {
			@Override
			public void onResponse(String result) {
				System.out.println(result);
			}
		});*/
		TenantBean tenantBean = new TenantBean();
		tenantBean.setId("myTenant1111111");
		tenantBean.setAuthenticationToken("sitewhere1111111");
		tenantBean.setName("myTenant1111111");
		List<String> userIds= new ArrayList<String>();
		userIds.add("admin");
		tenantBean.setAuthorizedUserIds(userIds);
		tenantBean.setTenantTemplateId("empty");
		tenantBean.setMetadata(new Metadata());
		tenantBean.setLogoUrl("https://s3.amazonaws.com/sitewhere-demo/sitewhere-small.png");
		String tean=JSON.toJSONString(tenantBean);
		NetworkUtils.doPost("http://localhost:8080/sitewhere/api/tenants", tean, new ResultInfoInterface() {
			@Override
			public void onResponse(String result) {
				System.out.println(result);
			}
		});


		//操作数据库 每一次用sql之前都要用init和close  close之后如果再用sql，需要重新init
		DbManager.getInstance().init();
//		DbManager.getInstance().insert("a",123);
		List<UserInfoBean> userInfoBeans=DbManager.getInstance().select("loutong");
		DbManager.getInstance().close();
		return "ok";
	}
	
	//get请求时，如果不传入参数，函数形参为空就行了
	//第一种get方式
	@GetMapping(value="/register1/{name}&{pwd}")
	public void register1(@PathVariable String name,@PathVariable int pwd){
		//这里写自己的处理逻辑
		this.name=name;
		this.pwd=pwd;
		AssetsBean assetsBean=new AssetsBean();
		assetsBean.setAssetType("Device");
		assetsBean.setId("my-devices");
		assetsBean.setName("MY Device");
		String ass=JSON.toJSONString(assetsBean);
		//连接siteware
		NetworkUtils.doPost("http://localhost:8080/sitewhere/api/assets/categories", ass, new ResultInfoInterface() {
			@Override
			public void onResponse(String result) {
				System.out.println(result);
			}
		});
	}
	
	//第二种get方式
	@RequestMapping(value = "/register2", method = RequestMethod.GET)
	public void register2(@RequestParam(value="name",required=true)String name,@RequestParam(value="pwd",required=true)int pwd){
		this.name=name;
		this.pwd=pwd;
	}
	
	//post方式传递数据
	//以键值对的方式发送数据
	@RequestMapping(value = "/loginparams", method = RequestMethod.POST)
	public String loginWithParams(@RequestParam(value="name",required=true)String name,@RequestParam(value="pwd",required=true)int pwd){
		if(this.name.equals(name)&&this.pwd==pwd){
			return "login success";
		}
		return "login fail";
	}


	
	//以json字符串的方式发送数据
	@RequestMapping(value = "/loginJson", method = RequestMethod.POST)
	public String loginWithJson(@RequestBody UserBean userBean){
		String result="";
		if(userBean!=null){
			System.out.println(userBean.getName()+userBean.getPwd());
		}
		//对象转成字符串
		//JSON.toJSONString(userBean);
		return result;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody UserInfoBean userInfoBean){
		String result="";
		if(userInfoBean!=null){
			System.out.println(userInfoBean.getName()+userInfoBean.getPwd());
		}
		DbManager.getInstance().init();
		List<UserInfoBean> userInfoBeans=DbManager.getInstance().select(userInfoBean.getName());

		if(userInfoBeans==null){
			System.out.println(userInfoBeans);

		}
		DbManager.getInstance().close();
		//对象转成字符串
		//JSON.toJSONString(userBean);
		return result;
	}
	
	public void delete(){
		
	}

}
