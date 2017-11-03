package com.monitor.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.log4j.Logger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class GetRequest {
    private String url = "https://api.saj-solar.com/accessToken?client_id=15426&client_secret=2E7D9390-D68C-436D-A632-798422781066&grant_type=2E7D9390-D68C-436D-A632-798422781066&scope=read,write";
    
    private Logger logger;
    public GetRequest() {
        logger = Logger.getLogger(GetRequest.class);
    }
    private static void trustAllHttpsCertificates() throws Exception {
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }
    //为更好的演示，去掉了不相关的代码
    public String getData() {
    	
    	
        //this.url = url;
        BufferedReader in = null;
        HttpURLConnection conn = null;
        JsonPrimitive arrayJson = null;
        String result = "";
        try {//该部分必须在获取connection前调用
            trustAllHttpsCertificates();
            HostnameVerifier hv = new HostnameVerifier() {
                public boolean verify(String urlHostName, SSLSession session) {
                   // logger.info("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
            conn = (HttpURLConnection)new URL(url).openConnection();
            // 发送GET请求必须设置如下两行
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            // flush输出流的缓冲
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            //此处直接解析得到token
            JsonParser parser = new JsonParser();
    		JsonElement el2 = parser.parse(result);
    		// System.out.println(el2);
    		JsonObject element = el2.getAsJsonObject();

    		JsonObject dataJson = null;
    		
    		if (element.isJsonObject()) {
    			dataJson = element.getAsJsonObject("data");
    		}	
    		arrayJson = dataJson.getAsJsonPrimitive("access_token");

        } catch (Exception e) {
            logger.error("发送 GET 请求出现异常！\t\n"+e.getMessage()+"\n");
        } finally {// 使用finally块来关闭输出流、输入流
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                logger.error("关闭数据流出错了！\n"+ex.getMessage()+"\n");
            }
        }
      
        return arrayJson.toString();
    }
    static class miTM implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }

        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }
    }
}
