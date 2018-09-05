package ru.shapovalov.chat.servlets;

import ru.shapovalov.chat.dao.User;
import ru.shapovalov.chat.singleton.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

@WebServlet("/removeUser")
public class RemoveUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        request.getRequestURI();
        Users users = Users.getInstance();
        for (Iterator<User> iter = users.userList.iterator(); iter.hasNext(); ) {
            User user = iter.next();
            if (user.getName().equals(name))
                iter.remove();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.include(request, response);
    }
}
