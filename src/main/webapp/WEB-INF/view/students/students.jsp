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
            <th>Phone number</th>
            <th>Email</th>
            <th>Faculty</th>
            <th>Teachers</th>
            <th>Books</th>
            <th>Operations</th>
        </tr>

        <c:forEach var="student" items="${students}">

            <c:url var="expelStudentButton" value="/loria/students/expelStudent">
                <c:param name="id" value="${student.id}"/>
            </c:url>

            <c:url var="updateStudentButton" value="/loria/students/updateStudent">
                <c:param name="id" value="${student.id}"/>
            </c:url>

            <c:url var="addTeacherToStudentButton" value="/loria/students/addTeacherToStudent">
                <c:param name="id" value="${student.id}"/>
            </c:url>

            <c:url var="getAllTeachersOfStudentButton" value="/loria/students/getAllTeachersOfStudent">
                <c:param name="id" value="${student.id}"/>
            </c:url>

            <c:url var="removeTeachersOfStudentButton" value="/loria/students/removeTeachersOfStudent">
                <c:param name="id" value="${student.id}"/>
            </c:url>

            <c:url var="addBooksButton" value="/loria/students/addBooksToStudent">
                <c:param name="id" value="${student.id}"/>
            </c:url>

            <c:url var="getAllBooksButton" value="/loria/students/getAllBooksOfStudent">
                <c:param name="id" value="${student.id}"/>
            </c:url>

            <c:url var="returnBooksButton" value="/loria/students/returnBooksOfStudent">
                <c:param name="id" value="${student.id}"/>
            </c:url>

            <tr>
                <td>${student.name}</td>
                <td>${student.course}</td>
                <td>${student.phoneNumber}</td>
                <td>${student.email}</td>
                <td>${student.faculty.facultyName}</td>
                <td>
                    <input type="button" value="Add teachers" onclick="window.location.href = '${addTeacherToStudentButton}'">
                    <input type="button" value="Teachers" onclick="window.location.href = '${getAllTeachersOfStudentButton}'">
                    <input type="button" value="Remove teachers" onclick="window.location.href = '${removeTeachersOfStudentButton}'">
                </td>
                <td>
                    <input type="button" value="Add books" onclick="window.location.href = '${addBooksButton}'">
                    <input type="button" value="Books" onclick="window.location.href = '${getAllBooksButton}'">
                    <input type="button" value="Return books" onclick="window.location.href = '${returnBooksButton}'">
                </td>
                <td>
                    <input type="button" value="Update student's info" onclick="window.location.href = '${updateStudentButton}'">
                    <input type="button" value="Expel student" onclick="window.location.href = '${expelStudentButton}'">
                </td>
            </tr>

        </c:forEach>

    </table>

    <button type="button" value="Add new student" onclick="window.location.href = '/loria/students/addNewStudent'">Add new student</button>

    <br><br>
    <button value="home" onclick="window.location.href = '/loria'">Home</button>

</body>
</html>
