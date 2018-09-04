<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
${name}
<button type="button" class="btn btn-default" name="close" style="default" id="close_id">Close</button>
<table border="1" cellpadding="1" cellspacing="1" style="width: 500px; height: 500px">
    <tbody>
    <tr>
        <td><c:forEach var="user" items="${userList}" >
            <font size="5" color="${user.color}" face="Arial"><c:out value="${user.name}"/></font><br />
        </c:forEach>

        </td>
        <td><select name="users" size="20"><option value="val1">text1</option><option value="val2">text2</option></select></td>
    </tr>
    <tr>
        <td><textarea cols="1" name="sendMessages" rows="3" style="margin: 0px; width: 441px; height: 44px;"></textarea></td>
        <td><button type="button" class="btn btn-default" name="send" style="default" id="send_id">Send</button></td>
    </tr>
    </tbody>
</table>
</body>
</html>