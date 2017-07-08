<%--
  Created by IntelliJ IDEA.
  User: Victor
  Date: 13.06.2017
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<div class="col-xs-12 col-sm-6 col-md-6 product-info-image">
    <c:if test="${user.pathImage==null}"><a href="./"> <img src="/resources/default/no_avatar.png" style="width: 300px; height: auto;" alt="${user.name} "></a></c:if>
    <c:if test="${user.pathImage!=null}"><a href="./"><img src="${user.pathImage}" style="width: 300px; height: auto;" alt="${user.name}"> </a></c:if>
</div>

<div class="col-sm-6 col-md-6 product-info-block">
    <div class="product-info">
        <h1 class="name">${user.name}</h1>
        <ul class="list-unstyled manufacturer">
            <li><span>Address:</span>${user.adress}</li>
            <li><span>Date of registration:</span>${user.registerDate}</li>
            <li><span>Contact Email:</span>${user.email}</li>
        </ul>
        <p><a class="btn btn-success" href="/updateUserInfo"><i class="fa fa-refresh"></i> Update info</a></p>
    </div>
</div>

<div class="col-md-12">
    <h2>Your cart</h2>
    <table class="table">
        <thead>
            <tr>
                <th>Order ID</th>
                <th>Brand</th>
                <th>Name</th>
                <th>Price</th>
                <th>Date</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="order" items="${user.getOrders()}">
            <c:forEach var="commodity" items="${order.getCommoditySet()}">
                <tr>
                    <td>${order.id}</td>
                    <td>${commodity.brand.getName()}</td>
                    <td><a href="/details/${commodity.id}"> ${commodity.name}</a></td>
                    <td>${commodity.price}</td>
                    <td>${order.date}</td>
                    <td><a href="/deleteCommodityFromOrder/${order.id}/${commodity.id}"><i class="fa fa-times" aria-hidden="true"></i></a></td>
                </tr>
            </c:forEach>
        <tr>
            <c:if test="${order.isOpen()}">
                <td><a href="/buy/${order.id}">buy</a></td>
            </c:if>
        <td>
            Status: <c:if test="${order.isOpen()}"> Open</c:if>
            <c:if test="${!order.isOpen()}"> Close </c:if>
        </td>
        <td>
        <i class="fa fa-times" aria-hidden="true"></i> <a href="/deleteOrder/${order.id}">delete</a>
        </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>