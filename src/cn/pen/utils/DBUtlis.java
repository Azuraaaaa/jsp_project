package cn.pen.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.pen.pojo.User;
import cn.pen.pojo.Pen;

public class DBUtlis {
	public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//jdbc:mysql://localhost:3306/webproject?useUnicode=true&characterEncoding=utf-8
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	//公共的关闭
	public void closeAll(Connection conn,PreparedStatement ps,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//公共的增删改的方法
	public int executeUpdate(String sql,Object...param){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			//获得连接
			conn=getConnection();
			//传sql
			ps = conn.prepareStatement(sql);
			
			//参数的注入
			for(int i=0;i<param.length;i++){
				//为占位符拼接参数  占位从1开始
				ps.setObject((i+1),param[i]);
			}
			//执行sql
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接
			closeAll(conn, ps, null);
		}
		return 0;
	}
	
	
	//查询
	public ArrayList<User> executeQuery(String sql,Object...param){
		ArrayList<User> users=new ArrayList<User>();
		//ArrayList<Pen> pens=new ArrayList<Pen>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			ps = conn.prepareStatement(sql);
			for(int i=0;i<param.length;i++){
				ps.setObject((i+1),param[i]);
			}
			//执行sql
			rs=ps.executeQuery();
			while(rs.next()){
				User user=new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7));
				users.add(user);
				//Pen pen=new Pen(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				//pens.add(pen);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接
			closeAll(conn, ps, rs);
		}
		return users;
	}
	
	public ArrayList<Pen> executeQueryPen(String sql,Object...param){
		ArrayList<Pen> pens=new ArrayList<Pen>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			ps = conn.prepareStatement(sql);
			for(int i=0;i<param.length;i++){
				ps.setObject((i+1),param[i]);
			}
			//执行sql
			rs=ps.executeQuery();
			while(rs.next()){
				Pen pen=new Pen(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				pens.add(pen);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接
			closeAll(conn, ps, rs);
		}
		return pens;
	}
	
	//查询单行单列的
	public int executeQueryUnique(String sql){		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//获得连接
			conn=getConnection();
			//传sql
			ps = conn.prepareStatement(sql);
			//执行sql
			rs=ps.executeQuery();
			//遍历获取查询的结果集
			if(rs.next()){
				return rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接
			closeAll(conn, ps, rs);
		}
		return 0;
	}
}
