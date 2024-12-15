<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ust.webapp.model.Trainee" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Trainee Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<style>
body {
            background: linear-gradient(to right, #74ebd5, #acb6e5);
      }
.navbar {
            width: 100%;
            height: 50px;
        }

        .navbar-nav .nav-link {
            font-size: 1.1rem;
            margin: 0 15px;
            transition: color 0.3s;
            color:white;
        }


        .navbar-nav .nav-link:hover {
            color: #0056b3;
        }
</style>
    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
            <div class="container">
                <a class="navbar-brand" href="#">Trainee Management</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="/trainee">Add Trainee</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/viewtrainee">View all Trainee</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
<style>
a {
    color:black;
    text-decoration: none;
}
</style>
    <div class="container mt-4">
        <h1>Trainee Details Search</h1>

        <form action="/get-trainee" style="width: 50%; padding-bottom: 1%;">
            <div class="form-group p-1">
                <label for="searchid">Enter your ID</label>
                <input type="number" name="searchid" id="searchid" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>

        <%
            List<Trainee> trainees = (List<Trainee>) request.getAttribute("trainees");
            boolean flag = (boolean) request.getAttribute("flag"); // Use Boolean object for null check

            if (flag) { // Check if flag is not null and true
        %>
                <script>
                    alert('Same Trainee already exists');
                </script>
        <%
            }
            if (trainees != null && !trainees.isEmpty()) {
                out.println("<div class='row'>");
                for (Trainee trainee : trainees) {
                    out.println("<div class='col-md-4 mb-3'>");
                    out.println("<div class='card' style='padding: 20px; margin: 10px; background-color: whitesmoke; box-shadow: 0px 0px 10px rgba(0,0,0,0.1);'>");
                    out.println("<div class='card-body'>");
                    out.println("<h5 class='card-title'>ID: " + trainee.id() + "</h5>");
                    out.println("<p class='card-text'>Name: " + trainee.name() + "</p>");
                    out.println("<p class='card-text'>Location: " + trainee.location() + "</p>");
                    out.println("<button class='btn btn-danger'><a href='/delete-trainee?id="+trainee.id()+"'>Delete</a></button>");
                    out.println("</div></div></div>");
                }
                out.println("</div>");
            } else {
                out.println("<p>No trainees found.</p>");
            }
        %>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
