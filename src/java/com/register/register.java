/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.register;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

public class register extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String name=request.getParameter("firstName");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        
    
          try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             String url="jdbc:mysql://localhost:3306/jdbc";
            String pass="root";
            String Uname="root";
            Connection con=DriverManager.getConnection(url,Uname,pass);
            String q="insert into servlet(name,email,password) values(?,?,?)";
             PreparedStatement ptstmp= con.prepareStatement(q);
             ptstmp.setString(1, name);
             ptstmp.setString(2, email);
             ptstmp.setString(3, password);
             out.println("<h3>"+name+"</h3>");
             out.println("<h3>"+email+"</h3>");
             out.println("<h3>"+password+"</h3>");
             
             ptstmp.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
