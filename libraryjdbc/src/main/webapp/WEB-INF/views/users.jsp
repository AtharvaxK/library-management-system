<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<html>

<head>

    <title>Manage Users</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <link rel="stylesheet" href="/style.css">

</head>

<body>

<nav class="navbar navbar-expand-lg navbar-custom">

    <div class="container-fluid">

        <a class="navbar-brand" href="/">
            Library Management System
        </a>

        <ul class="navbar-nav ms-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="#">Admin</a>
            </li>
        </ul>

    </div>

</nav>

<div class="container mt-4">

    <div class="d-flex justify-content-between align-items-center mb-3">

        <h2 class="page-title">
            Manage Users
        </h2>

        <a href="/addUser"
           class="btn btn-green">
            Add New User
        </a>

    </div>

    <div class="card p-3 shadow-sm">

        <table class="table table-bordered table-hover">

            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Type</th>
            </tr>
            </thead>

            <tbody>

            <c:forEach var="user" items="${users}">

                <tr>

                    <td>${user.userId}</td>
                    <td>${user.name}</td>
                    <td>${user.type}</td>

                </tr>

            </c:forEach>

            </tbody>

        </table>

    </div>

</div>

<footer class="footer-custom">
    Library Management System | Built with Spring Boot
</footer>

</body>
</html>