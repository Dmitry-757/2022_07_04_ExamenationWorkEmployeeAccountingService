<%@ page import="org.dng.EmployeeAccountingService.Entities.Department" %>
<%@ page import="java.util.List" %>
<%@ page import="org.dng.EmployeeAccountingService.Entities.Employee" %>
<%@ page import="org.dng.EmployeeAccountingService.Entities.Job" %>
<%@ page import="org.dng.EmployeeAccountingService.AppContext" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search employee</title>
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

        div .Select {
            padding-: 10px 10px 10px 10px;
        }

        div .label {
            padding-: 10px 10px 10px 10px;
        }

        label {
            padding-: 10px 10px 10px 10px;
        }
    </style>

</head>

<body>

<a style="font-size: x-large" href="/">main menu</a>
<br>
<hr>
<br>
<br/>
<a style="font-size: xx-large" href="reports.jsp">Reports</a>
<hr>
<br/>

<form method="post">

    <div class="label">
        <label> Input department of employee
            <select name="selectDepartment">
                <option value="" > </option>

                <% if (request.getAttribute("departments") != null) {
                    List<Department> departments = (List<Department>) request.getAttribute("departments");
                    for (Department department : departments) { %>
                <div class="Select">
                    <option value=<%= (department != null ? department.getId() : "-1" ) %>><%= ( department != null ? department.getName() : "") %>
                    </option>
                </div>
                <%
                        }
                    }
                %>
            </select>
        </label>
    </div>
    <br>

    <div class="label">
        <label> Input boss of employee
            <select name="selectBoss">
                <option value="" > </option>
                <% if (request.getAttribute("bosses") != null) {
                    List<Employee> bosses = (List<Employee>) request.getAttribute("bosses");
                    for (Employee boss : bosses) { %>
                        <div class="Select">
                            <option
                                value=<%= (boss != null ? boss.getId() : "-1") %>><%= (boss != null ? boss.getName() : "") %>
                            </option>
                        </div>
                <%
                        }
                    }
                %>

            </select>
        </label>
    </div>
    <br>



    <div class="label">
        <label for="fullName"> Input full name of employee
            <input type="text" id="fullName" name="fullName">
        </label>
    </div>
    <br/>


    <br/>
    <div class="label">
        <label> Input job of employee
            <select name="selectJob">
                <option value="" > </option>
                <% if (request.getAttribute("jobs") != null) {
                    List<Job> jobs = (List<Job>) request.getAttribute("jobs");
                    for (Job job : jobs) { %>
                <div class="Select">
                    <option value=<%= (job != null ? job.getId() : "-1")%>><%= (job != null ? job.getName() : "")%>
                    </option>
                </div>
                <%
                        }
                    }
                %>
            </select>
        </label>
    </div>
    <br>


    <input type="submit" name="ButtonAction" value="search">
    <input style="padding-left: 10px" type="submit" name="ButtonAction" value="ShowAll">

</form>

<%--<br>--%>
<hr>

<table>
    <tr>
        <th>Id</th>
        <th>Full name</th>
        <th>email</th>
        <th>INN</th>
        <th>Department</th>
        <th>Birth date</th>
        <th>Gender</th>
        <th>Phone number</th>
        <th>Job name</th>
        <th>Boss</th>
        <th>Date of recruiting</th>
        <th>Salary size</th>
        <th>Status</th>

    </tr>

    <% if (request.getAttribute("employees") != null) {
        List<Employee> employees = (List<Employee>) request.getAttribute("employees");
        for (Employee employee : employees) {
    %>
    <tr>
        <td><%= employee.getId() %>
        </td>
        <td><%= employee.getName() %>
        </td>
        <td><%= employee.getEmail() %>
        </td>
        <td><%= employee.getInn() %>
        </td>
        <td><%= employee.getDepartment().getName() %>
        </td>
        <td><%= employee.getBirthDate() %>
        </td>
        <td><%= employee.getGender() %>
        </td>
        <td><%= employee.getPhoneNumber() %>
        </td>
        <td><%= employee.getJob().getName() %>
        </td>
        <td><%= employee.getBossName() %>
        </td>
        <td><%= employee.getRecruitDate() %>
        </td>
        <td><%= employee.getSalary() %>
        </td>
        <td><%= employee.getStatus() %>
        </td>


    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>