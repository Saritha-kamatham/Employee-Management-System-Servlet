package com.emp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.emp.dao.EmployeeDAO;
import com.emp.model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewEmployeeServlet")
public class ViewEmployeeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String msg = request.getParameter("msg");

        EmployeeDAO dao = new EmployeeDAO();
        ArrayList<Employee> list = dao.viewEmployee();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Employee Details</title>");

        out.println("<style>");

        out.println("*{margin:0;padding:0;box-sizing:border-box;font-family:Arial,sans-serif;}");

        out.println("body{background:linear-gradient(135deg,#74ebd5,#ACB6E5);padding:40px;}");

        out.println("h1{text-align:center;color:#333;margin-bottom:20px;}");

        out.println(".message{width:90%;margin:20px auto;padding:15px;border-radius:8px;text-align:center;font-size:18px;font-weight:bold;}");

        out.println(".success{background:#d4edda;color:#155724;border:1px solid #c3e6cb;}");

        out.println(".updateMsg{background:#d1ecf1;color:#0c5460;border:1px solid #bee5eb;}");

        out.println(".deleteMsg{background:#f8d7da;color:#721c24;border:1px solid #f5c6cb;}");

        out.println("table{width:90%;margin:auto;border-collapse:collapse;background:white;box-shadow:0 5px 20px rgba(0,0,0,0.3);}");

        out.println("th{background:#007BFF;color:white;padding:15px;}");

        out.println("td{text-align:center;padding:12px;}");

        out.println("tr:nth-child(even){background:#f2f2f2;}");

        out.println("tr:hover{background:#d6ecff;}");

        out.println(".btn{padding:8px 15px;border-radius:5px;text-decoration:none;color:white;font-size:14px;}");

        out.println(".update{background:#28a745;}");

        out.println(".delete{background:#dc3545;}");

        out.println(".home{display:inline-block;margin-top:30px;padding:12px 25px;background:#007BFF;color:white;text-decoration:none;border-radius:8px;}");

        out.println(".home:hover{background:#0056b3;}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<h1> Employee Details</h1>");

        if(msg != null){

            if(msg.equals("added")){
                out.println("<div class='message success'>");
                out.println(" Employee Added Successfully");
                out.println("</div>");
            }

            if(msg.equals("updated")){
                out.println("<div class='message updateMsg'>");
                out.println(" Employee Updated Successfully");
                out.println("</div>");
            }

            if(msg.equals("deleted")){
                out.println("<div class='message deleteMsg'>");
                out.println(" Employee Deleted Successfully");
                out.println("</div>");
            }
        }

        out.println("<table>");

        out.println("<tr>");
        out.println("<th>Employee ID</th>");
        out.println("<th>Employee Name</th>");
        out.println("<th>Department</th>");
        out.println("<th>Salary</th>");
        out.println("<th>Actions</th>");
        out.println("</tr>");
        for (Employee emp : list) {

            out.println("<tr>");

            out.println("<td>" + emp.getEmp_id() + "</td>");
            out.println("<td>" + emp.getEmp_name() + "</td>");
            out.println("<td>" + emp.getDepartment() + "</td>");
            out.println("<td>₹ " + emp.getSalary() + "</td>");

            out.println("<td>");

            out.println("<a class='btn update' href='updateemployee.html'> Update</a>&nbsp;&nbsp;");

            out.println("<a class='btn delete' href='deleteemployee.html'> Delete</a>");

            out.println("</td>");

            out.println("</tr>");
        }

        out.println("</table>");

        out.println("<center>");

        out.println("<a class='home' href='index.html'> Back to Home</a>");

        out.println("</center>");

        out.println("</body>");
        out.println("</html>");
    }
}