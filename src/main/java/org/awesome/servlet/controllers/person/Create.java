package org.awesome.servlet.controllers.person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.awesome.servlet.models.Person;

@WebServlet("/person/create")
public class Create extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/person/create.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        try {
            Person person = new Person(firstName, lastName);

            person.save();

            response.sendRedirect(request.getContextPath() + "/persons");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}