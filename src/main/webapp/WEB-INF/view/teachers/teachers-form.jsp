<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher</title>
</head>
<body>
    <form:form method="get" action="saveTeacher" modelAttribute="teacher">

        <form:hidden path="id"/>
        <p>
            Name <form:input path="teacherPersonalInfo.name"/>
            <form:errors path="teacherPersonalInfo.name"/>
        </p>
        <p>
            Subject <form:input path="subject"/>
            <form:errors path="subject"/>
        </p>
            Salary <form:input path="teacherPersonalInfo.salary"/>
            <form:errors path="teacherPersonalInfo.salary"/>
        </p>
        <p>
            Phone number <form:input path="teacherPersonalInfo.phoneNumber"/>
            <form:errors path="teacherPersonalInfo.phoneNumber"/>
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
