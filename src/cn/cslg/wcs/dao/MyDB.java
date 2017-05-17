package cn.cslg.wcs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MyDB {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String NAME="root";
	private static final String PWD="123456";
	private static final String DATABASE="messageboard";
	private static final String URL="jdbc:mysql://localhost:3306/"+DATABASE+"?characterEncoding=Utf-8";
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	
	//默认构造方法
	public MyDB(){
	}
	
	//打开连接
	public void openConnection() throws SQLException{
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, NAME, PWD);
			stmt=conn.createStatement();
		}catch(ClassNotFoundException e){
			System.out.println("加载驱动失败");
		}catch (SQLException e) {
			System.out.println("打开连接失败");
		}
		
	}
	//断开连接
	public void closeConnection() throws SQLException{
		try{
			if(pstmt!=null){
				pstmt.close();;
				pstmt=null;
			}
			if(stmt!=null){
				stmt.close();
				stmt=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}
		}catch(SQLException e){
			System.out.println("断开连接失败");
		}
	}
	
	//构造pstmt
	public void openPrepareStatement(String sql){
		try{
			pstmt=conn.prepareStatement(sql);
		}catch(SQLException e){
			System.out.println("打开pstmt失败");
		}
	}
	
	//无参数查询
	public int executeUpdate(String sql) throws SQLException{
		int n=0;
		try{
			n=stmt.executeUpdate(sql);
		}catch(SQLException e){
			System.out.println("无参数更新失败");
		}
		return n;
	}
	
	public ResultSet executeQuery(String sql) throws SQLException{
		ResultSet rs=null;
		try{
			rs=stmt.executeQuery(sql);
		}catch(SQLException e){
			System.out.println("无参数查询失败");
		}
		return rs;
	}
	
	//有参数查询
	public int executeUpdate(Object... parameters) throws SQLException{
		int n=0;
		try{
			for(int i=0;i<parameters.length;i++){
				pstmt.setObject(i+1, parameters[i]);
			}
			n=pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("有参数更新失败");
		}
		return n;
	}
	
	public ResultSet executeQuery(Object... parameters) throws SQLException{
		ResultSet rs=null;
		try{
			for(int i=0;i<parameters.length;i++){
				pstmt.setObject(i+1, parameters[i]);
			}
			rs=pstmt.executeQuery();
		}catch(SQLException e){
			System.out.println("有参数查询失败");
		}
		return rs;
	}
}
