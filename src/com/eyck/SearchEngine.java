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
	//�ɽ�����ҳԴ�룬������ʵ��
	public abstract void parse(String key);
	//����URL���룬������ʵ��
	public abstract String UrlEncoder(String key);
	//���������������
	public void showErrorMessage(String key){
		String show = "�Ҳ���������ѯ��\""+key+"\"��������ݻ���Ϣ��\n"
				+ "���飺\n"
				+ "* ���������ִ����޴���\n"
				+ "* �볢��������ѯ�ʡ�\n"
				+ "* ����ýϳ������ִʡ�";
		System.out.println(show);
		JOptionPane.showMessageDialog(null, show);
	}
	//��ȡ��ҳԴ��
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
			System.setProperty("http.agent", "Chrome");//֧��Google����
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
