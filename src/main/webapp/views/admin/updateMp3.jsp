<%--
  Created by IntelliJ IDEA.
  User: Victor
  Date: 12.06.2017
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h2>UPDATE MP3</h2>
<form:form action="/updateMP3/${Id}/?${_csrf.parameterName}=${_csrf.token}" method="post"
           enctype="multipart/form-data"
           class="form-horizontal">
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Name</label>
        <div class="col-sm-10">
            <input name="name" type="text" class="form-control" id="name" required="required" value="${mp3.name}" >
        </div>
    </div>
    <div class="form-group">
        <label for="brand" class="col-sm-2 control-label">Brand</label>
        <div class="col-sm-10">
            <select  name="brand" class="form-control" style="width: 200px" >
                <option value="${mp3.getBrand().getId()}">${mp3.getBrand().getName()}</option>
                <c:forEach var="brand" items="${brands}">
                    <option value="${brand.id}">${brand.name}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="price" class="col-sm-2 control-label">Price</label>
        <div class="col-sm-10">
            <input name="price" type="number" class="form-control" id="price" value="${mp3.price}" required="required" min="1">
        </div>
    </div>
    <div class="form-group">
        <label for="battery" class="col-sm-2 control-label">Battery Capacity</label>
        <div class="col-sm-10">
            <input name="battery" type="number" class="form-control" id="battery" min="1" value="${mp3.batteryCapacity}" required="required" min="1">
        </div>
    </div>

    <div class="form-group">
        <label for="memory" class="col-sm-2 control-label">Memory Gb</label>
        <div class="col-sm-10">
            <input name="memory" type="number" class="form-control" id="memory" min="1" value="${mp3.memory}" required="required" min="1">
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 control-label">Image input</label>
        <div class="col-sm-10">
            <input type="file" class="btn btn-default" id="exampleInputFile1" min="1" name="image" >
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-success">Save</button>
        </div>
    </div>


</form:form>

