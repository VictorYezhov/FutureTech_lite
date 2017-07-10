<%--
  Created by IntelliJ IDEA.
  User: Victor
  Date: 14.06.2017
  Time: 0:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="user-update">
    <h1>User Info Update</h1>
    <form:form action="/updateUserInfo?${_csrf.parameterName}=${_csrf.token}"
               enctype="multipart/form-data"
               method="post"
               class="form-horizontal">

        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Name</label>
            <div class="col-sm-10">
                <input onkeyup="check();" type="text" class="form-control" id="name" name="name" placeholder="Please enter new Name" value="${null}" >
            </div>
        </div>

        <div class="form-group">
            <label for="address" class="col-sm-2 control-label">Address</label>
            <div class="col-sm-10">
                <input onkeyup="check();" type="text" class="form-control"  id="address" name="address" placeholder="Please enter new Address" value="${null}" >
            </div>
        </div>

        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <input onkeyup="check();" type="email" class="form-control"  id="email" name="email" placeholder="Please enter new Email" value="${null}" >
            </div>
        </div>

        <div class="form-group">
            <label for="image" class="col-sm-2 control-label">Avatar</label>
            <div class="col-sm-10">
                <input onkeyup="check();" type="file" class="form-control"  id="image" name="image" value="${null}"  >
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success" id="update-user" >Save</button>
            </div>
        </div>

    </form:form>
</div>

<%--<script>--%>
    <%--function check() {--%>
        <%--var name = document.getElementById('name'),--%>
            <%--address = document.getElementById('address'),--%>
            <%--email = document.getElementById('email');--%>
        <%--document.getElementById('update-user').disabled = name.value && address.value && email.value ? false : "disabled";--%>
    <%--}--%>
<%--</script>--%>