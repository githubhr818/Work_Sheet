package com.school.software.oa.serlvet;

import com.school.software.oa.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/dept/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("userpwd");

        boolean flag = false;

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.ConnectionDB(connection);
            String sql = "select loginName,loginPassword from userlogin where loginName = ? and loginPassword = ?";

            ps = connection.prepareStatement(sql);

            ps.setString(1,username);
            ps.setString(2,password);

            rs = ps.executeQuery();

            while(rs.next()){
                flag = true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.Close(connection,ps,rs);
        }

        if(flag){
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
            req.getRequestDispatcher("/dept/list").forward(req,resp);
        }else{
            resp.sendRedirect("/oa/Login.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
