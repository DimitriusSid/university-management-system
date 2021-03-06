<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove teachers of student ${student.studentPersonalInfo.name}</title>
</head>
<body>

    <form:form method="post" action="removeTeachersOfStudent" modelAttribute="teachers">

      <c:forEach var="teacher" items="${teachers}">

        <input type="hidden" name="student_id" value="${student.id}">
        <input name="checkedTeachers" type="checkbox" id="${teacher.id}" value="${teacher.id}">
        <label for="${teacher.id}">${teacher.teacherPersonalInfo.name} of the ${teacher.faculty.facultyName} faculty</label>
        <br>

      </c:forEach>

      <input type="submit" value="Remove selected teachers">

    </form:form>

</body>
</html>
