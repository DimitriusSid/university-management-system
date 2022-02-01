<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/26/2022
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Loria University</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>


    <h2 style="text-align: center">Welcome to Loria University</h2>
    <br>
    <button class="welcome_button" value="loria_uni_faculties" onclick="window.location.href = '/loria/faculties'">Faculties of Loria University</button>
    <br><br>
    <button value="loria_uni_students" onclick="window.location.href = '/loria/students'">Students of Loria University</button>
    <br><br>
    <button value="loria_uni_teachers" onclick="window.location.href = '/loria/teachers'">Teachers of Loria University</button>
    <br><br>
    <button value="loria_uni_library" onclick="window.location.href = '/loria/library'">Library of Loria University</button>

</body>
</html>
