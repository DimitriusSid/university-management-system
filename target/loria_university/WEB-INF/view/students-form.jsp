<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
    <form:form action="saveStudent" method="get" modelAttribute="student">
        <p>Name <form:input path="name"/></p>
        <p>Course <form:input path="course"/></p>

        <label for="select">Faculty</label>
        <select id="select">
            <c:forEach var="fac" items="${faculties}">
                <option value="${fac.id}">${fac.facultyName}</option>
            </c:forEach>
        </select>

        <script>
            function setFacId() {
                let facId = document.getElementById("select").value;
                document.getElementById("fac_id").value = parseInt(facId);
            }
        </script>

        <input type="hidden" id="fac_id" name="fac_id">

        <input type="submit" value="OK" onclick="setFacId()">
    </form:form>
</body>
</html>
