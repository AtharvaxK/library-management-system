<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>Library Dashboard</title>

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

<div class="container mt-5">

    <div class="text-center mb-5">
        <h1 class="page-title">
            Welcome to Library Management System
        </h1>
    </div>

    <div class="row g-4">

        <div class="col-md-4">
            <div class="card dashboard-card text-center p-4">

                <h4>Manage Books</h4>

                <p>
                    Add, update, delete and search books.
                </p>

                <a href="/books" class="btn btn-green">
                    Go To Books
                </a>

            </div>
        </div>

        <div class="col-md-4">
            <div class="card dashboard-card text-center p-4">

                <h4>Manage Users</h4>

                <p>
                    Add and manage library users.
                </p>

                <a href="/users" class="btn btn-green">
                    Go To Users
                </a>

            </div>
        </div>

        <div class="col-md-4">
            <div class="card dashboard-card text-center p-4">

                <h4>Issued Books</h4>

                <p>
                    Issue books and manage returns.
                </p>

                <a href="/issuedBooks" class="btn btn-green">
                    View Issued Books
                </a>

            </div>
        </div>

    </div>

</div>

<footer class="footer-custom">
    Library Management System | Built with Spring Boot
</footer>

</body>
</html>