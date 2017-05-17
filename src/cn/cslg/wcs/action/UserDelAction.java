package cn.cslg.wcs.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.cslg.wcs.dao.UserDAL;

public class UserDelAction  extends ActionSupport{
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String execute() throws Exception{
		UserDAL userDAL=new UserDAL();
		userDAL.deleteUser(Integer.parseInt(this.getId()));
		return "success";
	}
}
