package cn.cslg.wcs.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.cslg.wcs.dao.UserDAL;

public class UserUpdateAction extends ActionSupport{
	private String newPwd;
	private String oldPwd;
	
	
	
	public String getNewPwd() {
		return newPwd;
	}



	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}



	public String getOldPwd() {
		return oldPwd;
	}



	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}



	public String execute() throws Exception{
		UserDAL userDAL=new UserDAL();
		if(ServletActionContext.getRequest().getSession().getAttribute("pwd").equals(this.getOldPwd()))
			userDAL.updateUser((String)ServletActionContext.getRequest().getSession().getAttribute("name"),this.getNewPwd());
		return "success";
	}
}
