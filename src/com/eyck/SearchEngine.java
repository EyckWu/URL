package com.eyck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;

public abstract class SearchEngine {
	//由解析网页源码，由子类实现
	public abstract void parse(String key);
	//进行URL编码，由子类实现
	public abstract String UrlEncoder(String key);
	//搜索不到相关内容
	public void showErrorMessage(String key){
		String show = "找不到和您查询的\""+key+"\"相符的内容或信息。\n"
				+ "建议：\n"
				+ "* 请检查输入字词有无错误。\n"
				+ "* 请尝试其他查询词。\n"
				+ "* 请改用较常见的字词。";
		System.out.println(show);
		JOptionPane.showMessageDialog(null, show);
	}
	//获取网页源码
	public String search(String url){
		BufferedReader br = null;
		StringBuilder sb ;
		String result = null;
//		FileWriter fw = null;
//		File file = null;
		try{
			sb = new StringBuilder();
			System.out.println(url);
			URL mUrl = new URL(url);
			System.setProperty("http.agent", "Chrome");//支持Google搜索
			URLConnection conn = mUrl.openConnection();
			String hasRead = "";
//			file = new File("G:\\javapractice\\Baidu\\google.html");
//			fw = new FileWriter(file);
//			br = new BufferedReader(new InputStreamReader(mUrl.openStream(),"utf-8"));
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			while((hasRead=br.readLine())!=null){
				sb.append(hasRead);
//				fw.write(hasRead);
			}
			result = sb.toString();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				br.close();
//				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return result;
		}
	}
	 
	
}
