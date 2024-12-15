<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task Management</title>
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
        .floating-block {
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            border-radius: 8px;
            background: white;
            margin: 20px;
            text-align: center;
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
    <h1 class="my-4 text-center">Welcome to Task Management</h1>
    <div class="row">
        <div class="col-md-6">
            <div class="floating-block">
                <h4>Add Tasks</h4>
                <p>Quickly add new tasks to your list.</p>
                <a href="/addtasks" class="btn btn-primary">Add Task</a>
            </div>
        </div>
        <div class="col-md-6">
            <div class="floating-block">
                <h4>View Tasks</h4>
                <p>See all your tasks in one place.</p>
                <a href="/viewtasks" class="btn btn-secondary">View Tasks</a>
            </div>
        </div>
    </div>
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
