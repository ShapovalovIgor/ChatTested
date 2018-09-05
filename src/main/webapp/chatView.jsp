<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
${nameChat}
<form action="<%=request.getContextPath()%>/removeUser" method="get">
    <button type="submit" name="Exit">Exit</button>
    <input type="text" readonly name="name" value="${name}"/>
</form>

<table border="1" cellpadding="1" cellspacing="1" style="width: 500px; height: 500px">
    <tbody>
    <tr>
        <td><c:forEach  var="message" items="${messageList}">
            <font size="5" color="<c:out value="${message.color}"/>" face="Arial"><c:out value="${message.name}"/>:<c:out value="${message.message}"/>  </font></br>
        </c:forEach>

        </td>
        <td><select name="users" size="20">
            <c:forEach var="user" items="${userList}" >
                <option value=<c:out value="${user.name}"/>>
                    <font size="5" color="<c:out value="${user.color}"/>" face="Arial">
                        <c:out value="${user.name}"/>
                    </font>
                </option>
            </c:forEach>
        </select></td>
    </tr>
    <tr><form action="<%=request.getContextPath()%>/sendMessage" method="get">
        <input type="hidden" name="userName" value="${name}"/>
        <input type="hidden" name="userColor" value="${color}"/>
        <td><textarea cols="1" name="message" rows="3" style="margin: 0px; width: 441px; height: 44px;"></textarea></td>
        <td><button type="submit" class="btn btn-default" name="send">Send</button>
        <input type="button" value="Refresh" onClick="window.location.reload()"></td>
    </form></tr>
    </tbody>
</table>
</body>
</html>