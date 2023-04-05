package com.school.software.oa.serlvet;

import com.school.software.oa.bean.Dept;
import com.school.software.oa.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.school.software.oa.util.DBUtil.ConnectionDB;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String dno = req.getParameter("dno");
        Dept dept = new Dept();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = ConnectionDB(connection);
            String sql = "delete from dept where dno = '"+dno+"'";
            ps = connection.prepareStatement(sql);

            int i = ps.executeUpdate();
            if( i == 1){
                req.getRequestDispatcher("/dept/list").forward(req,resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.Close(connection,ps,rs);
        }
    }
}
