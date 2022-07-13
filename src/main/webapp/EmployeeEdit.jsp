<%@ page import="org.dng.EmployeeAccountingService.Entities.Department" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recruit employee</title>
    <style>
        /*table {*/
        /*    border-collapse: collapse;*/
        /*    border: 2px solid rgb(200,200,200);*/
        /*    letter-spacing: 1px;*/
        /*    font-size: 0.8rem;*/
        /*}*/
        /*td, th {*/
        /*    border: 1px solid rgb(190,190,190);*/
        /*    padding: 10px 20px;*/
        /*}*/
        /*th {*/
        /*    background-color: rgb(235,235,235);*/
        /*}*/
        /*td {*/
        /*    text-align: center;*/
        /*}*/
        div .departmentsSelect{
            padding-: 10px 10px 10px 10px;
        }
        div .label{
            padding-: 10px 10px 10px 10px;
        }
        label{
            padding-: 10px 10px 10px 10px;
        }
    </style>
</head>

<body>
<form method="post">

    <div class="label">
        <label> Input department of employee
            <select name="selectDepartment">
                <%--                                <option value="male">MALE</option>--%>
                <%--                                <option value="female">FEMALE</option>--%>


                <% if (request.getAttribute("departments") != null) {
                    List<Department> departments = (List<Department>) request.getAttribute("departments");
                    for (Department department : departments) { %>
                        <div class="departmentsSelect">
                            <option value=<%= department.getId() %>> <%= department.getName() %> </option>
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
        <label for="birthDate"> Input birthDate of employee
            <input type="date" id="birthDate" name="birthDate">
        </label>
    </div>

    <br/>

    <div class="label">
        <label> Input gender of employee
            <%--                <select size="2" multiple name="sex[]">--%>
            <select name="sex[]">
                <%--                    <option disabled>Input sex of employee</option>--%>
                <option selected value="male">MALE</option>
                <option value="female">FEMALE</option>
            </select>
        </label>
    </div>
    <br/>

    <div class="label">
        <label for="phoneNumber"> Input phoneNumber of employee
            <input type="text" id="phoneNumber" name="phoneNumber">
        </label>
    </div>

    <br/>

    <div class="label">
        <label for="job"> Input job name of employee
            <input type="text" id="job" name="job">
        </label>
    </div>
    <br/>

    <div class="label">
        <label for="boss"> Input boss of employee
            <input type="text" id="boss" name="department">
        </label>
    </div>
    <br/>

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

<a href="/">begin</a>
</body>
</html>