<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

</head>
<body>
    <div class="container">
    <form action="add-trainees" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" required>

        <label for="userName">UserName:</label>
        <input type="text" id="userName" name="userName" required>

        <label for="location">Location:</label>
        <input type="text" id="location" name="location" required>

        <label for="joinDate">Join Date:</label>
        <input type="date" id="joinDate" name="joinDate" required>
        <br>
        <button type="submit" >Add</button>
    </form>
    </div>