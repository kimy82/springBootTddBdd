package com.atos.springboot.settings;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.atos.springboot.AtosApplication;
import com.atos.springboot.settings.SettingsApp;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AtosApplication.class)
@WebAppConfiguration
public class SettingsAppTest {

	@Autowired
	private SettingsApp settingsApp;
	
	@Test
	public void settings_isNotNull(){
		assertThat(this.settingsApp, is(notNullValue()));
		assertThat(this.settingsApp.getJavaversion(), is(notNullValue()));
	}
}
