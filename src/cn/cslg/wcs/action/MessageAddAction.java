package cn.cslg.wcs.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import cn.cslg.wcs.dao.*;

public class MessageAddAction extends ActionSupport {
	private String content;
	private String type;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String execute() throws Exception{
		int n=0;
		ActionContext ctx=ActionContext.getContext();
		MessageDAL md=new MessageDAL();
		if(ServletActionContext.getRequest().getSession().getAttribute("name")!=null&&this.getContent()!=null&&!this.getContent().equals("")){
			n=md.addMB((String)ServletActionContext.getRequest().getSession().getAttribute("name"),this.getType(),ServletActionContext.getRequest().getLocalAddr() , this.getContent());
		}else if(this.getContent()!=null&&!this.getContent().equals(""))
		{
			n=md.addMB("无名游客",this.getType(),ServletActionContext.getRequest().getLocalAddr() , this.getContent());
		}
		if(n!=0)
			return "success";
		return "success";
	}
}
