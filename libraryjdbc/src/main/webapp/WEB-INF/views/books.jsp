<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>

    <title>Manage Books</title>

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
                <a class="nav-link" href="/">
                    Home
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="#">
                    Admin
                </a>
            </li>

        </ul>

    </div>

</nav>

<div class="container mt-4">

    <div class="d-flex justify-content-between align-items-center mb-3">

        <h2 class="page-title">
            Manage Books
        </h2>

        <a href="/addBook"
           class="btn btn-green">
            Add New Book
        </a>

    </div>

    <div class="card p-3 shadow-sm">

        <table class="table table-bordered table-hover">

            <thead>

            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Quantity</th>
                <th>Actions</th>
            </tr>

            </thead>

            <tbody>

            <c:forEach var="book" items="${books}">

                <tr>

                    <td>${book.bookId}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.quantity}</td>

                    <td>

                        <a href="/editBook?id=${book.bookId}"
                           class="btn btn-success btn-sm">
                            Edit
                        </a>

                        <a href="/deleteBook?id=${book.bookId}"
                           class="btn btn-danger btn-sm">
                            Delete
                        </a>

                    </td>

                </tr>

            </c:forEach>

            </tbody>

        </table>

    </div>

</div>

</body>
</html>