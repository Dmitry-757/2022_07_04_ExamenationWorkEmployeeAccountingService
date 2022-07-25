<%@ page import="org.dng.EmployeeAccountingService.Entities.Department" %>
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
<h1>Average salary</h1>
<br>
<a style="font-size: x-large" href="/MainMenu">main menu</a>
<br>
<a style="font-size: xx-large" href="reports.jsp">Reports</a>
<%--<a style="font-size: xx-large" href="reports.jsp">Reports</a>--%>
<br>
<hr>
<br>


<b>Company average salary is <%= AppContext.getEmployeeService().getSummaryStatistics().getAverage()%> </b><br>
<b>Max salary in company is <%= AppContext.getEmployeeService().getSummaryStatistics().getMax()%> </b><br>
<b>Min salary in company is <%= AppContext.getEmployeeService().getSummaryStatistics().getMin()%> </b><br>
<b>Total salary expenses in company is <%= AppContext.getEmployeeService().getSummaryStatistics().getSum()%> </b><br>
<br>


<table>
    <%--    header--%>
    <tr>
        <th>Department</th>
        <th>Boss</th>
        <th>Employee</th>
        <th>Average Salary</th>
        <th>Total Sum</th>
    </tr>

    <%--    table--%>
    <% List<Department> entities = AppContext.getDepartmentService().findAll(true);
        for (Department entity : entities) {
    %>

    <%--    about department--%>
        <tr>
            <td><%= entity.getName() %>
            </td>
            <td><%=( entity.getBoss()!=null ? entity.getBoss().getName() : "")%>
            </td>
            <td> </td>
            <td> <%=AppContext.getDepartmentService().getSummaryStatistics(entity).getAverage()%>></td>
            <td> <%=AppContext.getDepartmentService().getSummaryStatistics(entity).getSum()%>></td>
        </tr>
        <% List<Employee> subEntities = AppContext.getEmployeeService().findEmployee(entity);
            for (Employee subEntity : subEntities) {
        %>
        <%--            body of subloop--%>
        <tr>
            <td> </td>
            <td> </td>
            <td> <%=subEntity.getName() %></td>
            <td> <%=subEntity.getSalary() %></td>
            <td> </td>

        </tr>

        <%
            }
        %>

    <%
        }
    %>


</table>


</body>
</html>
