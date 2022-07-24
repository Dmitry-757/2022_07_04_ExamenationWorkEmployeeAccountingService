<%@ page import="java.util.List" %>
<%@ page import="org.dng.EmployeeAccountingService.Entities.Employee" %>
<%@ page import="org.dng.EmployeeAccountingService.AppContext" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Most loyal employees</title>
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
<h1>Top 10 most loyal employees</h1>
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
        <th>Recruit date</th>
        <th>Dismiss date</th>
        <th>duration of work</th>
    </tr>

    <%--    table--%>
    <% List<Employee> entities = AppContext.getEmployeeService().getTopLoyalEmployee(true);
        for (Employee entity : entities) {
    %>

    <%--    about department--%>
    <tr>
        <td><%= entity.getName() %> </td>
        <td> <%=entity.getRecruitDate()%>></td>
        <td> <%=entity.getDismissDate()%>></td>
        <td> <%=AppContext.getEmployeeService().getWorkDuration(entity)%>></td>
    </tr>

    <%
        }
    %>


</table>


</body>
</html>
