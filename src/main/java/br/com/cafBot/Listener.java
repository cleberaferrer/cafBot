package br.com.cafBot;

import java.awt.AWTException;
import java.util.List;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import br.com.cafBot.model.XY;

public class Listener implements NativeKeyListener {
	public static List<XY> xy = null; 
	
	public Listener() {		
	}	
	
	public Listener(List<XY> listXY) {
		xy = listXY;
	}	
	
	public void nativeKeyPressed(NativeKeyEvent e) {
		if (e.getKeyCode() == NativeKeyEvent.VC_H){
			try {
				new MouseMove().mouseMover(xy);
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (e.getKeyCode() == NativeKeyEvent.VC_SPACE){
			System.out.print(" ");
		}else{
			System.out.print(NativeKeyEvent.getKeyText(e.getKeyCode()));
		}
	}
	
	public void nativeKeyReleased(NativeKeyEvent e) {
	}

	public void nativeKeyTyped(NativeKeyEvent e) {
	}
	
	public void startListener() {
		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException ex) {
			System.err
					.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}

		// Construct the example object and initialze native hook.
		GlobalScreen.addNativeKeyListener(new Listener(new PropertiesCafBot().getListXY()));
	}
	
	public void stopListener() {
		try {
			GlobalScreen.unregisterNativeHook();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
