package com.school.software.oa.util;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtil {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("resource/jdbc");

    private static final String driver = bundle.getString("driver");

    private static final String url = bundle.getString("url");

    private static final String user = bundle.getString("user");

    private static final String password = bundle.getString("password");

    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection ConnectionDB(Connection connection) throws SQLException{
        //注册驱动
        //获取资源
        connection = DriverManager.getConnection(url,user,password);
        //获取数据库操作对象
        //执行sql
        //处理查询结果集
        //释放资源
        return connection;
    }

    public static void Close(Connection connection, PreparedStatement preparedStatement,ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

