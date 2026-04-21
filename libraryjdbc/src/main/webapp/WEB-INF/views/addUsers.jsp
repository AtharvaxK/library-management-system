<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>Add User</title>

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
                    Add New User
                </h2>

                <form action="/saveUser" method="post">

                    <div class="mb-3">

                        <label class="form-label">
                            User Name
                        </label>

                        <input type="text"
                               name="name"
                               class="form-control"
                               placeholder="Enter user name"
                               required>

                    </div>

                    <div class="mb-3">

                        <label class="form-label">
                            User Type
                        </label>

                        <select name="type"
                                class="form-select"
                                required>

                            <option value="">
                                Select User Type
                            </option>

                            <option value="Student">
                                Student
                            </option>

                            <option value="Admin">
                                Admin
                            </option>

                        </select>

                    </div>

                    <button type="submit"
                            class="btn btn-green">
                        Save User
                    </button>

                    <a href="/users"
                       class="btn btn-secondary">
                        Cancel
                    </a>

                </form>

            </div>

        </div>

    </div>

</div>

<footer class="footer-custom">
    Library Management System | Built with Spring Boot
</footer>

</body>
</html>