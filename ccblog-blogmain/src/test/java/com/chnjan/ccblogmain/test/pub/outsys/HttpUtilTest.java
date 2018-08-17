/**
 * 
 */
package com.chnjan.ccblogmain.test.pub.outsys;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.chnjan.ccblog.pub.outsys.http.HttpUtil;

/**
 * @author chenjian
 * @date 2018年6月15日
 */
public class HttpUtilTest {

	@Test
	public void testhttpget() throws ClientProtocolException, URISyntaxException, IOException{
		String uri = "http://localhost:8088/ccuser/user/signin";
		Map<String, String> parms = new HashMap<>();
		parms.put("name", "chnj");
		//String resultstring = HttpUtil.httpget(uri, parms);
		//System.out.println(resultstring);
	}
	
	@Test
	public void testhttppost() throws ClientProtocolException, URISyntaxException, IOException{
		String uri = "http://localhost:8088/ccuser/outsys/user/token";
		String postMsg = "{\"systemid\":\"blogmain_汉字\",\"token\":\"20184567854211\"}";
		//String resultstring = HttpUtil.httppost(uri, postMsg);
		//System.out.println(resultstring);
	}
}
