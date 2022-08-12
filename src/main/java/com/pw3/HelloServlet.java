package com.pw3;

import java.io.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet{
    private String message;
    private Integer nContext = 0;

    //function call when the Servlet is start
    public void init() {
        ServletContext context = getServletContext();
        message = "Hello Servlet!!";
        nContext++;
        context.setAttribute("numberContext", nContext);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        HttpSession session = req.getSession();
        
        Integer numberContext, numberSession;

        if (context.getAttribute("nroContext") != null) 
            numberContext = (Integer) context.getAttribute("nroContext");
         else {
            numberContext = 1;
            context.setAttribute("nroContext", nContext);
        }

        if (session.getAttribute("nroSession") != null) {
            numberSession = (Integer) session.getAttribute("nroSession");
            numberSession++;
        } else {
            numberSession = 1;
        }

        session.setAttribute("nroSession", numberSession);

        resp.setContentType("text/html");
        
        PrintWriter output = resp.getWriter();

        output.println("<html><body>");
        output.println("<h1>" + message + "</h1>");
        output.println("<h2>Chamadas ao init: " + numberContext + "</h2>");
        output.println("<h2>Chamadas ao doGet: " + numberSession + "</h2>");
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
