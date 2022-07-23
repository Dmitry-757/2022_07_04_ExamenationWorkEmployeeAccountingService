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
            width: 100%;
        }

        td, th {
            border: 1px solid rgb(190, 190, 190);
            padding: 10px 20px;
            width: 33%;
        }

        th {
            background-color: rgb(235, 235, 235);
            /*width: 33%;*/
        }

        td {
            text-align: center;
        }
        .myTable{
            overflow-y: auto;
            height: 150px;
            width: 460px;
        }
        .myTableHeader{
            /*height: 200px;*/
            width: 460px;
        <%
            int width=460;
            if (request.getAttribute("jobs") != null) {
                        List<Job> jobs = (List<Job>) request.getAttribute("jobs");
                        if (jobs.size()>=4){
                            width=445;
                        }
                }
        %>
            width: <%= width%>;
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
<%--        <input style="margin-left: 10px;" type="text" id="fullName" name="fullName" value=<%= request.getAttribute("fullName")%>>--%>
        <input style="margin-left: 10px;" type="text" id="fullName" name="fullName" value=<%= request.getAttribute("fullName")!=null ? request.getAttribute("fullName"):""%>>
    </label>

    <br/>
    <input type="submit" value="save job">
</form>

<hr>
<br>

<div class="myTableHeader">
<table>
    <tr>
        <th>Name of Job</th>
        <th>Id </th>
        <th>Deprecated </th>
        <th>Check for edit </th>
    </tr>
</table>
</div>
<form method="post">
    <div class="myTable">
    <table>
<%--        <tr>--%>
<%--            <th>Name of Job</th>--%>
<%--            <th>Id </th>--%>
<%--            <th>Check for edit </th>--%>
<%--        </tr>--%>

        <% if (request.getAttribute("jobs") != null) {
            List<Job> jobs = (List<Job>) request.getAttribute("jobs");
            int i = 0;
            for (Job job : jobs) {
                i++;
//                System.out.println("i="+i);
        %>
                <tr>
                    <td><%= job.getName() %>
                    </td>
                    <td><%= job.getId() %>
                    </td>
                    <td><%=( job.isDeprecated() ? "Deprecated" : "")%>
                    </td>

                    <td>
                        <input type="radio"
                               value=<%= i%>
                               name="checkedJob"
                               >
                    </td>
                </tr>
        <%
                }
            }
        %>
    </table>
    </div>
    <br>
    <input type="submit" name="buttonAction" value="edit">
    <input type="submit" name="buttonAction" value="dismiss">

    <br>
</form>

</body>
</html>