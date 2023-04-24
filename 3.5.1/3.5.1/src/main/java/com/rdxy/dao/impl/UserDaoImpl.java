package com.rdxy.dao.impl;

import com.rdxy.dao.UserDao;
import com.rdxy.entity.User;
import com.rdxy.utils.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {


    Connection connection=null;
    PreparedStatement ps=null;

    ResultSet rs=null;
    @Override
    public User getById(User user) {
        try {
            connection=DButil.getConnection();


            String sql="select * from user where id="+user.getId();

            if(user.getName()!=null&&user.getName()!=""){
                sql="select * from user where id="+user.getName();
            }

            System.out.println(sql);

            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                User u=new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                System.out.println("u="+u.toString());
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.closeAll(connection,ps,rs);
        }

        return null;
    }

    @Override
    public List<User> getAll(String msg) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<User> users=new ArrayList<>();

        try {
            connection=DButil.getConnection();
            String sql="select * from user ";
            if(msg!=null&&msg!=""){
                if(msg.matches("^[0-9]+$")){
                    sql="select * from user where id like '%"+msg+"%'";
                }else{
                    sql="select * from user where name like '%"+msg+"%'";
                }

            }

            System.out.println(sql);

            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                User u=new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                System.out.println("u="+u.toString());
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.closeAll(connection,ps,rs);
        }

        return users;

    }

    @Override
    public boolean deleteById(int id) {
        boolean flag=false;
        try {
            connection=DButil.getConnection();
            String sql="delete from user where id="+id;
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
    public boolean deleteByIds(int[] ids) {
        boolean flag=false;
        try {
            connection=DButil.getConnection();
            connection.setAutoCommit(false);
            String sql="delete from user where id=?";
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
            DButil.closeAll(connection,ps,rs);
        }
        return flag;
    }

    @Override
    public boolean insert(User user) {

        int flag=0;
        try {
            connection=DButil.getConnection();
            String sql="insert into user(name,password) values ('"+user.getName()+"','"+user.getPassword()+"')";
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
    public boolean update(User user) {
        boolean flag=false;
        try {
            connection=DButil.getConnection();
            String sql="update user set name= '"+user.getName()+"',password='"+user.getPassword()+"' where id="+user.getId();
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
    public Integer saveByIds(List<User> users) {

        Integer len=0;
        UserDao userDao=new UserDaoImpl();
        for (int i = 0; i < users.size(); i++) {
            boolean f = userDao.insert(users.get(i));
            len=f?len+1:len;

        }
        return len;
    }
}
