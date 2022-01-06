<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Students of Loria University</title>
</head>
<body>
    <h3>All Students of Loria University</h3>
    <table>
        <tr>
            <th>Name</th>
            <th>Course</th>
            <th>Faculty</th>
            <th>Operations</th>
        </tr>

        <c:forEach var="student" items="${students}">

            <c:url var="expelStudentButton" value="/loria/students/expelStudent">
                <c:param name="id" value="${student.id}"/>
            </c:url>

            <c:url var="updateStudentButton" value="/loria/students/updateStudent">
                <c:param name="id" value="${student.id}"/>
            </c:url>

            <tr>
                <td>${student.name}</td>
                <td>${student.course}</td>
                <td>${student.faculty.facultyName}</td>

                <td>
                    <input type="button" value="Expel student" onclick="window.location.href = '${expelStudentButton}'">
                    <input type="button" value="Update student's info" onclick="window.location.href = '${updateStudentButton}'">
                </td>

            </tr>
        </c:forEach>
    </table>

    <button type="button" value="Add new student" onclick="window.location.href = 'students/addNewStudent'">Add new student</button>
</body>
</html>
