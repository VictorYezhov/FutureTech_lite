<%--
  Created by IntelliJ IDEA.
  User: Victor
  Date: 12.06.2017
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="/updateTablet/${Id}/?${_csrf.parameterName}=${_csrf.token}" method="post"
           enctype="multipart/form-data"
           class="form-horizontal">
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Name</label>
        <div class="col-sm-10">
            <input name="name" type="text" class="form-control" id="name" value="${tablet.name}" required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="brand" class="col-sm-2 control-label">Brand</label>
        <div class="col-sm-10">
            <select  name="brand" class="form-control" style="width: 200px">
                <option value="${tablet.getBrand().getId()}">${tablet.getBrand().getName()}</option>
                <c:forEach var="brand" items="${brands}">
                    <option value="${brand.id}">${brand.name}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="price" class="col-sm-2 control-label">Price</label>
        <div class="col-sm-10">
            <input name="price" type="number" class="form-control" id="price" value="${tablet.price}" required="required">
        </div>
    </div>

    <div class="form-group">
        <label  class="col-sm-2 control-label">WIFI</label>
        <div class="col-sm-10">
            <label class="radio-inline">
                <input name="wifi" type="radio"  id="radio3" value="${true}" <c:if test="${tablet.wifi==true}"> checked</c:if>> yes
            </label>
            <label class="radio-inline">
                <input  name="wifi" type="radio"  id="radio4" value="${false}"<c:if test="${tablet.wifi==false}"> checked</c:if>> no
            </label>
        </div>
    </div>
    <div class="form-group">
        <label for="battery" class="col-sm-2 control-label">Battery Capacity</label>
        <div class="col-sm-10">
            <input name="battery" type="number" class="form-control" id="battery" value="${tablet.batteryCapacity}" required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="ammountofsim" class="col-sm-2 control-label">Amount of sim cards</label>
        <div class="col-sm-10">
            <input name="amounts" type="number" class="form-control" id="ammountofsim" value="${tablet.amountOfSimCards}" required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="memory" class="col-sm-2 control-label">Memory Gb</label>
        <div class="col-sm-10">
            <input name="memory" type="number" class="form-control" id="memory" value="${tablet.memory}" required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="RAM" class="col-sm-2 control-label">RAM Gb</label>
        <div class="col-sm-10">
            <input  name="RAM" type="number" class="form-control" id="RAM" value="${tablet.RAM}" required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="camera" class="col-sm-2 control-label">Camera</label>
        <div class="col-sm-10">
            <input name="camera" type="text" class="form-control" id="camera" value="${tablet.camera}" required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="OS" class="col-sm-2 control-label">OS</label>
        <div class="col-sm-10">
            <input name="OS" type="text" class="form-control" id="OS" value="${tablet.OS}" required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="Screendiagonal" class="col-sm-2 control-label">Screen diagonal</label>
        <div class="col-sm-10">
            <input name="Screendiagonal" type="number" class="form-control" id="Screendiagonal" value="${tablet.screenDiagonal}" required="required">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">Image input</label>
        <div class="col-sm-10">
            <input type="file" class="btn btn-default" id="exampleInputFile1" name="image">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-success">Save</button>
        </div>
    </div>

</form:form>