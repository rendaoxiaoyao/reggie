package com.rdxy.dao.impl;

import com.rdxy.dao.StudentDao;
import com.rdxy.utils.DButil;
import com.rdxy.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {


    Connection connection=null;
    PreparedStatement ps=null;

    ResultSet rs=null;
    @Override
    public boolean insert(Student Student) {

        int flag=0;
        try {
            connection=DButil.getConnection();
            String sql=null;//String sql="insert into student(name,Sex) values ('"+Student.getName()+"','"+Student.getSex()+"')";
            System.out.println(sql);

            ps=connection.prepareStatement(sql);
            flag = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.closeAll(connection,ps,rs);
        }

        return flag>0;
    }

    @Override
    public boolean delete(int id) {
        int flag=0;
        try {
            connection=DButil.getConnection();
            String sql=null;//String sql="delete from student where id="+id;
            System.out.println(sql);

            ps=connection.prepareStatement(sql);
            flag = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.closeAll(connection,ps,rs);
        }

        return flag>0;
    }

    @Override
    public boolean update(Student student) {
        boolean flag=false;
        try {
            connection=DButil.getConnection();
            String sql=null;//String sql="update student set name= '"+student.getName()+"',password='"+user.getPassword()+"' where id="+user.getId();
            System.out.println(sql);

            ps=connection.prepareStatement(sql);
            flag = ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.closeAll(connection,ps,rs);
        }

        return flag;
    }


    @Override
    public List<Student> getAll(String msg) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Student> list=new ArrayList<>();

        try {
            connection=DButil.getConnection();
            String sql=null;//String sql="select * from student ";
            if(msg!=null&&msg!=""){
                if(msg.matches("^[0-9]+$")){
                    //sql="select * from student where id like '%"+msg+"%'";
                }else{
                    //sql="select * from student where name like '%"+msg+"%'";
                }

            }

            System.out.println(sql);

            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setSex(rs.getString("sex"));
                student.setGrade(rs.getString("grade"));
                student.setScore(rs.getFloat("score"));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.closeAll(connection,ps,rs);
        }

        return list;

    }






    @Override
    public Student getOne(String id) {
        try {
            connection= DButil.getConnection();


            String sql=null;//String sql="select * from student where id="+Student.getId();

//            if(Student.getName()!=null&&Student.getName()!=""){
//                sql="select * from student where id="+Student.getName();
//            }

            System.out.println(sql);

            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Student student=new Student();
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSex(rs.getString("sex"));
                student.setAge(rs.getInt("age"));
                student.setGrade(rs.getString("grade"));
                student.setScore(rs.getFloat("score"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.closeAll(connection,ps,rs);
        }

        return null;
    }



    @Override
    public Integer saveByIds(List<Student> Students) {

        Integer len=0;
        StudentDao StudentDao=new StudentDaoImpl();
        for (int i = 0; i < Students.size(); i++) {
            boolean f = StudentDao.insert(Students.get(i));
            len=f?len+1:len;

        }
        return len;
    }


}
