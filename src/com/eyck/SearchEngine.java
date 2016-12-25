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

	public abstract void parse(String key);
	
	public abstract String UrlEncoder(String key);
	
	public void showMessage(String key){
		String show = "�Ҳ���������ѯ��\""+key+"\"��������ݻ���Ϣ��\n"
				+ "���飺\n"
				+ "* ���������ִ����޴���\n"
				+ "* �볢��������ѯ�ʡ�\n"
				+ "* ����ýϳ������ִʡ�";
		System.out.println(show);
		JOptionPane.showMessageDialog(null, show);
	}
	
	public String search1(String url){
		BufferedReader br = null;
		StringBuilder sb ;
		String result = null;
		
		try{
			sb = new StringBuilder();
			System.out.println(url);
			URL mUrl = new URL(url);
			System.setProperty("http.agent", "Chrome");
			URLConnection conn = mUrl.openConnection();
			String hasRead = "";
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			while((hasRead=br.readLine())!=null){
				sb.append(hasRead);
			}
			result = sb.toString();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return result;
		}
	}
	
	public String search(String url){
		BufferedReader br = null;
		StringBuilder sb ;
		String result = null;
		FileWriter fw = null;
		File file = null;
		try{
			sb = new StringBuilder();
			System.out.println(url);
			URL mUrl = new URL(url);
			System.setProperty("http.agent", "Chrome");
			URLConnection conn = mUrl.openConnection();
			String hasRead = "";
			file = new File("G:\\javapractice\\Baidu\\google.html");
			fw = new FileWriter(file);
			//br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"zh_CN"));
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			while((hasRead=br.readLine())!=null){
				sb.append(hasRead);
				fw.write(hasRead);
			}
			result = sb.toString();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				br.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return result;
		}
	} 
	
}
