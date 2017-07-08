<%--
  Created by IntelliJ IDEA.
  User: Victor
  Date: 12.06.2017
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="/updatePC/${Id}/?${_csrf.parameterName}=${_csrf.token}" method="post"
           enctype="multipart/form-data"
           class="form-horizontal">
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Name</label>
        <div class="col-sm-10">
            <input name="name" type="text" class="form-control" id="name" value="${pc.name}" required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="brand" class="col-sm-2 control-label">Brand</label>
        <div class="col-sm-10">
            <select  name="brand" class="form-control" style="width: 200px">
                <option value="${pc.getBrand().getId()}">${pc.getBrand().getName()}</option>
                <c:forEach var="brand" items="${brands}">
                    <option value="${brand.id}">${brand.name}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="price" class="col-sm-2 control-label">Price</label>
        <div class="col-sm-10">
            <input name="price" type="number" class="form-control" id="price" value="${pc.price}" required="required">
        </div>
    </div>


    <div class="form-group">
        <label for="videoAdapter" class="col-sm-2 control-label">Video Card</label>
        <div class="col-sm-10">
            <input name="videoAdapter" type="text" class="form-control" id="videoAdapter" value="${pc.videoAdapterType}" required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="processor" class="col-sm-2 control-label">Processor</label>
        <div class="col-sm-10">
            <input name="processor" type="text" class="form-control" id="processor" value="${pc.processor}" required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="memory" class="col-sm-2 control-label">Memory Gb</label>
        <div class="col-sm-10">
            <input name="memory" type="number" class="form-control" id="memory" value="${pc.memory}" required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="RAM" class="col-sm-2 control-label">RAM Gb</label>
        <div class="col-sm-10">
            <input  name="RAM" type="number" class="form-control" id="RAM"  value="${pc.RAM}" required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="MotherLoad" class="col-sm-2 control-label">MotherLoad</label>
        <div class="col-sm-10">
            <input name="MotherLoad" type="text" class="form-control" id="MotherLoad" value= "${pc.motherboard}" required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="OS" class="col-sm-2 control-label">OS</label>
        <div class="col-sm-10">
            <input name="OS" type="text" class="form-control" id="OS" value="${pc.OS}" required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="weight" class="col-sm-2 control-label">weight</label>
        <div class="col-sm-10">
            <input name="weight" type="number" class="form-control" id="weight" value="${pc.weight}" required="required">
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
