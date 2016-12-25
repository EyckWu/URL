package com.eyck;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyListener extends KeyAdapter{
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("xxx");
		super.keyReleased(e);
		System.out.println("xxx");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println("xxx");
		super.keyTyped(e);
		System.out.println("xxx");
	}

	public void keyPressed(KeyEvent e){ 
		System.out.println("xxx");
        char charA=e.getKeyChar();  
        System.out.println("Äã°´ÁË¡¶"+charA+"¡·¼ü");  
    }  

}
