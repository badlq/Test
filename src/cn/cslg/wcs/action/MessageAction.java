package cn.cslg.wcs.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import cn.cslg.wcs.dao.*;
import cn.cslg.wcs.model.Message;

public class MessageAction extends ActionSupport{
	private String pageNow;
	private String type;
	private String username;
	private String passeord;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasseord() {
		return passeord;
	}
	public void setPasseord(String passeord) {
		this.passeord = passeord;
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
		MessageDAL md=new MessageDAL();
		int size=3;
		int total=md.getTotals(this.getType());
		int row=(total+size-1)/size;
		List<Message> mbs=md.getPageMB(this.getType(), Integer.parseInt(this.getPageNow())-1, size);
		ServletActionContext.getRequest().getSession().setAttribute("mbs", mbs);
		ServletActionContext.getRequest().getSession().setAttribute("row",row);
		if(ServletActionContext.getRequest().getSession().getAttribute("admin")!=null&&ServletActionContext.getRequest().getSession().getAttribute("admin").equals("admin"))
			return "home2";
		return "home1";
	}
}
