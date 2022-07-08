package br.com.cafBot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import br.com.cafBot.model.XY;

public class MouseMove {
	
	public void mouseMover(List<XY> xy) throws AWTException {
	    
		Robot robot = new Robot();		

//		Point p = MouseInfo.getPointerInfo().getLocation(); 
//		System.out.println(p.x);
//		System.out.println(p.y);
		
		xy.stream().forEach(f -> {			
			robot.mouseMove(f.getX(), f.getY());
//			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
//			robot.keyRelease(KeyEvent.VK_SHIFT);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});	
	}
}
