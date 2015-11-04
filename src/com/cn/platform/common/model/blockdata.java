package com.cn.platform.common.model;

public class blockdata {
	private int id;
	private String username;
	private String userip;
	private String accesstime;
	private String serveruri;
	private Double flow;
	private int serverid;
	public int getServerid() {
		return serverid;
	}
	public void setServerid(int serverid) {
		this.serverid = serverid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserip() {
		return userip;
	}
	public void setUserip(String userip) {
		this.userip = userip;
	}
	public String getAccesstime() {
		return accesstime;
	}
	public void setAccesstime(String accesstime) {
		this.accesstime = accesstime;
	}
	public String getServeruri() {
		return serveruri;
	}
	public void setServeruri(String serveruri) {
		this.serveruri = serveruri;
	}
	public Double getFlow() {
		return flow;
	}
	public void setFlow(Double flow) {
		this.flow = flow;
	}
}
