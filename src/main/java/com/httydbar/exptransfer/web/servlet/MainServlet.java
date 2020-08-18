package com.httydbar.exptransfer.web.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MainServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            response.getWriter().println("<h1>It works!</h1>");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
