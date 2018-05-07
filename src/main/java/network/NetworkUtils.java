package network;


import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSON;
import interfaces.ResultInfoInterface;
import model.UserBean;
import okhttp3.*;

public class NetworkUtils {

	private static OkHttpClient okHttpClient=new OkHttpClient.Builder().build();
	
	public static void doGet(String url, String tenantId,final ResultInfoInterface resultInfoInterface){
		Request request = new Request.Builder()
				.url(url)
				.addHeader("Authorization","Basic YWRtaW46cGFzc3dvcmQ=")
				.addHeader("X-SiteWhere-Tenant",tenantId) //"sitewhere1234567890"
				.build();
		Call call=okHttpClient.newCall(request);
		call.enqueue(new Callback() {
			
			@Override
			public void onResponse(Call arg0, Response arg1) throws IOException {
				// TODO Auto-generated method stub
				String result=arg1.body().string();
				// 返回实体类对象
				/*UserBean userBean=JSON.parseObject(result, UserBean.class);
				userBean.getName();
				List<UserBean> userList=JSON.parseArray(result, UserBean.class);
				userList.get(0).getName();
				userList.size();//大小*/
//				System.out.println(arg1.body().string());
				resultInfoInterface.onResponse(result);
				
			}
			
			@Override
			public void onFailure(Call arg0, IOException arg1) {
				// TODO Auto-generated method stub
				
			}
		});
	}


	public static void doPost(String url, String json,String tenantId, final ResultInfoInterface resultInfoInterface){
		//上传json
        //1 设置类型
		MediaType mediaType=MediaType.parse("application/json");
        //2 构造RequestBody，json就是实际传入的json字符串的内容
		RequestBody requestBody=RequestBody.create(mediaType,json);
        //3 创建Request请求
		Request request=new Request.Builder()
				.url(url)
				.addHeader("Authorization","Basic YWRtaW46cGFzc3dvcmQ=")
				.addHeader("X-SiteWhere-Tenant",tenantId)
				.post(requestBody)
				.build();
        //4 创建call对象
		Call call=okHttpClient.newCall(request);
        //执行请求
		call.enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {

			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
//				System.out.println(response.body().string());
				resultInfoInterface.onResponse(response.body().string());
			}
		});
	}
}
