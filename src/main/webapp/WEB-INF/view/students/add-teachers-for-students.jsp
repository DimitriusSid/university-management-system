<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add teachers for student</title>
</head>
<body>
    <h3>Add teachers for student ${student.studentPersonalInfo.name}</h3>

    <form:form method="post" action="addTeacherToStudent" modelAttribute="student">

        <c:forEach var="teacher" items="${teachers}">

            <input type="hidden" name="student_id" value="${student.id}">
            <input name="checkedTeachers" type="checkbox" value="${teacher.id}" id="${teacher.id}">
            <label for="${teacher.id}">${teacher.teacherPersonalInfo.name} of the ${teacher.faculty.facultyName} faculty</label>
            <br>

        </c:forEach>


        <input type="submit" value="Add selected teachers to student">

    </form:form>

</body>
</html>
