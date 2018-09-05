<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="chat" method="get" id="chat">
    <label>Select your favorite color:</label>
    <select name=userColor>
        <option value=black>black</option>
        <option value=blue>blue</option>
        <option value=red>red</option>
        <option value=green>green</option>
        <option value=yellow>yellow</option>

    </select></br>
    <label>Name:</label>
    <input maxlength="20" name="userName" size="20" type="text"></br>
    <button type=”submit” name=”btnSubmit” id=”btnSubmit”>Login</button>
</form>
</body>
</html>