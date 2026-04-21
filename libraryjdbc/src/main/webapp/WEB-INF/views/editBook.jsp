<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>Edit Book</title>

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

    <div class="row justify-content-center">

        <div class="col-md-7">

            <div class="card form-card p-4">

                <h2 class="page-title mb-4">
                    Edit Book
                </h2>

                <form action="/updateBook" method="post">

                    <input type="hidden"
                           name="bookId"
                           value="${book.bookId}">

                    <div class="mb-3">
                        <label class="form-label">
                            Title
                        </label>

                        <input type="text"
                               class="form-control"
                               name="title"
                               value="${book.title}">
                    </div>

                    <div class="mb-3">
                        <label class="form-label">
                            Author
                        </label>

                        <input type="text"
                               class="form-control"
                               name="author"
                               value="${book.author}">
                    </div>

                    <div class="mb-3">
                        <label class="form-label">
                            Quantity
                        </label>

                        <input type="number"
                               class="form-control"
                               name="quantity"
                               value="${book.quantity}">
                    </div>

                    <button type="submit"
                            class="btn btn-green">
                        Update Book
                    </button>

                    <a href="/books"
                       class="btn btn-secondary">
                        Cancel
                    </a>

                </form>

            </div>

        </div>

    </div>

</div>

</body>
</html>