package cn.pen.dao;

import java.util.ArrayList;

import cn.pen.pojo.Pen;
import cn.pen.utils.DBUtlis;

//数据访问的接口
public class PenDao {
	DBUtlis db=new DBUtlis();
	
	//查询当前最大的id
	public int penMaxId(){
		String sql="select max(penId) as penId from pen";
		return db.executeQueryUnique(sql);
	}
	
	//查询全部
	public ArrayList<Pen> selectPenAll(){
		String sql="select * from pen";
		return db.executeQueryPen(sql);
	}

	public int deletePenById(int id){
		String sql="delete from pen where penId=?";
		Object [] param={id};
		return db.executeUpdate(sql, param);
	}

	public ArrayList<Pen> selectPenById(int id){
		String sql="select * from pen where penId=?";
		Object [] param={id};
		return db.executeQueryPen(sql, param);
	}
	
	public ArrayList<Pen> selectPenByName(String penName){
		String sql="select * from pen where penName=?";
		Object [] param={penName};
		return db.executeQueryPen(sql, param);
	}
}
