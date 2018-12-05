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
	
	
	//�����Ĺر�
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
	
	//��������ɾ�ĵķ���
	public int executeUpdate(String sql,Object...param){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			//�������
			conn=getConnection();
			//��sql
			ps = conn.prepareStatement(sql);
			
			//������ע��
			for(int i=0;i<param.length;i++){
				//Ϊռλ��ƴ�Ӳ���  ռλ��1��ʼ
				ps.setObject((i+1),param[i]);
			}
			//ִ��sql
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�ر�����
			closeAll(conn, ps, null);
		}
		return 0;
	}
	
	
	//��ѯ
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
			//ִ��sql
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
			//�ر�����
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
			//ִ��sql
			rs=ps.executeQuery();
			while(rs.next()){
				Pen pen=new Pen(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				pens.add(pen);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�ر�����
			closeAll(conn, ps, rs);
		}
		return pens;
	}
	
	//��ѯ���е��е�
	public int executeQueryUnique(String sql){		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//�������
			conn=getConnection();
			//��sql
			ps = conn.prepareStatement(sql);
			//ִ��sql
			rs=ps.executeQuery();
			//������ȡ��ѯ�Ľ����
			if(rs.next()){
				return rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�ر�����
			closeAll(conn, ps, rs);
		}
		return 0;
	}
}
