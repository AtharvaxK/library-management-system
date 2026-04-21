<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<html>

<head>

    <title>Issued Books</title>

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
            Issued Books
        </h2>

        <a href="/issueBook"
           class="btn btn-green">
            Issue New Book
        </a>

    </div>

    <div class="card shadow-sm p-3">

        <table class="table table-bordered table-hover">

            <thead>
            <tr>
                <th>Issue ID</th>
                <th>User ID</th>
                <th>Book ID</th>
                <th>Issue Date</th>
                <th>Return Date</th>
                <th>Action</th>
            </tr>
            </thead>

            <tbody>

            <c:forEach var="issue" items="${issuedBooks}">

                <tr>
                    <td>${issue.issueId}</td>
                    <td>${issue.userId}</td>
                    <td>${issue.bookId}</td>
                    <td>${issue.issueDate}</td>
                    <td>${issue.returnDate}</td>

                    <td>

                        <a href="/returnBook?id=${issue.issueId}"
                           class="btn btn-warning btn-sm">
                            Return Book
                        </a>

                    </td>

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