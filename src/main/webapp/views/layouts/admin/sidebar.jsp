<%--
  Created by IntelliJ IDEA.
  User: terty
  Date: 11.06.2017
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="sidebar content-box" style="display: block;">
    <ul class="nav">
        <!-- Main menu -->
        <li class="current"><a href="/adminPage"><i class="fa fa-tachometer"></i> Dashboard</a></li>
        <li><a href="/showClients"><i class="fa fa-users"></i> Customers</a></li>
        <li class="dropdown-toggle">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <i class="fa fa-pencil"></i> Commodities and Brands
                <span class="caret pull-right"></span>
            </a>
            <ul>
                <li><a href="/newBrand">Add Brand <i class="fa fa-plus"></i></a></li>
                <li><a href="/newMobileTelephone">Add MobileTelephone <i class="fa fa-plus"></i></a></li>
                <li><a href="/newMP3">Add MP3 <i class="fa fa-plus"></i></a></li>
                <li><a href="/newPC">Add PC <i class="fa fa-plus"></i></a></li>
                <li><a href="/newTablet">Add Tablet <i class="fa fa-plus"></i></a></li>
            </ul>
        </li>
    </ul>
</div>
