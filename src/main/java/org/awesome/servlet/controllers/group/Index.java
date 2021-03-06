package org.awesome.servlet.controllers.group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.awesome.servlet.Models;
import org.awesome.servlet.models.Group;

@WebServlet("/groups")
public class Index extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Models groups = new Group().findAll();

            request.setAttribute("groups", groups);

            request.getRequestDispatcher("/WEB-INF/group/index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}