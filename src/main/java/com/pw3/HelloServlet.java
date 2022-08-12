package com.pw3;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet{
    private String message;

    //function call when the Servlet is start
    public void init() {
        message = "Hello Servlet!!";
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        
        PrintWriter output = resp.getWriter();

        output.println("<html><body>");
        output.println("<h1>" + message + "</h1>");
        output.println("<a href='.'>Voltar</a>");
        output.println("</body></html>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String name = req.getParameter("name");
        
        PrintWriter output = resp.getWriter();

        output.println("<html><body>");
        output.println("<h1>Bem vindo " + name + "</h1>");
        output.println("<a href='.'>Voltar</a>");
        output.println("</body></html>");
    }
    
    @Override
    public void destroy() {
        super.destroy();
    }
}
