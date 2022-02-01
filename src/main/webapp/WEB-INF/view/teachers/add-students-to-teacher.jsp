<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add students to teacher</title>
</head>
<body>
    <h3>Add students to teacher ${teacher.name} of the ${teacher.faculty.facultyName} faculty</h3>

    <form:form method="post" action="addStudentsToTeacher" modelAttribute="students">

        <c:forEach var="student" items="${students}">
            <input type="hidden" name="teacher_id" value="${teacher.id}">
            <input type="checkbox" name="checkedStudents" id="${student.id}" value="${student.id}">
            <label for="${student.id}">${student.name} of the ${student.faculty.facultyName} faculty</label>
            <br>
        </c:forEach>

        <input type="submit" value="Add selected students to teacher">
    </form:form>

</body>
</html>
