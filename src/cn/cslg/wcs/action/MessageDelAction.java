package cn.cslg.wcs.action;

import com.opensymphony.xwork2.ActionSupport;
import cn.cslg.wcs.dao.*;

public class MessageDelAction extends ActionSupport{
	private String pagdNow;
	private String type;
	private String id;
	
	public String getPagdNow() {
		return pagdNow;
	}

	public void setPagdNow(String pagdNow) {
		this.pagdNow = pagdNow;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String execute() throws Exception{
		MessageDAL md=new MessageDAL();
		md.delMB(Integer.parseInt(this.getId()));
		return "success";
	}
}
