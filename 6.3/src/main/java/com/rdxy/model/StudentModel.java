package com.rdxy.model;

import com.rdxy.dbutil.Dbconn;
import com.rdxy.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentModel {
	private static PreparedStatement ps;
	private static ResultSet rs;
	static Dbconn s=new Dbconn();

	public List search(){
		List studentlist = null;
		String sql = "select * from student";
	    try {
        	Connection conn=s.getConnection();
        	ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            studentlist = new ArrayList();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setSex(rs.getString("sex"));
                student.setGrade(rs.getString("grade"));
                student.setScore(rs.getFloat("score"));
                studentlist.add(student);
              }
            s.closeAll(conn,ps,rs);
	    } catch (Exception e) {
            e.printStackTrace();
        }
    	return studentlist;
	}
	public Student load(Integer id) {
		Student student = null;

		String sql = "select * from student  where student.id = ? ";
        try {
        	Connection conn=s.getConnection();
        	ps = conn.prepareStatement(sql);
        	ps.setInt(1, id.intValue());

            rs = ps.executeQuery();

            if(rs.next()){
            	student = new Student();
            	student.setId(rs.getInt("id"));
            	student.setName(rs.getString("name"));
            	student.setSex(rs.getString("sex"));
            	student.setAge(rs.getInt("age"));
            	student.setGrade(rs.getString("grade"));
            	student.setScore(rs.getFloat("score"));
             }
            s.closeAll(conn,ps,rs);
         } catch (Exception e) {
            e.printStackTrace();
        }
		return student;
	}
	public int update(int id,String name,String sex,int age,String grade,float score){
		int a=0;
		try {
			Connection conn=s.getConnection();
			String sql="update student set name=?,sex=?,age=?,grade=?,score=? where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(6, id);
			ps.setString(1, name);
			ps.setString(2, sex);
			ps.setInt(3,age);
			ps.setString(4,grade);
			ps.setFloat(5,score);
			a=ps.executeUpdate();
			s.closeAll(conn,ps,rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	public int insert(int id,String name,String sex,int age,String grade,float score){
		int a=0;
		try {
			Connection conn=s.getConnection();
			String sql="insert student values(?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, sex);
			ps.setInt(4,age);
			ps.setString(5,grade);
			ps.setFloat(6,score);
			a=ps.executeUpdate();
			s.closeAll(conn,ps,rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	public int delete(int id){
		int a=0;
		try {
			Connection conn=s.getConnection();
			String sql="delete from student where student.id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			a=ps.executeUpdate();
			s.closeAll(conn,ps,rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
}
