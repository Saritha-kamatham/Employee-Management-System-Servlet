package com.emp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.emp.dao.EmployeeDAO;
import com.emp.model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("empid"));
        String name = request.getParameter("empname");
        String department = request.getParameter("department");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Employee emp = new Employee(id, name, department, salary);

        EmployeeDAO dao = new EmployeeDAO();

        boolean status = dao.addEmployee(emp);

        if (status) {

            // Redirect to View Employee page with success message
            response.sendRedirect("ViewEmployeeServlet?msg=added");

        } else {

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Add Employee</title>");

            out.println("<style>");

            out.println("body{");
            out.println("font-family:Arial,Helvetica,sans-serif;");
            out.println("background:linear-gradient(135deg,#ff9a9e,#fad0c4);");
            out.println("display:flex;");
            out.println("justify-content:center;");
            out.println("align-items:center;");
            out.println("height:100vh;");
            out.println("margin:0;");
            out.println("}");

            out.println(".card{");
            out.println("background:white;");
            out.println("padding:40px;");
            out.println("width:420px;");
            out.println("border-radius:15px;");
            out.println("box-shadow:0 8px 20px rgba(0,0,0,0.3);");
            out.println("text-align:center;");
            out.println("}");

            out.println("h2{");
            out.println("color:red;");
            out.println("margin-bottom:15px;");
            out.println("}");

            out.println("p{");
            out.println("font-size:16px;");
            out.println("color:#555;");
            out.println("}");

            out.println("a{");
            out.println("display:inline-block;");
            out.println("margin-top:20px;");
            out.println("padding:12px 25px;");
            out.println("background:#007BFF;");
            out.println("color:white;");
            out.println("text-decoration:none;");
            out.println("border-radius:8px;");
            out.println("}");

            out.println("a:hover{");
            out.println("background:#0056b3;");
            out.println("}");

            out.println("</style>");

            out.println("</head>");

            out.println("<body>");

            out.println("<div class='card'>");

            out.println("<h2> Failed to Add Employee</h2>");

            out.println("<p>Employee ID may already exist.</p>");

            out.println("<a href='addemployee.html'>Try Again</a>");

            out.println("<br><br>");

            out.println("<a href='index.html'>Home</a>");

            out.println("</div>");

            out.println("</body>");
            out.println("</html>");
        }
    }
}