<%@ page import="org.dng.EmployeeAccountingService.Entities.Department" %>
<%@ page import="org.dng.EmployeeAccountingService.Entities.Employee" %>
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
<a style="font-size: x-large" href="/">main menu</a>
<br>
<br>
<hr>
<br>

<form method="post">

    <label for="fullName"> Input full name of department
        <input style="margin-left: 10px;" type="text" id="fullName" name="fullName">
    </label>
    <br>
    <br>

    <label for="fullName"> Select a boss of the department
        <select name="selectBoss">
            <% if (request.getAttribute("bosses") != null) {
                %>
                <div class="Select">
                    <option value="-1" > </option>
                </div>
            <%
                List<Employee> bosses = (List<Employee>) request.getAttribute("bosses");
                for (Employee boss : bosses) { %>
            <div class="Select">
                <option
                        value=<%= boss.getId() %>
                > <%= boss.getName() %>
                </option>
            </div>
            <%
                    }
                }
            %>
        </select>
    </label>

    <br/>
    <input type="submit" value="save department">
</form>

<hr>
<br>

<table>
    <tr>
        <th>name of Department</th>
        <th>Id of department</th>
        <th>Boss of department</th>
    </tr>

    <% if (request.getAttribute("departments") != null) {
        List<Department> entities = (List<Department>) request.getAttribute("departments");
        for (Department entity : entities) {
    %>
    <tr>
        <td><%= entity.getName() %>
        </td>
        <td><%= entity.getId() %>
        </td>
        <td><%=( entity.getBoss()!=null ? entity.getBoss().getName() : "")%>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>


</body>
</html>