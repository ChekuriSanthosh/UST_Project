<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ust.tasks.dto.TaskDto" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Tasks - Task Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .navbar {
            background-color: #007bff;
        }
        .navbar-nav .nav-link {
            color: black;
        }
        .navbar-nav .nav-link:hover {
            color: #ffc107;
        }
        a{
        text-decoration: none;
        color:white;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-primary">
    <a class="navbar-brand" href="/">Task Management App</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/addtasks">Add Task</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/viewtasks">View Tasks</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <h1 class="mt-5">Tasks</h1>
    <div class="mb-3">
        <form action="/getTask" style="width: 50%; padding-bottom: 1%;">
                    <div class="form-group p-1">
                        <label for="searchId">Enter your ID</label>
                        <input type="number" name="searchId" id="searchId" class="form-control" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
    </div>

    <%
                List<TaskDto> tasks = (List<TaskDto>) request.getAttribute("tasks");


                if (tasks != null && !tasks.isEmpty()) {
                    out.println("<div class='row'>");
                    for (TaskDto task : tasks) {
                        String backgroundColor = task.completed().equalsIgnoreCase("true") ? "green" : "red";

                            out.println("<div class='col-md-4 mb-3'>");
                            out.println("<div class='card' style='background-color: " + backgroundColor + "; color: white; padding: 20px; margin: 10px; box-shadow: 0px 0px 10px rgba(0,0,0,0.1);'>");
                            out.println("<div class='card-body'>");
                        out.println("<h5 class='card-title'>ID: " + task.id() + "</h5>");
                        out.println("<p class='card-text'>Name: " + task.name() + "</p>");
                        out.println("<p class='card-text'>Description: " + task.description() + "</p>");
                        out.println("<p class='card-text'>DueDate: " + task.date() + "</p>");
                        out.println("<p class='card-text'>Completed: " + task.completed() + "</p>");
                        out.println("<a href='/delete-task?id="+task.id()+"'><button class='btn btn-danger'>Delete</button></a>");
                        out.println("</div></div></div>");
                    }
                    out.println("</div>");
                } else {
                    out.println("<p>No tasks found.</p>");
                }
            %>



    </div>


<footer class="bg-primary text-white text-center">
    <p>&copy UST&trade; Global</p>
    <p id="dateview"></p>
</footer>

<script>
    function updateDateTime(){
        document.getElementById('dateview').textContent=new Date().toLocaleString();
    }
    setInterval(updateDateTime, 1000);
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
