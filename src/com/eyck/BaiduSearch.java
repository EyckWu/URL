package com.eyck;

import java.net.URLEncoder;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class BaiduSearch extends SearchEngine{

	@Override
	public void parse(String key) {
		// TODO Auto-generated method stub
		String url = UrlEncoder(key);
		String result = search(url);
		int start = -1;
		int end = -1;
		Document doc = Jsoup.parse(result);
		Elements elements = doc.getElementsByClass("nums");
		String element = elements.toString();
		System.out.println(element);
		for(int i=0;i<element.length();i++){
			if(element.charAt(i)=='°Ù'){
				start = i;
			}
			if(element.charAt(i)=='¸ö'){
				end = i+1;
			}
		}
		String finalResult = element.substring(start, end);
		if(!finalResult.equals("0")){
			System.out.println(finalResult);
			JOptionPane.showMessageDialog(null, finalResult);
		}else{
			showMessage(key);
		}
		
	}

	@Override
	public String UrlEncoder(String key) {
		String url = "http://www.baidu.com/s?wd=";
		return url += URLEncoder.encode(key);
	}
}
