package controller;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.regexp.internal.RE;
import config.GlobalCorsConfig;
import db.DbManager;
import db.DbDeviceManage;
import interfaces.ResultInfoInterface;
import model.*;
import model.AssetHardware.AssetHardwareBean;
import model.AssetHardware.Properties;
import model.ResSpecBean.ResSpecBean;
import model.SpecBean.SpecBean;
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
@RequestMapping("/user")
@Import(GlobalCorsConfig.class)
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
//		NetworkUtils.doPost("http://localhost:8080/sitewhere/api/tenants", tean, new ResultInfoInterface() {
//			@Override
//			public void onResponse(String result) {
//				System.out.println(result);
//			}
//		});


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
//		NetworkUtils.doPost("http://localhost:8080/sitewhere/api/assets/categories", ass, new ResultInfoInterface() {
//			@Override
//			public void onResponse(String result) {
//				System.out.println(result);
//			}
//		});
	}
	
	//第二种get方式
	@RequestMapping(value = "/register2", method = RequestMethod.GET)
	public String register2(@RequestParam(value="name",required=true)String name,@RequestParam(value="pwd",required=true)int pwd){
		this.name=name;
		this.pwd=pwd;
		return this.name;
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
    	//登录状态返回值
		LoginStatusBean loginStatusBean=new LoginStatusBean();
//		if(userInfoBean!=null){
//			System.out.println(userInfoBean.getName()+userInfoBean.getPwd());
//
//		}
		DbManager.getInstance().init();
//		DbManager.getInstance().insert("loutong",123,"user Agent1","12345");

		List<UserInfoBean> userInfoBeans=DbManager.getInstance().select(userInfoBean.getName());
		//如果用户名不存在
		if(userInfoBeans.size() == 0 ){
			loginStatusBean.setStatus(0);
			loginStatusBean.setMsg("用户不存在");
		}else{
			if(userInfoBeans.get(0).getPwd() ==userInfoBean.getPwd()){
				loginStatusBean.setStatus(1);
				loginStatusBean.setMsg("登录成功！");
				UserData userData = new UserData();
				userData.setTenantToken(userInfoBeans.get(0).getUnitId());
				userData.setName(userInfoBeans.get(0).getName());
				loginStatusBean.setUserData(userData);
			}else {
				loginStatusBean.setStatus(2);
				loginStatusBean.setMsg("密码不正确，请重新填写！");

			}
		}
		DbManager.getInstance().close();
		//对象转成字符串
		//JSON.toJSONString(userBean);
		return JSON.toJSONString(loginStatusBean);

	}
	//注册，然后注册tenant ，注册asset，assethardware，spec，向数据库存储spectoken，sitewheretoken
	@RequestMapping(value = "/regist",method = RequestMethod.POST)
	public String regist(@RequestBody final UserInfoBean userInfoBean){
    	LoginStatusBean loginStatusBean = new LoginStatusBean();
		DbManager.getInstance().init();
		List<UserInfoBean> userInfoBeans=DbManager.getInstance().select(userInfoBean.getName());
		if(userInfoBeans.size() ==0){
			DbManager.getInstance().insert(userInfoBean.getName(),userInfoBean.getPwd(),userInfoBean.getUnitName(),userInfoBean.getUnitId());
			userInfoBeans=DbManager.getInstance().select(userInfoBean.getName());
			if(userInfoBeans.size() ==1){
				loginStatusBean.setStatus(1);
				loginStatusBean.setMsg("注册成功！");
				TenantBean tenantBean  = new TenantBean();
				tenantBean.setId(userInfoBean.getUnitId());
				tenantBean.setAuthenticationToken(userInfoBean.getUnitId());
				tenantBean.setName(userInfoBean.getName());
				List<String>userIds= new ArrayList<String>();
				userIds.add("admin");
				tenantBean.setAuthorizedUserIds(userIds);
				tenantBean.setTenantTemplateId("empty");
				tenantBean.setMetadata(new Metadata());
				tenantBean.setLogoUrl("https://s3.amazonaws.com/sitewhere-demo/sitewhere-small.png");
				String tean=JSON.toJSONString(tenantBean);
				NetworkUtils.doPost("http://localhost:8080/sitewhere/api/tenants", tean, userInfoBean.getUnitId(), new ResultInfoInterface() {
					@Override
					public void onResponse(String result) {
						String sitewhereToken = userInfoBean.getUnitId();
						String startUrl1 = "http://localhost:8080/sitewhere/api/tenants/";
						String startUrl2 = "/engine/start";
						String startUrl = startUrl1+sitewhereToken+startUrl2;
						NetworkUtils.doPost(startUrl, "", "", new ResultInfoInterface() {
							@Override
							public void onResponse(String result) {
								AssetBean assetBean = new AssetBean();
								assetBean.setId("heat-equip");
								assetBean.setName("制热设备");
								assetBean.setAssetType("Device");
								final String asset=JSON.toJSONString(assetBean);
								final String sitewhereToken = userInfoBean.getUnitId();
								NetworkUtils.doPost("http://localhost:8080/sitewhere/api/assets/categories", asset, sitewhereToken, new ResultInfoInterface() {
									@Override
									public void onResponse(String result) {
										AssetHardwareBean assetHardwareBean = new AssetHardwareBean();
										assetHardwareBean.setId("heat-hard-id-1");
										assetHardwareBean.setName("无焰制热设备");
										assetHardwareBean.setImageUrl("img-url");
										Properties properties = new Properties();
										properties.setMaxHeatParams("3.5万大卡/小时");
										properties.setScale("920X1100X2500");
										properties.setHeatArea(">=1000");
										properties.setOutMaxTemp("95摄氏度");
										properties.setInMaxTemp("65摄氏度");
										properties.setTotalPowerComsum("0.6kw/h");
										properties.setMaxAge(">=10年");
										properties.setTotalWeight("350kg");
										properties.setWaterPa("0.6MPA");
										properties.setGasPa("0.1MPA");
										assetHardwareBean.setProperties(properties);
										assetHardwareBean.setSku("ZY-WY0D-30000");
										assetHardwareBean.setDescription("无焰制热设备详情");
										final String assetHardware=JSON.toJSONString(assetHardwareBean);
										NetworkUtils.doPost("http://localhost:8080/sitewhere/api/assets/categories/heat-equip/hardware", assetHardware, sitewhereToken, new ResultInfoInterface() {
											@Override
											public void onResponse(String result) {
												SpecBean specBean = new SpecBean();
												specBean.setAssetId("heat-hard-id-1");
												specBean.setAssetModuleId("heat-equip");
												specBean.setContainerPolicy("Standalone");
												specBean.setName("无焰制热设备规格");
												final String spec=JSON.toJSONString(specBean);
												NetworkUtils.doPost("http://localhost:8080/sitewhere/api/specifications", spec, sitewhereToken, new ResultInfoInterface() {
													@Override
													public void onResponse(String result) {
														ResSpecBean resSpecBean=JSON.toJavaObject(JSON.parseObject(result), ResSpecBean.class);
														DbDeviceManage.getInstance().init();
														DbDeviceManage.getInstance().insert(userInfoBean.getName(),"",resSpecBean.getToken(),sitewhereToken,resSpecBean.getName());
														DbDeviceManage.getInstance().close();

													}
												});
											}
										});

									}
								});
								AssetBean assetPersonBean = new AssetBean();
								assetPersonBean.setId("default-person-asset");
								assetPersonBean.setName("default-person-asset");
								assetPersonBean.setAssetType("Person");
								final String assetPerson=JSON.toJSONString(assetPersonBean);
								NetworkUtils.doPost("http://localhost:8080/sitewhere/api/assets/categories", assetPerson, sitewhereToken, new ResultInfoInterface() {
									@Override
									public void onResponse(String result) {


									}
								});
								AssetBean assetLocBean = new AssetBean();
								assetLocBean.setId("default-loc-asset");
								assetLocBean.setName("default-loc-asset");
								assetLocBean.setAssetType("Location");
								final String assetLoc=JSON.toJSONString(assetLocBean);
								NetworkUtils.doPost("http://localhost:8080/sitewhere/api/assets/categories", assetLoc, sitewhereToken, new ResultInfoInterface() {
									@Override
									public void onResponse(String result) {


									}
								});



							}
						});
					}
				});

			}

		}else{
			loginStatusBean.setStatus(0);
			loginStatusBean.setMsg("用户名已经存在，注册失败，请尝试其他用户名");
		}
		DbManager.getInstance().close();
		//对象转成字符串
		//JSON.toJSONString(userBean);
		return JSON.toJSONString(loginStatusBean);

	}


	
	public void delete(){
		
	}

}
