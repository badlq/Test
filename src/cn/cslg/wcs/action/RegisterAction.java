package cn.cslg.wcs.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.cslg.wcs.dao.UserDAL;

public class RegisterAction extends ActionSupport {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute() throws Exception{
		UserDAL useDAL=new UserDAL();
		useDAL.addUser(this.getUsername(), this.getPassword());
		return "success";
	}
}
