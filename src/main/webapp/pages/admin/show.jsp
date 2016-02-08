<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="table-responsive">
<table class="table table-hover">
    <thead>
    <tr>
        <th>Login</th>
        <th>Password</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Roles</th>
    </tr>
    </thead>
    <jsp:useBean id="users" scope="request" type="java.util.List<entity.User>"/>
    <c:forEach var="user" items="${users}">
    <tr>
        <td>${user.login}</td>
        <td>${user.password}</td>
        <td>${user.name}</td>
        <td>${user.surname}</td>
        <td>
            <c:forEach var="role" items="${user.roles}">
                ${role.name} &nbsp
            </c:forEach>
        </td>
        <td class="col-md-5">
            <a class="btn btn-primary" href="/adminpanel/update?login=${user.login}"> Edit </a>
        </td>
    </tr>
    </c:forEach>
</table>
</div>
