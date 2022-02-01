<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/26/2022
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books of Loria University</title>
</head>
<body>

    <h3>Books of Loria University</h3>

    <table>
        <tr>
            <th>Author</th>
            <th>Title</th>
            <th>Publication Date</th>
            <th>Students</th>
            <th>Operations</th>
        </tr>

        <c:forEach var="book" items="${books}">

            <c:url var="updateBook" value="/loria/library/updateBook">
                <c:param name="book_id" value="${book.id}"/>
            </c:url>

            <c:url var="deleteBook" value="/loria/library/deleteBook">
                <c:param name="book_id" value="${book.id}"/>
            </c:url>

            <c:url var="showStudentsOfBookButton" value="/loria/library/showStudentsOfBook">
                <c:param name="book_id" value="${book.id}"/>
            </c:url>

            <tr>
                <td>${book.authorName}</td>
                <td>${book.title}</td>
                <td>${book.year}</td>
                <td>
                    <input type="button" value="Show students" onclick="window.location.href = '${showStudentsOfBookButton}'">
                </td>
                <td>
                    <input type="button" value="Update book" onclick="window.location.href = '${updateBook}'">
                    <input type="button" value="Delete book" onclick="window.location.href = '${deleteBook}'">
                </td>

            </tr>
        </c:forEach>

    </table>
    <br>
    <button value="Add new book" onclick="window.location.href = '/loria/library/addNewBook'">Add new book</button>

    <br><br>
    <button value="home" onclick="window.location.href = '/loria'">Home</button>

</body>
</html>
