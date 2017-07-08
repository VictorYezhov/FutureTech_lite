<%--
  Created by IntelliJ IDEA.
  User: Victor
  Date: 08.06.2017
  Time: 15:11
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
                <form:form action="/newBrand?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data" >
                    <div class="form-group">
                        <input id="add-brand-name" onkeyup="check();" type="text" class="form-control" name="name" placeholder="Please enter Brand name" required>
                    </div>

                    <div class="form-group">
                        <input type="file" class="form-control btn btn-default" name="image" required>
                    </div>
                    <button type="submit" class="btn btn-success">Add brand</button>
                </form:form>
            </div>
        </div>
    </div>
    <div class="col-md-6">
        <div class="content-box-large">
            <div class="panel-heading">
                <div class="panel-title">Brand List</div>
            </div>
            <div class="panel-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Brand Name</th>
                            <th>Logo</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="brand" items="${brands}">
                        <tr>
                            <td>${brand.name}</td>
                            <td><c:if test="${brand.pathImage==null}"> <img src="resources/default/no_image.png" style="width: 75px; height: auto;"></c:if>
                                <c:if test="${brand.pathImage!=null}"> <img src="${brand.pathImage}" style="width: 75px; height: auto;"></td></c:if>
                                <td><button class="btn btn-danger" onclick="window.location.href='/deleteBrand/${brand.id}'"><i class="fa fa-trash-o"> Delete</i></button></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>