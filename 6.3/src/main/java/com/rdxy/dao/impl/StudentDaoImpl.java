package com.rdxy.dao.impl;

import com.rdxy.dao.StudentDao;
import com.rdxy.dbutil.Dbconn;
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
    public Student getById(Student Student) {
        try {
            connection= Dbconn.getConnection();


            String sql="select * from student where id="+Student.getId();

            if(Student.getName()!=null&&Student.getName()!=""){
                sql="select * from student where id="+Student.getName();
            }

            System.out.println(sql);

            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Student u=new Student();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setSex(rs.getString("sex"));
                System.out.println("u="+u.toString());
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Dbconn.closeAll(connection,ps,rs);
        }

        return null;
    }

    @Override
    public List<Student> getAll(String msg) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Student> Students=new ArrayList<>();

        try {
            connection=Dbconn.getConnection();
            String sql="select * from student ";
            if(msg!=null&&msg!=""){
                if(msg.matches("^[0-9]+$")){
                    sql="select * from student where id like '%"+msg+"%'";
                }else{
                    sql="select * from student where name like '%"+msg+"%'";
                }

            }

            System.out.println(sql);

            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Student u=new Student();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setSex(rs.getString("sex"));
//                System.out.println("u="+u.toString());
                Students.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Dbconn.closeAll(connection,ps,rs);
        }

        return Students;

    }

    @Override
    public boolean deleteById(int id) {
        int flag=0;
        try {
            connection=Dbconn.getConnection();
            String sql="delete from student where id="+id;
            System.out.println(sql);

            ps=connection.prepareStatement(sql);
            flag = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Dbconn.closeAll(connection,ps,rs);
        }

        return flag>0;
    }

    @Override
    public boolean deleteByIds(int[] ids) {
        boolean flag=false;
        try {
            connection=Dbconn.getConnection();
            connection.setAutoCommit(false);
            String sql="delete from student where id=?";
            ps=connection.prepareStatement(sql);

            for (int id : ids) {
                ps.setString(1, String.valueOf(id));
                ps.addBatch();
            }
            System.out.println(sql);


            int[] ints = ps.executeBatch();
            System.out.println(ints);
            flag=ints.length>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Dbconn.closeAll(connection,ps,rs);
        }
        return flag;
    }

    @Override
    public boolean insert(Student Student) {

        int flag=0;
        try {
            connection=Dbconn.getConnection();
            String sql="insert into student(name,Sex) values ('"+Student.getName()+"','"+Student.getSex()+"')";
            System.out.println(sql);

            ps=connection.prepareStatement(sql);
            flag = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Dbconn.closeAll(connection,ps,rs);
        }

        return flag>0;
    }

    @Override
    public boolean update(Student Student) {
        boolean flag=false;
        try {
            connection=Dbconn.getConnection();
            String sql="update student set name= '"+Student.getName()+"',Sex='"+Student.getSex()+"' where id="+Student.getId();
            System.out.println(sql);

            ps=connection.prepareStatement(sql);
            flag = ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Dbconn.closeAll(connection,ps,rs);
        }

        return flag;
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

    @Override
    public int deletes() {
        int sum=0;
        try {
            connection=Dbconn.getConnection();
            String sql="delete from student where id!=1001;";
            System.out.println(sql);
            ps=connection.prepareStatement(sql);
            sum=ps.executeUpdate();
            ps=connection.prepareStatement("ALTER TABLE student AUTO_INCREMENT = 1002;");
            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Dbconn.closeAll(connection,ps,rs);
        }
        return sum;
    }

    @Override
    public Student find_name_id(String name) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            connection=Dbconn.getConnection();
            String sql="select * from student where name='"+name+"'";


            System.out.println(sql);

            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Student u=new Student();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setSex(rs.getString("sex"));
                System.out.println("u="+u.toString());
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Dbconn.closeAll(connection,ps,rs);
        }

        return null;
    }


}
