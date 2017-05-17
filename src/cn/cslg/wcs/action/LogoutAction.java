package cn.cslg.wcs.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport{
	public String execute() throws Exception{
		ServletActionContext.getRequest().getSession().invalidate();
		return "success";
	}
}
