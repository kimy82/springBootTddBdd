package com.atos.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.atos.springboot.settings.SettingsMongoApp;
import com.github.mongobee.Mongobee;
import com.github.mongobee.exception.MongobeeException;

@Configuration
public class MongoInitialLoading {

	@Autowired
	private SettingsMongoApp settingsMongoApp;

	@Bean
	public Mongobee mongobee() throws MongobeeException {
		Mongobee runner = new Mongobee(getMongoDBUrl());
		runner.setDbName(this.settingsMongoApp.getDatabase());
		runner.setChangeLogsScanPackage("com.atos.springboot.changelogs");
		runner.setEnabled(true);
		return runner;
	}

	private String getMongoDBUrl() {
		return String.format("mongodb://%s:%s/%s", this.settingsMongoApp.getHost(),this.settingsMongoApp.getPort(), this.settingsMongoApp.getDatabase());
	}
}
