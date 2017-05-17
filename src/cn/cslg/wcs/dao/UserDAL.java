package cn.cslg.wcs.dao;

import java.sql.*;
import cn.cslg.wcs.model.*;
import java.util.*;

public class UserDAL {
	private MyDB myDB=new MyDB();
	
	public UserDAL(){
	}
	
	public UserDAL(MyDB myDB){
		this.myDB=myDB;
	}
	
	//设置用户属性
	public void setAttr(ResultSet rs,User user) throws SQLException{
		user.setId(rs.getInt(1));
		user.setName(rs.getString(2));
		user.setPwd(rs.getString(3));
	}
	
	//获取用户总数
	public int getTotal()  throws SQLException{
		int total=0;
		ResultSet rs;
		try{
			myDB.openConnection();
			rs=myDB.executeQuery("select count(*)  from users");
			while(rs.next()){
				total=rs.getInt(1);
			}
			myDB.closeConnection();
		}catch(SQLException e){
			System.out.print("获取用户总数异常");
		}
		return total;
	}
	
	//获取所有用户
	public List<User> getAllUsers() throws SQLException{
		List<User> users=new ArrayList<User>();
		ResultSet rs=null;
		try{
			myDB.openConnection();
			rs=myDB.executeQuery("select * from users");
			while(rs.next()){
				User user=new User();
				this.setAttr(rs, user);
				users.add(user);
			}
			myDB.closeConnection();
		}catch(SQLException e){
			System.out.println("获取所有用户");
		}
		return users;
	}
	
	//得到某个用户
	public User getUser(String name) throws SQLException{
		User user=null;;
		ResultSet rs=null;
		try{
			myDB.openConnection();
			myDB.openPrepareStatement("select * from users where name=?");
			Object[] param={name};
			rs=myDB.executeQuery(param);
			while(rs.next()){
				user=new User();
				this.setAttr(rs, user);
			}
			myDB.closeConnection();
		}catch(SQLException e){
			System.out.println("得到某个用户异常");
		}
		return user;
	}
	
	//增加用户
	public int addUser(String name,String pwd) {
		int n=0;
		try{
		myDB.openConnection();
		myDB.openPrepareStatement("insert into users(name,pwd) values(?,?)");
		Object[] param={name,pwd};
		n=myDB.executeUpdate(param);
		myDB.closeConnection();
		}catch(SQLException e){
			
		}
		return n;
	}
	
	//删除用户
	public int  deleteUser(int id){
		int n=0;
		try{
		myDB.openConnection();
		myDB.openPrepareStatement("delete from users where id=?");
		Object[] param={id};
		n=myDB.executeUpdate(param);
		myDB.closeConnection();
		}catch(SQLException e){
			
		}
		return n;
	}
	
	//修改用户
	public int updateUser(String name,String pwd){
		int n=0;
		try{
		myDB.openConnection();
		myDB.openPrepareStatement("update users set pwd=? where name=?");
		n=myDB.executeUpdate(new Object[]{pwd,name});
		myDB.closeConnection();
		}catch(SQLException e){
			
		}
		return n;
	}
	
	//是否存在用户
	public boolean isUser(String name,String pwd) throws SQLException{
		boolean flag=false;
		ResultSet rs;
		try{
			myDB.openConnection();
			myDB.openPrepareStatement("select * from users where name=? and pwd=?");
			
			rs=myDB.executeQuery(new Object[]{name,pwd});
			while(rs.next()){
				flag=true;
			}
			myDB.closeConnection();
		}catch(SQLException e){
				System.out.println("yichang");
			}
			return flag;
	}
	//得到每页用户数
	public List<User> getPageUsers(int start,int count){
		ResultSet rs;
		List<User> users=new ArrayList<User>();
		
		try {
			myDB.openConnection();
			myDB.openPrepareStatement("select * from users where id limit ?,?");
			
			rs=myDB.executeQuery(new Object[]{start,count});
			while(rs.next()){
				User user=new User();
				this.setAttr(rs, user);
				users.add(user);
			}
			myDB.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;	
	}
	//登录检测
	public boolean loginCheck(String name,String pwd) throws SQLException{
		if(name!=null&&pwd!=null){
			if(this.isUser(name, pwd)){
				return true;
			}
		}
		return false;	
	}
	//找回密码
	public String findPwd(String name) throws SQLException{
		ResultSet rs;
		myDB.openConnection();
		myDB.openPrepareStatement("select * from users where name=?");
		rs=myDB.executeQuery(new Object[]{name});
		while(rs.next()){
			return rs.getString(3);
		}
		myDB.closeConnection();
		return "不存在用户";
	}
}
