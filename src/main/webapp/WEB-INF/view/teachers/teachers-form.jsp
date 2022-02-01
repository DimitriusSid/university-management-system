<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/26/2022
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher</title>
</head>
<body>
    <form:form method="get" action="saveTeacher" modelAttribute="teacher">

        <form:hidden path="id"/>
        <p>
            Name <form:input path="name"/>
            <form:errors cssClass="errors" path="name"/>
        </p>
        <p>
            Subject <form:input path="subject"/>
            <form:errors path="subject"/>
        </p>
        <p>
            Salary <form:input path="salary"/>
            <form:errors path="salary"/>
        </p>
        <p>
            Phone number <form:input path="phoneNumber"/>
            <form:errors path="phoneNumber"/>
        </p>

        <label for="select">Faculty</label>
        <select id="select">
            <c:forEach var="faculty" items="${faculties}">
                <option value="${faculty.id}">${faculty.facultyName}</option>
            </c:forEach>
        </select>

        <script>
            function setFacId() {
                let facId = document.getElementById("select").value;
                document.getElementById("faculty_id").value = parseInt(facId);
            }
        </script>

        <input type="hidden" id="faculty_id" name="faculty_id">

        <input type="submit" value="Ok" onclick="setFacId()">

    </form:form>




</body>
</html>
