<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Trainee Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #74ebd5, #acb6e5);
            height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            text-align: center;
        }

        .navbar {
            width: 100%;
            height: 50px;
        }

        .navbar-nav .nav-link {
            font-size: 1.1rem;
            margin: 0 15px;
            transition: color 0.3s;
            color: white;
        }

        .navbar-nav .nav-link:hover {
            color: #0056b3;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 5% 0;
        }

        .form-container {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 2rem;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);
            transition: transform 0.3s;
        }

        .form-container:hover {
            transform: scale(1.02);
        }

        .form-group label {
            font-weight: bold;
        }

        .btn-primary {
            transition: background-color 0.3s, transform 0.3s;
        }

        .btn-primary:hover {
            background-color: #0056b3;
            transform: translateY(-2px);
        }
    </style>
</head>
<body>
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
                <form class="d-flex" action="/get-trainee" method="get" style="margin-left: 20px;">
                                    <input type="number" name="searchid" id="searchid" class="form-control" placeholder="Enter ID" required>
                                    <button type="submit" class="btn btn-primary ms-2">Submit</button>
                                </form>
            </div>
        </div>
    </nav>

    <div class="container">
        <form action="/add-trainee" method="post" class="form-container" style="width: 50%;">
            <h2 class="mb-4">Add Trainee</h2>
            <div class="form-group p-1">
                <label for="id">Enter your ID</label>
                <input type="number" name="id" id="id" class="form-control" required>
            </div>
            <div class="form-group p-1">
                <label for="name">Enter your Name</label>
                <input type="text" name="name" id="name" class="form-control" required>
            </div>
            <div class="form-group p-1">
                <label for="location">Enter your Location</label>
                <input type="text" name="location" id="location" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary mt-3">Submit</button>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
