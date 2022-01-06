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
        </tr>
        <c:forEach var="faculty" items="${faculties}">
            <tr>
                <td>${faculty.facultyName}</td>
                <td>${faculty.deanName}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
