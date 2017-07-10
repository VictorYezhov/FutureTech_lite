<%--
  Created by IntelliJ IDEA.
  User: Victor
  Date: 10.07.2017
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="row">
    <div class="col-md-6">
        <div class="content-box-large">
            <div class="panel-heading">
                <div class="panel-title">Add new Brand</div>
            </div>
            <div class="panel-body">
                <form:form action="/updateBrand/${id}?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data" >

                    <div class="form-group">
                        <input id="add-brand-name" onkeyup="check();" type="text" class="form-control" name="name" placeholder="Please enter Brand name" required value="${brand.getName()}">
                    </div>

                    <div class="form-group">
                        <input type="file" class="form-control btn btn-default" name="image">
                    </div>
                    <button type="submit" class="btn btn-success">Update brand</button>
                </form:form>
            </div>
        </div>
    </div>