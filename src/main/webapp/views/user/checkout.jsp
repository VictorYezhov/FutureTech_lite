<%--
  Created by IntelliJ IDEA.
  User: Victor
  Date: 29.06.2017
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div>
    <p>Your cart</p>
    <table class="table">
        <thead>
        <tr>
            <th>Order ID</th>
            <th>Brand</th>
            <th>Name</th>
            <th>Price</th>
            <th>Date</th>
        </tr>

        </thead>
        <tbody>

            <c:forEach var="commodity" items="${order.getCommoditySet()}">
                <tr>
                    <td>${order.id}</td>
                    <td>${commodity.brand.getName()}</td>
                    <td><a href="/details/${commodity.id}"> ${commodity.name}</a></td>
                    <td>${commodity.price}</td>
                    <td>${order.date}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<form:form action="/buy/${id}" method="post">
<h3>Please choose payment option</h3>
<select  name="payment" class="form-control" style="width: 200px">
    <option value="-1">Choose please</option>
    <option value="1">Credit card</option>
    <option value="2">Cash when delivered</option>
    <option value="3">WebMoney</option>
</select>

<br>
<br>
<h3>Please choose way of delivering</h3>
<select  name="delivering" class="form-control" style="width: 200px">
    <option value="-1">Choose please</option>
    <option value="1">By Post</option>
    <option value="2">By your own</option>
</select>

<button class="btn btn-primary"> BUY</button>

</form:form>
<br><br>

