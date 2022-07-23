<%@ page import="java.util.List" %>
<%@ page import="org.dng.EmployeeAccountingService.Entities.Employee" %>
<%@ page import="org.dng.EmployeeAccountingService.AppContext" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Firm Structure</title>
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
<h1>Top 10 most expensive employees</h1>
<br>
<a style="font-size: x-large" href="/">main menu</a>
<br>
<a style="font-size: xx-large" href="reports.jsp">Reports</a>
<%--<a style="font-size: xx-large" href="reports.jsp">Reports</a>--%>
<br>
<hr>
<br>


<br>


<table>
    <%--    header--%>
    <tr>
        <th>Employee</th>
        <th>Salary</th>
    </tr>

    <%--    table--%>
    <% List<Employee> entities = AppContext.getEmployeeService().getTopExpensiveEmployee(true);
        for (Employee entity : entities) {
    %>

    <%--    about department--%>
    <tr>
        <td><%= entity.getName() %> </td>
        <td> <%=entity.getSalary()%>></td>
    </tr>

    <%
        }
    %>


</table>


</body>
</html>
