package com.school.software.oa.serlvet;

import com.school.software.oa.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddDeptServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String dno = req.getParameter("dno");
        String dname = req.getParameter("dname");
        String dloc = req.getParameter("dloc");

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.ConnectionDB(connection);
            String sql = "insert into dept(dno,dname,dloc) values('"+dno+"','"+dname+"','"+dloc+"');";

            ps = connection.prepareStatement(sql);

            int i = ps.executeUpdate();
            if(i == 1) {
                req.getRequestDispatcher("/dept/list").forward(req,resp);
            }else{
                req.getRequestDispatcher("/error.html").forward(req,resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.Close(connection,ps,resultSet);
        }

    }
}
