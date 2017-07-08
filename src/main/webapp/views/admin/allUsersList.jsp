<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Customer List</h2>
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Customer Name</th>
            <th>Email</th>
            <th>Join</th>
            <th>Status</th>
            <th>Type</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.registerDate}</td>
            <td><c:if test="${user.enable==true}"><button class="btn btn-success" onclick="window.location.href='/changeActive/${user.id}'"><i class="fa fa-check"> Active</i></button></c:if>
                <c:if test="${user.enable==false}"><button class="btn btn-danger" onclick="window.location.href='/changeActive/${user.id}'"><i class="fa fa-times"> Inactive</i></button></c:if></td>
            <td><c:if test="${user.role eq 'ROLE_USER'}"><button class="btn btn-success" onclick="window.location.href='/changeRole/${user.id}'"><i class="fa fa-user"> User</i></button></c:if>
                <c:if test="${user.role eq 'ROLE_ADMIN'}"><button class="btn btn-primary" onclick="window.location.href='/changeRole/${user.id}'"><i class="fa fa-user-secret"> Admin</i></button></c:if>
            </td>
            <td>
                <a href='/deleteUser/${user.id}' onclick="return confirmDelete();" class="btn btn-danger"><i class="fa fa-trash-o"> Delete</i></a>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>


<script>
    function confirmDelete() {
        return confirm("Are you sure that you want to delete user  ?") ? true : false;
    }
</script>