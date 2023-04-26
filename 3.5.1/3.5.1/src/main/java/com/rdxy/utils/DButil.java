package com.rdxy.utils;

import java.sql.*;

public class DButil {
    private static Connection connection=null;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static  Connection getConnection() throws SQLException {

        return connection;
    }

    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                if(statement!=null){
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }finally{
                        /*if(connection!=null){
                            try {
                                connection.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }*/
                    }
                }
            }
        }
    }


}
