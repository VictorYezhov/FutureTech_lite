<%--
  Created by IntelliJ IDEA.
  User: Victor
  Date: 28.06.2017
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h2 class="main-heading2 page-title">Shopping Cart</h2>
<div class="shopping-cart">

    <div class="shopping-cart-table">
        <div class="table-responsive">
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
                <c:forEach var="order" items="${orders}">
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


<%--<div class="shopping-cart">--%>
    <%--<div class="shopping-cart-table ">--%>
        <%--<div class="table-responsive">--%>
            <%--<table class="table">--%>
                <%--<thead>--%>
                <%--<tr>--%>
                    <%--<th class="cart-romove item">Remove</th>--%>
                    <%--<th class="cart-description item">Image</th>--%>
                    <%--<th class="cart-product-name item">Product Name</th>--%>
                    <%--<th class="cart-edit item">Edit</th>--%>
                    <%--<th class="cart-qty item">Quantity</th>--%>
                    <%--<th class="cart-sub-total item">Subtotal</th>--%>
                    <%--<th class="cart-total last-item">Grandtotal</th>--%>
                <%--</tr>--%>
                <%--</thead><!-- /thead -->--%>
                <%--<tfoot>--%>
                <%--<tr>--%>
                    <%--<td colspan="7">--%>
                        <%--<div class="shopping-cart-btn">--%>
							<%--<span class="">--%>
								<%--<a href="#" class="btn btn-upper btn-primary outer-left-xs">Continue Shopping</a>--%>
								<%--<a href="#" class="btn btn-upper btn-primary pull-right outer-right-xs">Update shopping cart</a>--%>
							<%--</span>--%>
                        <%--</div><!-- /.shopping-cart-btn -->--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--</tfoot>--%>
                <%--<tbody>--%>
                <%--<c:forEach var="order" items="${orders}">--%>
                <%--<c:forEach var="commodity" items="${order.getCommoditySet()}">--%>
                <%--<tr>--%>
                    <%--<td class="romove-item"><a href="/deleteCommodityFromOrder/${order.id}/${commodity.id}" title="cancel" class="icon"><i class="fa fa-trash-o"></i></a></td>--%>
                    <%--<td class="cart-image">--%>

                            <%--<img src="${commodity.pathImage}" alt="">--%>

                    <%--</td>--%>
                    <%--<td class="cart-product-name-info">--%>
                        <%--<h4 class="cart-product-description"><a href="/details/${commodity.id}"> ${commodity.name}</a></h4>--%>
                    <%--</td>--%>
                    <%--<td class="cart-product-edit"><a href="#" class="product-edit">Edit</a></td>--%>
                    <%--<td class="cart-product-sub-total"><span class="cart-sub-total-price">$300.00</span></td>--%>
                    <%--<td class="cart-product-grand-total"><span class="cart-grand-total-price">$300.00</span></td>--%>
                <%--</tr>--%>
                <%--</c:forEach>--%>
                <%--</tbody><!-- /tbody -->--%>
            <%--</table><!-- /table -->--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>