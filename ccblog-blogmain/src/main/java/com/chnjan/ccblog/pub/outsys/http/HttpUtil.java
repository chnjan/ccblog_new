/**
 * 
 */
package com.chnjan.ccblog.pub.outsys.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import com.chnjan.ccblog.pub.sysparam.SystemParamUtil;

/**
 * @author chenjian
 * @date 2018年6月14日
 * 
 * http请求工具类
 */
public class HttpUtil {
	
	private static HttpClient httpClient = HttpClients.createDefault();

	/**
	 * 向指定url发送get请求
	 * @param url 请求的地址
	 * @param params 需要携带的参数（会拼在地址后面）
	 * @return String 响应的内容
	 * @throws URISyntaxException,ClientProtocolException,IOException
	 * */
	public static String httpget(String url, Map<String, String> params) throws URISyntaxException, 
			ClientProtocolException, IOException {
		//新建get请求
		HttpGet getMethod = new HttpGet();
		//构建地址
		URIBuilder uriBuilder = new URIBuilder(url);
		//设置参数
		if (params != null) {
			Set<Entry<String, String>> set = params.entrySet();
			Iterator<Entry<String, String>> iterator = set.iterator();
			while (iterator.hasNext()) {
				Entry<String, String> param = iterator.next();
				uriBuilder.addParameter(param.getKey(), param.getValue());
			}
		}
		URI uri = uriBuilder.build();
		//指定get请求的地址
		getMethod.setURI(uri);
		
		//发送http get请求并接收返回数据
		HttpResponse response = httpClient.execute(getMethod);
		//定义返回的消息
		String responseString = "";
		//判断请求是否成功
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode == 200) {
			//获取返回内容
			HttpEntity entity = response.getEntity();
			System.out.println(response.toString());
			String charset = SystemParamUtil.getSysValue("outsys.httputil.charset");
			if (StringUtils.isEmpty(charset)) {
				charset = "utf-8";
			}
			responseString = EntityUtils.toString(entity,charset);
		}
		
		return responseString;
	}
	
	
	/**
	 * 向指定url发送post请求
	 * @param url 请求的地址
	 * 
	 * @param content 请求内容
	 * @return String 响应的内容
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static String httppost(String url, String content) throws ClientProtocolException, IOException {
		//@param miniType 内容类型，如：application/json;charset=utf-8
		//新建post请求---------
		HttpPost httpPost = new HttpPost(url);
		//httpPost.setHeader("Content-Type", miniType);
		//String charset = SystemParamUtil.getSysValue("outsys.httputil.charset");
		//以json的类型构造entity
		HttpEntity entity = new StringEntity(content, ContentType.APPLICATION_JSON);
		httpPost.setEntity(entity);
		
		//执行post请求
		HttpResponse response = httpClient.execute(httpPost);
		
		//定义返回的消息
		String responseString = "";
		//返回状态码
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode == 200) {
			//获取返回内容
			HttpEntity rentity = response.getEntity();
			System.out.println(response.toString());
			String charset = SystemParamUtil.getSysValue("outsys.httputil.charset");
			if (StringUtils.isEmpty(charset)) {
				charset = "utf-8";
			}
			responseString = EntityUtils.toString(rentity,charset);
		}
		
		return responseString;
	}
}
