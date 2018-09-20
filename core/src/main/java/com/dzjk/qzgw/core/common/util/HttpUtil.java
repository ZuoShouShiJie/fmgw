package com.dzjk.qzgw.core.common.util;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 
 * 类功能描述：<br>
 * <ul>    
 * <li>类功能描述1<br>
 * <li>类功能描述2<br>
 * <li>类功能描述3<br>
 * </ul>
 * </ul>
 * @author linmiao
 * @version since 2016年1月6日
 */
public class HttpUtil {
	
	
	/**
	 * post提交
	 * @param url//请求地址
	 * @return String
	 */
	public static String post(String url,Map<String, Object> paramMap){
		CloseableHttpClient httpclient = HttpClients.createDefault();  			
		HttpPost httpPost = new HttpPost(url);
		StringBuilder sb = new StringBuilder();
		CloseableHttpResponse response;
		try {
			StringEntity entity = new StringEntity((String)paramMap.get("data"),"utf-8");
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			httpPost.setEntity(entity);
//			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();//设置请求和传输超时时间
//			httpPost.setConfig(requestConfig);
			response = httpclient.execute(httpPost);
			HttpEntity RspEntity = response.getEntity();
			if (RspEntity != null) {
				InputStream instreams = RspEntity.getContent();
				BufferedReader bf = new BufferedReader(new InputStreamReader(instreams,Consts.UTF_8));
				String line = null;
				while ((line = bf.readLine()) != null) {
					sb.append(line + "\n");
				}
			}
		} catch (Exception e){
		}finally{
			httpPost.abort();
			if (httpclient != null) {  
				try {  
				    httpclient.close();  
					} catch (IOException e) {  
						e.printStackTrace();  
					}  
				}  

		}
		return sb.toString();
	}
	/**
	 * post提交  只获取返回码
	 * @param url//请求地址
	 * @return String
	 */
	public static int postStatusCode(String url,Map<String, Object> paramMap){
		CloseableHttpClient httpclient = HttpClients.createDefault();  			
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> formparams = getParamList(paramMap);
		UrlEncodedFormEntity uefEntity; 
		CloseableHttpResponse response;
		int statusCode = 0;
		try {
			uefEntity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);  
			httpPost.setEntity(uefEntity);
			response = httpclient.execute(httpPost);
			statusCode = response.getStatusLine().getStatusCode();
		} catch (Exception e){
		}finally{
			httpPost.abort();
			if (httpclient != null) {  
				try {  
					httpclient.close();  
				} catch (IOException e) {  
					e.printStackTrace();  
				}  
			}  
			
		}
		return statusCode;
	}
	/**
	 * get请求
	 * @param url//请求地址
	 * @return String
	 */
	public static String get(String url){
		CloseableHttpClient httpclient = HttpClients.createDefault();  			
		HttpGet httpget = new HttpGet(url); 
		StringBuilder sb = new StringBuilder();
		CloseableHttpResponse response;
		try {
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream instreams = entity.getContent();
				BufferedReader bf = new BufferedReader(new InputStreamReader(instreams,Consts.UTF_8));
				String line = null;
				while ((line = bf.readLine()) != null) {
					sb.append(line + "\n");
				}
			}
		} catch (Exception e){
		}finally{
			httpget.abort();
			if (httpclient != null) {  
				try {  
				    httpclient.close();  
					} catch (IOException e) {  
						e.printStackTrace();  
					}  
				}  

		}
		return sb.toString();
	}
	/**
	 *  只获取返回码
	 * get请求
	 * @param url//请求地址
	 * @return int
	 */
	public static int getStatusCode(String url){
		CloseableHttpClient httpclient = HttpClients.createDefault();  			
		HttpGet httpget = new HttpGet(url); 
		int statusCode=0;
		CloseableHttpResponse response;
		try {
			response = httpclient.execute(httpget);
			statusCode = response.getStatusLine().getStatusCode();
		} catch (Exception e){
		}finally{
			httpget.abort();
			if (httpclient != null) {  
				try {  
					httpclient.close();  
				} catch (IOException e) {  
					e.printStackTrace();  
				}  
			}  
			
		}
		return statusCode;
	}

	
	private static List<NameValuePair> getParamList(Map<String, Object> paramMap) {
		Set<String> keySet = paramMap.keySet();
		Iterator<String> iterator = keySet.iterator();
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		while (iterator.hasNext()) {
			String key = iterator.next();
			nameValuePairs.add(new BasicNameValuePair(key, String.valueOf(paramMap.get(key))));
		}
		return nameValuePairs;
	}
}
