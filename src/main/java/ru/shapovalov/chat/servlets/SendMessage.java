package ru.shapovalov.chat.servlets;

import ru.shapovalov.chat.dao.Message;
import ru.shapovalov.chat.singleton.Messages;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/sendMessage")
public class SendMessage extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String[]> param = request.getParameterMap();
        String name = param.get("userName")[0];
        String color = param.get("userColor")[0];
        String messageStr = param.get("message")[0];
        Message message = new Message(name, color, messageStr);
        request.setAttribute("name", name);
        request.setAttribute("color", color);
        request.setAttribute("message", message);
        Messages messages = Messages.getInstance();
        messages.messageList.add(message);
        request.getRequestURI();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/goToLogic.jsp");
        dispatcher.forward(request, response);
    }
}
