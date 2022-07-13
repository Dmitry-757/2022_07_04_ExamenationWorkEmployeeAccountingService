<%@ page import="org.dng.EmployeeAccountingService.Entities.Department" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add deparment</title>
    <style>
        table {
            border-collapse: collapse;
            border: 2px solid rgb(200, 200, 200);
            letter-spacing: 1px;
            font-size: 0.8rem;
        }

        td, th {
            border: 1px solid rgb(190, 190, 190);
            padding: 10px 20px;
        }

        th {
            background-color: rgb(235, 235, 235);
        }

        td {
            text-align: center;
        }
    </style>
</head>
<body>
<form method="post">

    <label for="fullName"> Input full name of department
        <input type="text" id="fullName" name="fullName">
    </label>

    <br/>
    <input type="submit" value="save department">
</form>

<br>

<table>
    <tr>
        <th>name of Department</th>
        <th>Id of department</th>
    </tr>

    <% if (request.getAttribute("departments") != null) {
        List<Department> departments = (List<Department>) request.getAttribute("departments");
        for (Department department : departments) {
    %>
    <tr>
        <td><%= department.getName() %>
        </td>
        <td><%= department.getId() %>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
<a href="/">begin</a>

</body>
</html>