package br.com.cafBot;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import br.com.cafBot.model.XY;

public class PropertiesCafBot {
//	private String cafBotHomeDir = System.getenv("CAFBOT");
	private String cafBotHomeDir = System.getProperty("user.dir");
	private static final String PROP_CAFBOT_FILENAME = "cafBot.properties";
	private static Properties properties;
	
	public PropertiesCafBot() {
		
		final String prop = cafBotHomeDir + File.separator + PROP_CAFBOT_FILENAME;
		InputStream configFile = null;
		
		try {
			File f = new File(prop);
			
			if (f.exists()) {
				configFile = new FileInputStream(f);
			}
			properties = new Properties();
			properties.load(configFile);			
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	
	public String getPropertyLootGetter() {
		return properties.getProperty("cafBot.xyLootGetter");
	}
	
	public List<XY> getListXY() {
		final List<XY> listXY = new ArrayList<>();
		Arrays.asList(getPropertyLootGetter().split(";")).stream().forEach(f -> {
			final XY xy = new XY();
			xy.setX(Integer.parseInt(f.split(",")[0].trim()));
			xy.setY(Integer.parseInt(f.split(",")[1].trim()));
			listXY.add(xy);
		});
		
		return listXY;
	}
}
