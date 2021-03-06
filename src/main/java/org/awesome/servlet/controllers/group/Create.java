package org.awesome.servlet.controllers.group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import org.awesome.servlet.models.Group;

@WebServlet("/group/create")
public class Create extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/group/create.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        try {
            Group group = new Group(name, description);

            group.save();

            response.sendRedirect(request.getContextPath() + "/groups");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}