package com.in28mins.rest.webservices.beans;

public class HelloWorldBean {
	
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public HelloWorldBean(String msg1)
	{
		this.msg=msg1;
		}

}
