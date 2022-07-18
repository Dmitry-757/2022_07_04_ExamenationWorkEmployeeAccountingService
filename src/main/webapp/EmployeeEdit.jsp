<%@ page import="java.util.List" %>
<%@ page import="org.dng.EmployeeAccountingService.Entities.Department" %>
<%@ page import="org.dng.EmployeeAccountingService.Entities.Job" %>
<%@ page import="org.dng.EmployeeAccountingService.Entities.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Employee</title>
    <style>
        table {
            border-collapse: collapse;
            border: 2px solid rgb(200, 200, 200);
            letter-spacing: 1px;
            font-size: 0.8rem;
            width: 100%;
        }

        /*tr{*/
        /*    width: 100%;*/
        /*}*/
        td, th {
            border: 1px solid rgb(190, 190, 190);
            padding: 10px 20px;
            /*width: 33%;*/
        }

        th {
            background-color: rgb(235, 235, 235);
        }

        td {
            text-align: center;
        }

        .scrollingTable {
            /*width: 30em;*/
            width: 100%;
            overflow-y: auto;
        }
    </style>
    <script type="text/javascript">
        function makeTableScroll() {

            // Constant retrieved from server-side via JSP
            let maxRows = 1;

            let table = document.getElementById('myTable');
            let tableWith = table.clientWidth;
            let wrapper = table.parentNode;
            let rowsInTable = table.rows.length;
            let height = 0;
            if (rowsInTable > maxRows) {
                for (let i = 0; i < maxRows; i++) {
                    height += table.rows[i].clientHeight;
                }
                wrapper.style.height = height + "px";

                // let columnsNumber = table.rows[0].cells.length;
                // for (let j = 0; j < columnsNumber; j++) {
                //     table.rows[i].width = Math.floor(100/columnsNumber) + "%";
                // }
            }

            if (rowsInTable > maxRows){
                let tableH = document.getElementById('myTableHeader');
                let wrapperH = tableH.parentNode;
                // console.log(wrapperH.style.clientWidth);
                // let newWidth = (wrapperH.style.width - 30)+"px";
                wrapperH.style.width = (tableWith-15)+"px";// !!! need to find (((

                // let columnsNumber = tableH.rows[0].cells.length;
                // for (let j = 0; j < columnsNumber; j++) {
                //     tableH.rows[i].width = 100/columnsNumber + "%";
                // }

            }


        }
    </script>
</head>
<body onload="makeTableScroll();">
<a style="font-size: x-large" href="/">main menu</a>
<br>
<br>
<hr>
<br>

<form method="post">
<%-- date of Employee   --%>

    <div class="label">
        <label for="fullName"> Input full name of employee
            <input type="text" id="fullName" name="fullName"
                   <% String value = (request.getAttribute("fullName")!=null ? "\""+(String)request.getAttribute("fullName")+"\"":"");%>
                   value=<%= value %>
            >
        </label>
    </div>
    <br/>

    <div class="label">
        <label for="inn"> Input INN of employee
            <input type="number" id="inn" name="inn"
                   value=<%= request.getAttribute("inn")!=null ? request.getAttribute("inn"):""%>
            >
        </label>
    </div>
    <br/>

    <div class="label">
        <label for="birthDate"> Input birthDate of employee
            <input type="date" id="birthDate" name="birthDate"
                   value=<%= request.getAttribute("birthDate")!=null ? request.getAttribute("birthDate"):""%>
            >
        </label>
    </div>

    <br/>

    <div class="label">
        <label> Input gender of employee
            <%String checked="";%>
            <input type="radio" value="male"
<%--                   checked--%>
                    <% checked="";
                        if (request.getAttribute("selectedGenderId") != null){
                            int selectedSubEntityId = (int)(request.getAttribute("selectedGenderId"));
                            checked = (selectedSubEntityId == 1 ? "checked" : "");
                        }%>
                    <%=checked%>
                   name="gender"
            />MALE
            <input type="radio" value="female"
                    <% checked="";
                        if (request.getAttribute("selectedGenderId") != null){
                            int selectedSubEntityId = (int)(request.getAttribute("selectedGenderId"));
                            checked = (selectedSubEntityId == 2 ? "checked" : "");
                        }%>
                    <%=checked%>
                   name="gender"
            />FEMALE
        </label>
    </div>
    <br/>

    <div class="label">
        <label for="phoneNumber"> Input phoneNumber of employee
            <input type="text" id="phoneNumber" name="phoneNumber"
                   value=<%= request.getAttribute("phoneNumber")!=null ? request.getAttribute("phoneNumber"):""%>
            >
        </label>
    </div>
    <br/>

    <div class="label">
        <label> Input department of employee
            <select name="selectDepartment">
                <% if (request.getAttribute("departments") != null) {
                    List<Department> departments = (List<Department>) request.getAttribute("departments");
                    for (Department department : departments) { %>
                <div class="Select">
                    <option
                            value=<%= department.getId() %>
                                <% String selected="";
                                    if (request.getAttribute("selectedDepartmentId") != null){
                                        int selectedSubEntityId = (int)(request.getAttribute("selectedDepartmentId"));
                                        selected = (department.getId() == selectedSubEntityId ? "selected" : "");
                                }%>
                                <%=selected%>

                        > <%= department.getName() %>
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
        <label> Input job of employee
            <select name="selectJob">
                <% if (request.getAttribute("jobs") != null) {
                    List<Job> jobs = (List<Job>) request.getAttribute("jobs");
                    for (Job job : jobs) { %>
                <div class="Select">
                    <option
                        value=<%= job.getId() %>
                        <% String selected="";
                        if (request.getAttribute("selectedJobId") != null){
                            int selectedSubEntityId = (int)(request.getAttribute("selectedJobId"));
                            selected = (job.getId() == selectedSubEntityId ? "selected" : "");
                        }%>
                        <%=selected%>
                        > <%= job.getName() %>

                    </option>
                </div>
                <%
                        }
                    }
                %>
<%--                value=<%= request.getAttribute("phoneNumber")!=null ? request.getAttribute("phoneNumber"):""%>--%>
            </select>
        </label>
    </div>
    <br>

    <div class="label">
        <label for="recruitDate"> Input recruitDate of recruiting
            <input type="date" id="recruitDate" name="recruitDate"
                   value=<%= request.getAttribute("recruitDate")!=null ? request.getAttribute("recruitDate"):""%>
            >
        </label>
    </div>

    <br/>

    <div class="label">
        <label for="salary"> Input salary of employee
            <input type="number" id="salary" name="salary"
                   value=<%= request.getAttribute("salary")!=null ? request.getAttribute("salary"):""%>
            >
        </label>
    </div>
    <br/>

    <br/>
    <input type="submit" value="save">
</form>

<hr>
<br>

<div class="scrollingTable">
    <table  id="myTableHeader">
        <tr>
            <th style="width: 5%">Id</th>
            <th style="width: 15%">Full name</th>
            <th style="width: 7%">INN</th>
            <th style="width: 10%">Department</th>
            <th style="width: 10%">Birth date</th>
            <th style="width: 10%">Gender</th>
            <th style="width: 5%">Phone number</th>
            <th style="width: 10%">Job name</th>
            <th style="width: 5%">Boss</th>
            <th style="width: 5%">Date of recruiting</th>
            <th style="width: 5%">Salary size</th>
<%--            <th style="width: 5%">Status</th>--%>
            <th style="width: 3%">Check for edit</th>
        </tr>
<%--        <tr>--%>
<%--            <th >Id</th>--%>
<%--            <th>Full name</th>--%>
<%--            <th >INN</th>--%>
<%--            <th >Department</th>--%>
<%--            <th>Birth date</th>--%>
<%--            <th>Gender</th>--%>
<%--            <th>Phone number</th>--%>
<%--            <th>Job name</th>--%>
<%--            <th>Boss</th>--%>
<%--            <th>Date of recruiting</th>--%>
<%--            <th>Salary size</th>--%>
<%--            &lt;%&ndash;                <th>Status</th>&ndash;%&gt;--%>
<%--            <th>Check for edit</th>--%>
<%--        </tr>--%>
    </table>
</div>


<form method="post">
    <div class="scrollingTable">
        <table id="myTable">
<%--            <tr>--%>
<%--                <th >Id</th>--%>
<%--                <th>Full name</th>--%>
<%--                <th >INN</th>--%>
<%--                <th >Department</th>--%>
<%--                <th>Birth date</th>--%>
<%--                <th>Gender</th>--%>
<%--                <th>Phone number</th>--%>
<%--                <th>Job name</th>--%>
<%--                <th>Boss</th>--%>
<%--                <th>Date of recruiting</th>--%>
<%--                <th>Salary size</th>--%>
<%--&lt;%&ndash;                <th>Status</th>&ndash;%&gt;--%>
<%--                <th>Check for edit</th>--%>
<%--            </tr>--%>

            <% if (request.getAttribute("entities") != null) {
                List<Employee> entities = (List<Employee>) request.getAttribute("entities");
                int i = 0;
                for (Employee entity : entities) {
                    i++;
                    //                System.out.println("i="+i);
            %>
            <tr style="width: 460px">
                <td style="width: 5%"><%= entity.getId() %>
                </td>
                <td style="width: 17%"><%= entity.getName() %>
                </td>
                <td style="width: 7%"><%= entity.getInn() %>
                </td>
                <td style="width: 10%"><%= entity.getDepartment().getName() %>
                </td>
                <td style="width: 5%"><%= entity.getBirthDate() %>
                </td>
                <td style="width: 8%"><%= entity.getGender() %>
                </td>
                <td style="width: 8%"><%= entity.getPhoneNumber() %>
                </td>
                <td style="width: 10%"><%= entity.getJob().getName() %>
                </td>
                <td style="width: 7%"><%= entity.getBossName() %>
                </td>
                <td style="width: 3%"><%= entity.getRecruitDate() %>
                </td>
                <td style="width: 8%"><%= entity.getSalary() %>
                </td>
<%--                <td><%= entity.getStatus() %>--%>
<%--                </td>--%>
                <td style="width: 8%">
                    <input type="radio"
                           value=<%= i%>
                                   name="checkedEntity"
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
    <input type="submit" value="edit">
    <br>
</form>

</body>
</html>