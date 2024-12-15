<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Task - Task Management</title>
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
    <h1 class="mt-5 text-center">Add Task</h1>
   <form action="/addingtasks" method="post">
       <div class="mb-3">
           <label for="id" class="form-label">Task ID</label>
           <input type="text" name="id" id="id" class="form-control" placeholder="ID" required>
       </div>
       <div class="mb-3">
           <label for="name" class="form-label">Task Name</label>
           <input type="text" name="name" id="name" class="form-control" placeholder="Name" required>
       </div>
       <div class="mb-3">
           <label for="description" class="form-label">Description</label>
           <textarea class="form-control" name="description" id="description" rows="5" placeholder="Enter description" required></textarea>
       </div>
       <div class="mb-3">
           <label for="date" class="form-label">Due Date</label>
           <input type="date" name="date" id="date" class="form-control" required>
       </div>
       <div class="mb-3">
           <label for="completed" class="form-label">Status</label>
           <input type="text" name="completed" id="completed" class="form-control">
       </div>
       <button class="btn btn-primary mt-3" type="submit">Add Task</button>
   </form>

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
