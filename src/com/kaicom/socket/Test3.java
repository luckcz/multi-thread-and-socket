package com.kaicom.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Test3 {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.sojson.com/open/api/weather/json.shtml?city=武汉");
			//URL url = new URL("http://www.baidu.com");
			HttpURLConnection openConnection = (HttpURLConnection)url.openConnection();
			openConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			openConnection.connect();
			InputStream openStream = openConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(openStream);
			BufferedReader br = new BufferedReader(isr);
			String data = br.readLine();
			while(null != data){
				System.out.println(data);
				data = br.readLine();
			}
			br.close();
            isr.close();
            openStream.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
