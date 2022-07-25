<%@ page import="org.dng.EmployeeAccountingService.Entities.Department" %>
<%@ page import="java.util.List" %>
<%@ page import="org.dng.EmployeeAccountingService.Entities.Employee" %>
<%@ page import="org.dng.EmployeeAccountingService.Entities.Job" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recruit employee</title>
    <style>
        table {
            border-collapse: collapse;
            border: 2px solid rgb(200, 200, 200);
            letter-spacing: 1px;
            font-size: 0.8rem;
            table-layout: fixed;
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

<a style="font-size: x-large" href="/MainMenu">main menu</a>
<br>
<hr>
<br>

<form method="post">

    <div class="label">
        <label> Input department of employee
            <select name="selectDepartment">
                <% if (request.getAttribute("departments") != null) {
                    List<Department> departments = (List<Department>) request.getAttribute("departments");
                    for (Department department : departments) { %>
                <div class="Select">
                    <option value=<%= department.getId() %>><%= department.getName() %>
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

    <div class="label">
        <label for="email"> Input email of employee
            <input type="text" id="email" name="email">
        </label>
    </div>
    <br/>

    <div class="label">
        <label for="pass"> Input pass for employee
            <input type="text" id="pass" name="pass">
        </label>
    </div>
    <br/>

    <div class="label">
        <label for="inn"> Input INN of employee
            <input type="text" maxlength="9" pattern="\d{9}" id="inn" name="inn">
        </label>
    </div>
    <br/>

    <div class="label">
        <label for="birthDate"> Input birthDate of employee
            <input type="date" id="birthDate" name="birthDate">
        </label>
    </div>

    <br/>

    <div class="label">
        <label> Input gender of employee
            <input type="radio" value="male" checked name="gender"/>MALE
            <input type="radio" value="female" name="gender"/>FEMALE
        </label>
    </div>
    <br/>

    <div class="label">
        <label for="phoneNumber"> Input phoneNumber of employee
<%--            <input type="text" class="phoneNumber" maxlength="13" placeholder="+7-912-123456" id="phoneNumber"--%>
<%--                   name="phoneNumber" autocomplete="off">--%>
            <input type="text"
                   class="phoneNumber"
                   placeholder="+7-912-123456"
                   id="phoneNumber"
                   name="phoneNumber">
        </label>
    </div>

    <br/>


    <div class="label">
        <label> Input job of employee
            <select name="selectJob">
                <% if (request.getAttribute("jobs") != null) {
                    List<Job> jobs = (List<Job>) request.getAttribute("jobs");
                    for (Job job : jobs) { %>
                <div class="Select">
                    <option value=<%= job.getId() %>><%= job.getName() %>
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
        <label for="recruitDate"> Input recruitDate of recruiting
            <input type="date" id="recruitDate" name="recruitDate">
        </label>
    </div>

    <br/>

    <div class="label">
        <label for="salary"> Input salary of employee
            <input type="number" id="salary" name="salary">
        </label>
    </div>
    <br/>

    <input type="submit" value="Recruit employee">
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

<script src="https://unpkg.com/imask"></script>
<script>
    let element = document.getElementById('phoneNumber');
    let maskOptions = {
        mask: '+0-000-0000000',
        lazy: false
    }
    let mask = new IMask(element, maskOptions);

    // let element = document.getElementById('email');
    // let maskOptions = {
    //     mask: '0-000-0000000',
    //     lazy: false
    // }
    // let mask = new IMask(element, maskOptions);

</script>
</body>
</html>