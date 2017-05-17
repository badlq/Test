package cn.cslg.wcs.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.cslg.wcs.dao.UserDAL;
import cn.cslg.wcs.model.*;
import java.util.*;

import org.apache.struts2.ServletActionContext;

public class UserAction extends ActionSupport{
	private String username;
	private String password;
	private String pageNow;
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
	public String execute() throws Exception{
		List<User> users=new ArrayList<User>();
		UserDAL userDAL=new UserDAL();
		int total=userDAL.getTotal();
		int size=3;
		int row=(total+size-1)/size;
		users=userDAL.getPageUsers(Integer.parseInt(this.getPageNow()), size);
		ServletActionContext.getRequest().getSession().setAttribute("users", users);
		ServletActionContext.getRequest().getSession().setAttribute("row",row);
		return "success";
	}
	
}
