<%@ page import="java.util.List" %>
<%@ page import="org.dng.EmployeeAccountingService.Entities.Department" %>
<%@ page import="org.dng.EmployeeAccountingService.Entities.Job" %>
<%@ page import="org.dng.EmployeeAccountingService.Entities.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
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
            table-layout: fixed;
        }

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
            /*width: 100%;*/
            overflow-y: auto;
        }
    </style>
    <script type="text/javascript">
        function makeTableScroll() {

            // Constant retrieved from server-side via JSP
            let maxRows = 3;

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

            }
            // console.log("tableWith="+tableWith);

            if (rowsInTable > maxRows){

                let tableH = document.getElementById('myTableHeader');
                let tableHWith = tableH.clientWidth;
                let wrapperH = tableH.parentNode;
                // console.log("tableHWith = "+tableHWith);

                wrapperH.style.width = (tableHWith-17)+"px";// !!! need to find (((
                // console.log("tableH.clientWidth = "+tableH.clientWidth);

                // let columnsNumber = tableH.rows[0].cells.length;
                // for (let j = 0; j < columnsNumber; j++) {
                //       //table.rows[j].style.width = "20px";
                //         // headerEtalon.rows[j].width;
                // }

            }
        }
    </script>
</head>
<body onload="makeTableScroll();">
<%--<body>--%>
<a style="font-size: x-large" href="/MainMenu">main menu</a>
<br>
<br>
<hr>
<br>

<form method="post">
<%-- date of Employee   --%>

    <div class="label">
        <label for="fullName"> Input full name of employee
            <input type="text" id="fullName" name="fullName"
                   <% String fullNameValue = (request.getAttribute("fullName")!=null ? "\""+(String)request.getAttribute("fullName")+"\"":"");%>
                   value=<%= fullNameValue %>
            >
        </label>
    </div>
    <br/>

    <div class="label">
        <label for="email"> Input email of employee
            <input type="text" id="email" name="email"
                <% String emailValue = (request.getAttribute("email")!=null ? "\""+(String)request.getAttribute("email")+"\"":"");%>
                   value=<%= emailValue %>
            >
        </label>
    </div>
    <br/>

    <div class="label">
        <label for="pass"> Input pass of employee
            <input type="text" id="pass" name="pass"
            >
        </label>
    </div>
    <br/>

    <div class="label">
        <label for="inn"> Input INN of employee
            <input type="text" maxlength="9" pattern="\d{9}" id="inn" name="inn"
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
            <input type="text"
                   id="phoneNumber"
                   name="phoneNumber"
                   placeholder="+7-912-123456"
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
            <input type="text" id="salary" name="salary"
                   value=<%= request.getAttribute("salary")!=null ? request.getAttribute("salary"):""%>
            >
        </label>
    </div>
    <br/>


    <div class="label">
        <label> Input status of employee
            <%String checked2="";%>
            <input type="radio" value="deprecated"
            <%--                   checked--%>
                    <% checked2="";
                        if (request.getAttribute("selectDeprecatedId") != null){
                            int selectedSubEntityId = (int)(request.getAttribute("selectDeprecatedId"));
                            checked2 = (selectedSubEntityId == 1 ? "checked" : "");
                        }%>
                    <%=checked2%>
                   name="selectDeprecatedId"
            />Dismissed
            <input type="radio" value="active"
                    <% checked2="";
                        if (request.getAttribute("selectDeprecatedId") != null){
                            int selectedSubEntityId = (int)(request.getAttribute("selectDeprecatedId"));
                            checked2 = (selectedSubEntityId == 2 ? "checked" : "");
                        }%>
                    <%=checked2%>
                   name="selectDeprecatedId"
            />Active
        </label>
    </div>
    <br/>



    <br/>
    <input type="submit" name="buttonaction" value="save">
</form>

<hr>
<br>

<div class="scrollingTable">
    <table  id="myTableHeader">
        <tr>
                <th class="clmn_1">Id</th>
                <th class="clmn_2">Full name</th>
                <th class="clmn_3">email</th>
                <th class="clmn_4">INN</th>
                <th class="clmn_5">Department</th>
                <th class="clmn_6">Birth date</th>
                <th class="clmn_7">Gender</th>
                <th class="clmn_8">Phone number</th>
                <th class="clmn_9">Job name</th>
                <th class="clmn_10">Boss</th>
                <th class="clmn_11">Date of recruiting</th>
                <th class="clmn_12">Salary size</th>
                <th class="clmn_13">Status</th>
                <th class="clmn_14">Check for edit</th>
        </tr>
    </table>
</div>


<form method="post">
    <div class="scrollingTable">
        <table id="myTable">
<%--            <tr id="headerIn" style="visibility: collapse">--%>
<%--                <th >Id</th>--%>
<%--                <th >Full name</th>--%>
<%--                <th >email</th>--%>
<%--                <th >INN</th>--%>
<%--                <th >Department</th>--%>
<%--                <th >Birth date</th>--%>
<%--                <th >Gender</th>--%>
<%--                <th >Phone number</th>--%>
<%--                <th >Job name</th>--%>
<%--                <th >Boss</th>--%>
<%--                <th >Date of recruiting</th>--%>
<%--                <th >Salary size</th>--%>
<%--                &lt;%&ndash;            <th style="width: 5%">Status</th>&ndash;%&gt;--%>
<%--                <th >Check for edit</th>--%>
<%--            </tr>--%>

            <% if (request.getAttribute("entities") != null) {
                List<Employee> entities = (List<Employee>) request.getAttribute("entities");
                int i = 0;
                for (Employee entity : entities) {
                    i++;
            %>

            <tr >
                <td class="clmn_1"><%= entity.getId() %>
                </td>
                <td class="clmn_2"><%= entity.getName() %>
                </td>
                <td class="clmn_3"><%= entity.getEmail() %>
                </td>
                <td class="clmn_4"><%= entity.getInn() %>
                </td>
                <td class="clmn_5"><%= entity.getDepartment().getName() %>
                </td>
                <td class="clmn_6"><%= entity.getBirthDate() %>
                </td>
                <td class="clmn_7"><%= entity.getGender() %>
                </td>
                <td sclass="clmn_8"><%= entity.getPhoneNumber() %>
                </td>
                <td sclass="clmn_9"><%= entity.getJob().getName() %>
                </td>
                <td sclass="clmn_10"><%= entity.getBossName() %>
                </td>
                <td class="clmn_11"><%= entity.getRecruitDate() %>
                </td>
                <td class="clmn_12"><%= entity.getSalary() %>
                </td>
                <td class="clmn_13"><%= entity.getStatus() %>
                </td>
                <td class="clmn_14">
                    <input type="radio"
                           value=<%= entity.getId()%>
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
    <input type="submit" name="buttonaction" value="edit">
<%--    <input type="submit" name="buttonaction" value="dismiss">--%>
    <br>
</form>

<script src="https://unpkg.com/imask"></script>
<script>
    let element = document.getElementById('phoneNumber');
    let maskOptions = {
        mask: '+0-000-0000000',
        lazy: false
    }
    let mask = new IMask(element, maskOptions);
</script>

</body>
</html>