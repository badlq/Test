package cn.cslg.wcs.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.cslg.wcs.dao.UserDAL;

public class LoginAction extends ActionSupport{
	
	/**
	 * 
	 */
	private String username;
	private String password;
	
	private String pageNow;
	private String type;
	
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
	
	
	public String getPageNow() {
		return pageNow;
	}

	public void setPageNow(String pageNow) {
		this.pageNow = pageNow;
	}
	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String execute() throws Exception{
		UserDAL userDAl=new UserDAL();
		if(this.getUsername().equals("root")&&this.getPassword().equals("root")||this.getUsername().equals("abc")&&this.getPassword().equals("abc")){
			ServletActionContext.getRequest().getSession().setAttribute("name", this.getUsername());
			ServletActionContext.getRequest().getSession().setAttribute("pwd", this.getPassword());
			return "admin";
		}
		if(userDAl.loginCheck(this.getUsername(), this.getPassword())){
			ServletActionContext.getRequest().getSession().setAttribute("name", this.getUsername());
			ServletActionContext.getRequest().getSession().setAttribute("pwd", this.getPassword());
			return "user";
		}
		return "user";
	}
}
