package com.atos.springboot.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mail")
public class SettingsMailApp {

	private String replyTo;

	private String activateSubject;

	private String activateBodyHtmlPath;

	private String activateBodyWithPasswordHtmlPath;

	private String baseUrl;

	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	public String getActivateSubject() {
		return activateSubject;
	}

	public void setActivateSubject(String activateSubject) {
		this.activateSubject = activateSubject;
	}

	public String getActivateBodyHtmlPath() {
		return activateBodyHtmlPath;
	}

	public void setActivateBodyHtmlPath(String activateBodyHtmlPath) {
		this.activateBodyHtmlPath = activateBodyHtmlPath;
	}

	public String getActivateBodyWithPasswordHtmlPath() {
		return activateBodyWithPasswordHtmlPath;
	}

	public void setActivateBodyWithPasswordHtmlPath(String activateBodyWithPasswordHtmlPath) {
		this.activateBodyWithPasswordHtmlPath = activateBodyWithPasswordHtmlPath;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
}
