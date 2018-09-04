package ru.shapovalov.chat.servlets;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQObjectMessage;
import ru.shapovalov.chat.Constants;
import ru.shapovalov.chat.dao.User;
import javax.jms.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/s")
public class ChatLogic extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setIntHeader("Refresh", 1);

        ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory(Constants.messageBrokerUrl);
        cf.setTrustAllPackages(true);;
        List<User> users = new ArrayList();

        User user = new User("test", "red");
//        users.add(user);
        Producer producer = new Producer();
        producer.produceUsers(user, cf);
        response.setContentType("text/html");


        Connection connectionFactory;
        try {
            connectionFactory = cf.createConnection();
            connectionFactory.start();
            Session queueSession = connectionFactory.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination= queueSession.createQueue(Constants.userQueueName);
            MessageConsumer consumer = queueSession.createConsumer(destination);
            Message message = consumer.receive();

                if (message instanceof ObjectMessage) {
                    ObjectMessage objectMessage = (ObjectMessage) message;
                    users.add((User) objectMessage.getObject());
                }
            connectionFactory.stop();
        } catch (JMSException e) {
            e.printStackTrace();
        }


        String name = "Chat";
        request.setAttribute("name", name);
        request.setAttribute("color", "red");

        request.setAttribute("userList",  users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
