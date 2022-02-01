<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teachers of Loria University</title>
</head>
<body>
    <h3>Teachers of Loria University</h3>
    <table>
        <tr>
            <th>Name</th>
            <th>Faculty</th>
            <th>Subject</th>
            <th>Salary</th>
            <th>Phone number</th>
            <th>Students</th>
            <th>Operations</th>
        </tr>

        <c:forEach var="teacher" items="${teachers}">

            <c:url var="updateTeacherButton" value="/loria/teachers/updateTeacher">
                <c:param name="id" value="${teacher.id}"/>
            </c:url>

            <c:url var="fireTeacherButton" value="/loria/teachers/fireTeacher">
                <c:param name="id" value="${teacher.id}"/>
            </c:url>

            <c:url var="addStudentButton" value="/loria/teachers/addStudentsToTeacher">
                <c:param name="id" value="${teacher.id}"/>
            </c:url>

            <c:url var="getAllStudentsOfTeacherButton" value="/loria/teachers/getAllStudentsOfTeacher">
                <c:param name="id" value="${teacher.id}"/>
            </c:url>

            <c:url var="removeStudentsOfTeacherButton" value="/loria/teachers/removeStudentsOfTeacher">
                <c:param name="id" value="${teacher.id}"/>
            </c:url>

            <tr>
                <td>${teacher.name}</td>
                <td>${teacher.faculty.facultyName}</td>
                <td>${teacher.subject}</td>
                <td>${teacher.salary}</td>
                <td>${teacher.phoneNumber}</td>
                <td>
                    <input type="button" value="Add student" onclick="window.location.href = '${addStudentButton}'">
                    <input type="button" value="Student list" onclick="window.location.href = '${getAllStudentsOfTeacherButton}'">
                    <input type="button" value="Remove student" onclick="window.location.href = '${removeStudentsOfTeacherButton}'">
                </td>
                <td>
                    <input type="button" value="Update teacher's info" onclick="window.location.href = '${updateTeacherButton}'">
                    <input type="button" value="Fire teacher" onclick="window.location.href = '${fireTeacherButton}'">
                </td>
            </tr>
        </c:forEach>


    </table>

    <button type="button" value="Add new teacher" onclick="window.location.href = '/loria/teachers/addNewTeacher'">Add new teacher</button>

    <br><br>
    <button value="home" onclick="window.location.href = '/loria'">Home</button>

</body>
</html>
