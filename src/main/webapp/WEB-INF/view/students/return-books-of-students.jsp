<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Return books of student</title>
</head>
<body>
    <h3>Choose books of student ${student.name} to be returned</h3>

    <form:form method="post" modelAttribute="books" action="returnBooksOfStudent">

        <c:forEach var="book" items="${books}">

            <input type="hidden" name="student_id" value="${student.id}">
            <input type="checkbox" name="checkedBooks" value="${book.id}" id="${book.id}">
            <label for="${book.id}">${book.title} by ${book.authorName}</label>
            <br>
        </c:forEach>
        <input type="submit" value="Return selected books to the library">

    </form:form>

</body>
</html>
