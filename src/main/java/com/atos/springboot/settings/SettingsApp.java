package com.atos.springboot.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="tech")
public class SettingsApp {

	private String javaversion;

	public String getJavaversion() {
		return javaversion;
	}

	public void setJavaversion(String javaversion) {
		this.javaversion = javaversion;
	}
	
}
