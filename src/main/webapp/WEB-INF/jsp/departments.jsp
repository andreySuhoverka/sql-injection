<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>

<table>
    <thead>
    <th>department id</th>
    <th>department name</th>
    </thead>
    <tbody>
    <c:forEach var="dep" items="${departments}">
        <tr>
            <td>${dep.id}</td>
            <td>${dep.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>
Make your own sql injection. Insert something in Departments
<form action="/injectHarmfulSql">
    dep id<input type="text" name="id"><br>
    dep name<input type="text" name="name">
    <button type="submit">submit department</button>
</form>




</body>
</html>