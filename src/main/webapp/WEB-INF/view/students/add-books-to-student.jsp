<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add books for student</title>
</head>
<body>
    <h3>Add books for student ${student.studentPersonalInfo.name}</h3>
    <form:form method="post" action="addBooksToStudent" modelAttribute="books">

        <c:forEach var="book" items="${books}">

            <input type="hidden" value="${student.id}" name="student_id">
            <input type="checkbox" name="checkedBooks" id="${book.id}" value="${book.id}">
            <label for="${book.id}">${book.title} by ${book.authorName}</label>
            <br>

        </c:forEach>
        <input type="submit" value="Add selected books to student">

    </form:form>

</body>
</html>
