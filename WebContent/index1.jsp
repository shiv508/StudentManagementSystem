<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List"
    import="Com.arch.mvc.model.Student"
    import="Com.arch.mvc.view.Service"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Management </title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #fefefe;
        margin: 0;
        padding:0;
    }
    .container {
        max-width:800px;
        margin: 20px auto;
        padding: 50px;
        margin-top:20px;
        background-color: #a7f5ed;
        border-radius: 70px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
        text-align: center;
        margin-bottom: 20px;
        margin-top:10px;
        font-family:Arial;
        text-transform:uppercase;
    }
    form {
        margin-bottom: 20px;
    }
    label {
        display: block;
        margin-bottom: 5px;
    }
    input[type="text"], input[type="number"], input[type="email"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: 2px solid black;
        border-radius: 4px;
        background-color: #bbf985;
    }
    input[type="submit"] {
        background-color: #6cf305;
        color: black;
        border: none;
        padding: 10px 20px;
        cursor: pointer;
        border-radius: 4px;
    }
    input[type="submit"]:hover, input[type="button"]:hover {
        background-color: #0056b3;
    }
    table {
        width: 100%;
        background-color:#bbf985;
        border-collapse: collapse;
        border:2px solid black;
        color: black;
        
    }
    th, td {
        border: 2px solid #ddd;
        padding: 8px;
        text-align: left;
        border:2px solid black;
        background-color:#bbf985;
    }
    th {
        background-color: #6fff00;
        border:2px solid black;
        color: #000000;
    }
    #one{
        border: 5px solid black;
        padding:50px;
        padding-left:50px;
        padding-bottom: 20px;
        padding-top: 1px;
        margin-left: 200px;
        margin-right: 200px;
        background-color: #d8f797;

    }
    input::placeholder
    {
        color:rgb(0, 0, 0);
    }
    #two {
    border: 2px solid black;
}
</style>
</head>
<body>

<div class="container">
    <header><h1>Student Management System</h1></header>

    <!-- Add Student Form -->
    <form id="one" action="AddServlet">
        <h2>Add Student</h2>
        <input type="text"  name="id" required placeholder="Enter Student ID">
        <input type="text"  name="name" required placeholder="Enter Student Name">
        <input type="text"  name="age" required placeholder="Enter Student Age">
        <input type="text"name="mobile" required placeholder="Enter Student Mobile No">
        <input type="text" name="email" required placeholder="Enter Student Email">
        <input type="submit" name="add Student" value="Add Student">
    </form>

    
    <!-- Delete Student Form -->
    <form id="one" action="DeleteStudent">
        <h2>Delete Student</h2>
        <input type="text" name="id" required placeholder="Enter Student ID">
        <input type="submit" name="delete Student" value="Delete Student">
    </form>

    <!-- Update Student Form -->
    <form id="one" action="UpdateStudent">
        <h2>Update Student</h2>
        <input type="text" name="id" required placeholder="Enter Student ID">
        <input type="text" name="name" required placeholder="Enter Student name">
        <input type="text"name="age" required placeholder="Enter Student Age">
        <input type="text"name="mobile" required placeholder="Enter Student Mobile No">
        <input type="text" name="email" required placeholder="Enter Student Email">
        <input type="submit" name="updateStudent" value="Update Student">
    </form>
    
    <!-- View Students Table -->
    <h2>View Students</h2>
    <table>
        <tr id="two">
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Mobile No</th>
            <th>Email</th>
        </tr>       
<%
    Service service = new Service();
    List<Student> students = service.getAllStudents();
%>

<% for (Student student : students) { %>
        <tr id="two">
            <td><%= student.getId() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getAge() %></td>
            <td><%= student.getMobile() %></td>
            <td><%= student.getEmail() %></td>
            
        </tr>
<% } %>
    </table>
    
</div>

<footer>

</footer>
</body>
</html>