package com.eyck;

import java.net.URLEncoder;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class GoogleSearch extends SearchEngine{

	@Override
	public void parse(String key) {
		// TODO Auto-generated method stub
		String url = UrlEncoder(key);
		String result = search(url);
		int start = -1;
		int end = -1;
		Document doc = Jsoup.parse(result);
		Element elements = doc.getElementById("resultStats");
		String element = elements.toString();
		System.out.println(element);
		
		for(int i=0;i<element.length();i++){
			if(element.charAt(i)=='>'&&start==(-1)){
				start=i;
			}
			if(element.charAt(i)=='<'&&end==(-1)&&start!=(-1)){
				end=i;
			}
		}
		if(end-start>3){
			String finalResult = element.substring(start+7, end-7);
			System.out.println(finalResult);
			JOptionPane.showMessageDialog(null, "Google找到了约"+finalResult+"条结果");
		}else{
			showMessage(key);
		}
		
	}

	@Override
	public String UrlEncoder(String key) {
		String url = "https://www.google.com.hk/search?q="; 
		return url += URLEncoder.encode(key);
	}

}
