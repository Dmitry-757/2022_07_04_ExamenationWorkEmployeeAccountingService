<%@ page import="java.util.List" %>
<%@ page import="org.dng.EmployeeAccountingService.Entities.Job" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add job</title>
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
<a style="font-size: x-large" href="/">main menu</a>
<br>
<br>
<hr>
<br>

<form method="post">

    <label for="fullName"> Input full name of job
        <input style="margin-left: 10px;" type="text" id="fullName" name="fullName">
    </label>

    <br/>
    <input type="submit" value="save job">
</form>

<hr>
<br>

    <table>
        <tr>
            <th>Name of Job</th>
            <th>Id </th>
        </tr>

        <% if (request.getAttribute("jobs") != null) {
            List<Job> jobs = (List<Job>) request.getAttribute("jobs");
            for (Job job : jobs) {
        %>
        <tr>
            <td><%= job.getName() %>
            </td>
            <td><%= job.getId() %>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>