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

@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {

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

        boolean status = dao.updateEmployee(emp);

        if (status) {

            response.sendRedirect("ViewEmployeeServlet?msg=updated");

        } else {

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Update Failed</title>");

            out.println("<style>");
            out.println("body{font-family:Arial;background:linear-gradient(135deg,#ff9a9e,#fad0c4);display:flex;justify-content:center;align-items:center;height:100vh;margin:0;}");
            out.println(".card{background:white;padding:40px;border-radius:15px;box-shadow:0 5px 20px rgba(0,0,0,0.3);text-align:center;width:400px;}");
            out.println("a{display:inline-block;margin-top:20px;padding:10px 20px;background:#007BFF;color:white;text-decoration:none;border-radius:8px;}");
            out.println("a:hover{background:#0056b3;}");
            out.println("</style>");

            out.println("</head>");
            out.println("<body>");

            out.println("<div class='card'>");
            out.println("<h2 style='color:red;'> Employee Not Found!</h2>");
            out.println("<a href='updateemployee.html'>Try Again</a>");
            out.println("<br><br>");
            out.println("<a href='index.html'> Home</a>");
            out.println("</div>");

            out.println("</body>");
            out.println("</html>");
        }
    }
}