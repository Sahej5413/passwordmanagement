package org.ass.passwordmanagement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "password_details")
public class ApplicationEntity implements Serializable {
	@Id
	@GenericGenerator(name = "reg_auto", strategy = "increment")
	@GeneratedValue(generator = "reg_auto")
	@Column(name = "app_id")
	private long id;
	@Column(name = "app_name")
	private String appName;
	@Column(name = "app_url")
	private String appUrl;
	@Column(name = "app_type")
	private String appType;
	@Column(name = "app_password")
	private String password;
	@Column(name = "app_status")
	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getUrl() {
		return appUrl;
	}

	public void setUrl(String appUrl) {
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

	@Override
	public String toString() {
		return "ApplicationEntity [id=" + id + ", appName=" + appName + ", url=" + appUrl + ", appType=" + appType
				+ ", password=" + password + ", status=" + status + "]";
	}

}
