<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
    <form:form action="saveStudent" method="get" modelAttribute="student">

        <form:hidden path="id"/>

        <p>
            Name <form:input path="name"/>
            <form:errors path="name"/>
        </p>
        <p>
            Course <form:input path="course"/>
            <form:errors path="course"/>
        </p>
        <p>
            Phone number <form:input path="phoneNumber"/>
            <form:errors path="phoneNumber"/>
        </p>
        <p>
            University email <form:input path="email"/>
            <form:errors path="email"/>
        </p>

        <label for="select">Faculty</label>
        <select id="select">
            <c:forEach var="fac" items="${faculties}">
                <option value="${fac.id}">${fac.facultyName}</option>
            </c:forEach>
        </select>

        <input type="hidden" id="faculty_id" name="faculty_id">

        <input type="submit" value="OK" onclick="setFacId()">

    </form:form>


    <script>
        function setFacId() {
            let facId = document.getElementById("select").value;
            document.getElementById("faculty_id").value = parseInt(facId);
        }
    </script>

</body>
</html>
