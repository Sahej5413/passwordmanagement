package org.ass.passwordmanagement.dto;

import java.io.Serializable;

public class ApplicationDto implements Serializable{
private String appName;
private String appUrl;
private String appType;
private String password;
private String status;
public String getAppName() {
	return appName;
}
public void setAppName(String appName) {
	this.appName = appName;
}
public String getAppUrl() {
	return appUrl;
}
public void setAppUrl(String appUrl) {
	this.appUrl = appUrl;
}
public String getAppType() {
	return appType;
}
public void setAppType(String appType) {
	this.appType = appType;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
