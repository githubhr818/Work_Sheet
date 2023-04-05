package com.school.software.oa.serlvet;

import com.school.software.oa.bean.Dept;
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
import java.util.ArrayList;
import java.util.List;

public class DeptServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getSession(false) == null){
            response.sendRedirect("/oa/Login.jsp");
        }
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<Dept> list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet reslutSet = null;
        try {
            connection = DBUtil.ConnectionDB(connection);
            String sql = "select dno,dname,dloc from dept";
            ps = connection.prepareStatement(sql);
            reslutSet = ps.executeQuery();

            while(reslutSet.next()){
                String dno = reslutSet.getString("dno");
                String dname = reslutSet.getString("dname");
                String dloc = reslutSet.getString("dloc");

                Dept dept = new Dept();
                dept.setDno(dno);
                dept.setDname(dname);
                dept.setDloc(dloc);

                list.add(dept);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.Close(connection,ps,reslutSet);
        }

        request.setAttribute("deptlist",list);
        request.getRequestDispatcher("/deptlist.jsp").forward(request,response);
    }
}
