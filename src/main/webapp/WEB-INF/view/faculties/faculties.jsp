<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Faculties of Loria University</title>

</head>
<body>
    <h3>Faculties of Loria University</h3>
    <table>
        <tr>
            <th>Faculty name</th>
            <th>Faculty dean</th>
            <th>Teachers</th>
            <th>Students</th>
        </tr>
        <c:forEach var="faculty" items="${faculties}">

            <c:url var="showTeachersOnFacultyButton" value="/loria/faculties/teachersOnFaculty">
                <c:param name="faculty_id" value="${faculty.id}"/>
            </c:url>

            <c:url var="showStudentsOnFacultyButton" value="/loria/faculties/studentsOnFaculty">
                <c:param name="faculty_id" value="${faculty.id}"/>
            </c:url>

            <tr>
                <td>${faculty.facultyName}</td>
                <td>${faculty.deanName}</td>
                <td>
                    <input type="button" value="Teachers on faculty" onclick="window.location.href = '${showTeachersOnFacultyButton}'">
                </td>
                <td>
                    <input type="button" value="Students on faculty" onclick="window.location.href = '${showStudentsOnFacultyButton}'">
                </td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <button value="home" onclick="window.location.href = '/loria'">Home</button>

</body>
</html>
