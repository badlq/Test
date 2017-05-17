package cn.cslg.wcs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import cn.cslg.wcs.model.*;


public class MessageDAL {
	private MyDB myDB=new MyDB();
	
	public MessageDAL(){
	}
	
	public MessageDAL(MyDB myDB){
		this.myDB=myDB;
	}
	
	//设置属性
	public void setAttr(ResultSet rs, Message mb) throws SQLException{
		mb.setId(rs.getInt(1));
		mb.setName(rs.getString(2));
		mb.setType(rs.getString(3));
		mb.setIp(rs.getString(4));
		mb.setContent(rs.getString(5));
	}
	//获得对应留言回复总数
	public int getTotals(String type){
		int total=0;
		ResultSet rs=null;
		try {
			myDB.openConnection();
			myDB.openPrepareStatement("select count(*) from message where type=?");
			rs=myDB.executeQuery(new Object[]{type});
			while(rs.next()){
				total=rs.getInt(1);
			}
			myDB.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	
	//保存所有回复
	public List<Message> getAllMB(){
		List<Message> mbs=new ArrayList<Message>();
		ResultSet rs=null;
		try {
			myDB.openConnection();
			rs=myDB.executeQuery("select * from message");
			while(rs.next()){
				Message mb=new Message();
				this.setAttr(rs, mb);
				mbs.add(mb);
			}
			myDB.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mbs;
	}		
		//获得对应ip的回复
		public Message getMB(String ip) throws SQLException{
			Message mb=null;
			ResultSet rs=null;
			myDB.openConnection();
			myDB.openPrepareStatement("select * from message where ip=?");
			rs=myDB.executeQuery(new Object[]{ip});
			while(rs.next()){
				mb=new Message();
				this.setAttr(rs, mb);
			}
			myDB.closeConnection();
			return mb;
		}
		//增加一个留言回复
		public int addMB(String name,String type ,String ip,String content){
			int n=0;
			try{
				myDB.openConnection();
				myDB.openPrepareStatement("insert into message(name,type,ip,content) values(?,?,?,?)");
				n=myDB.executeUpdate(new Object[]{name,type,ip,content});
				myDB.closeConnection();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return n;
		}
		
		//删除对应ip的回复
		public int delMB(int id){
			int  n=0;
			try{
				myDB.openConnection();
				myDB.openPrepareStatement("delete from message where id=?");
				n=myDB.executeUpdate(new Object[]{id});
				myDB.closeConnection();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return n;
		}
		
		//修改回复
		
		public int updateMB(int id,String name,String type,String ip,String content){
			int n=0;
			try{
				myDB.openConnection();
				myDB.openPrepareStatement("update message set name=?,type=?,,ip=?,content=? where id=?");
				n=myDB.executeUpdate(new Object[]{name,type,ip,content,id});
				myDB.closeConnection();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return n;
		}
		
		//获取对应每页显示的回复条数
		public List<Message> getPageMB(String type,int start,int num) {
			List<Message> mbs=new ArrayList<Message>();
			ResultSet rs=null;
			try {
				myDB.openConnection();
				myDB.openPrepareStatement("select* from message where type=? order by id desc limit ?,?");
				rs=myDB.executeQuery(new Object[]{type,start,num});
				while(rs.next()){
					Message mb=new Message();
					this.setAttr(rs, mb);
					mbs.add(mb);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					myDB.closeConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return mbs;
		}
		
		
}
