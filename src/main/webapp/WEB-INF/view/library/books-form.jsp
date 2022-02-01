<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/26/2022
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
</head>
<body>

    <form:form method="get" action="saveBook" modelAttribute="book">

        <form:hidden path="id"/>

        <p>Author <form:input path="authorName"/></p>
        <p>Title <form:input path="title"/></p>
        <p>Publication date <form:input path="year"/></p>


        <input type="submit" value="Ok">

    </form:form>

</body>
</html>
