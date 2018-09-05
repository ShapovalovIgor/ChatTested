package ru.shapovalov.chat.servlets;

import ru.shapovalov.chat.dao.User;
import ru.shapovalov.chat.singleton.Messages;
import ru.shapovalov.chat.singleton.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/chat")
public class ChatLogic extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String[]> param = request.getParameterMap();
        String name = param.get("userName")[0];
        String color = param.get("userColor")[0];
        Users users = Users.getInstance();
        boolean checkUser = true;
        for (User user :users.userList)
            if(user.getName().equals(name))
                checkUser = false;
        if(checkUser) {
            User user = new User(name, color);
            users.userList.add(user);
        }
        Messages messages = Messages.getInstance();
        String nameChat = "Chat";
        request.setAttribute("nameChat", nameChat);
        request.setAttribute("name", name);
        request.setAttribute("color", color);
        request.setAttribute("userList",  users.userList);
        request.setAttribute("messageList",  messages.messageList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/chatView.jsp");
        dispatcher.forward(request, response);
    }
}
