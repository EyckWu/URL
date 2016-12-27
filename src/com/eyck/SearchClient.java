package com.eyck;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ListIterator;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SearchClient extends Applet implements ActionListener{

	TextField keyword = new TextField(30);
	Choice engine ;
	Button go = new Button("搜索");
	SearchEngine mEngine;
	
	public void init(){
		setBackground(Color.white);
		keyword = new TextField(20);
		engine = new Choice();
		engine.addItem("百度");
		engine.addItem("Google");
		engine.addItem("搜狗");
		engine.select(1);
		add(keyword);
		add(engine);
		add(go);
		//addKeyListener(new MyKeyListener());
		go.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == go){
			try{
				String key = goSearch();
				mEngine.parse(key);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}

	private String goSearch() throws Exception{
		// TODO Auto-generated method stub
		String str = keyword.getText();
		if(str.equals("")){
			JOptionPane.showMessageDialog(null, "请填写搜索的关键词");
			return null;
		}
		String engineName = "";
		switch(engine.getSelectedIndex()){
		case 0:
			engineName = "http://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=0&rsv_idx=1&tn=baidu&wd=";
			mEngine = new BaiduSearch();
			break;
		case 1:
			engineName = "https://www.google.com.hk/";
			mEngine = new GoogleSearch();
			break;
		case 2:
			engineName = "https://www.sogou.com/";
			mEngine = new SougouSearch();
			break;
		}
		//url += URLEncoder.encode(str);
		showStatus("正在等待"+engineName+"的响应");
		return str;
	}
}
