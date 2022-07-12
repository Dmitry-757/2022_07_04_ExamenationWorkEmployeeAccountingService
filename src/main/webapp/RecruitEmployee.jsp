<%@ page import="org.dng.EmployeeAccountingService.Entities.Department" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recruit employee</title>
    <form method="post">

        <label> Input department of employee
            <select name="selectDepartment">
                <%--                <option value="male">MALE</option>--%>
                <%--                <option value="female">FEMALE</option>--%>


                <% if(request.getAttribute("departments")!=null){
                    List<Department> departments = (List<Department>) request.getAttribute("departments");
                    for (Department department : departments){ %>
                <%--                        <option value=<%= department.getId() %><%= department.getName() %></option>--%>
                <option value=<%= department.getId() %>> <%= department.getName() %> </option>
                <%}
                }%>
            </select>
        </label>
        <br>

        <label for="fullName"> Input full name of employee
            <input type="text" id="fullName" name="fullName">
        </label>

        <br/>

        <label for="birthDate"> Input birthDate of employee
            <input type="date" id="birthDate" name="birthDate">
        </label>

        <br/>

        <label> Input sex of employee
            <%--                <select size="2" multiple name="sex[]">--%>
            <select name="sex[]">
                <%--                    <option disabled>Input sex of employee</option>--%>
                <option selected value="male">MALE</option>
                <option value="female">FEMALE</option>
            </select>
        </label>

        <br/>

        <label for="phoneNumber"> Input phoneNumber of employee
            <input type="text" id="phoneNumber" name="phoneNumber">
        </label>

        <br/>

        <label for="job"> Input job name of employee
            <input type="text" id="job" name="job">
        </label>

        <br/>

        <label for="boss"> Input boss of employee
            <input type="text" id="boss" name="department">
        </label>

        <br/>

        <label for="recruitDate"> Input recruitDate of recruiting
            <input type="date" id="recruitDate" name="recruitDate">
        </label>

        <br/>

        <label for="salary"> Input salary of employee
            <input type="number" id="salary" name="salary">
        </label>

        <br/>


        <input type="submit" value="Recruit employee">
    </form>

</head>
<body>

</body>
</html>