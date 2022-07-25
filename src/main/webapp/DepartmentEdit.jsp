<%@ page import="java.util.List" %>
<%@ page import="org.dng.EmployeeAccountingService.Entities.Department" %>
<%@ page import="org.dng.EmployeeAccountingService.Entities.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Department</title>
    <style>
        table {
            border-collapse: collapse;
            border: 2px solid rgb(200, 200, 200);
            letter-spacing: 1px;
            font-size: 0.8rem;
            width: 100%;
            table-layout: fixed;
        }

        /*tr{*/
        /*    width: 100%;*/
        /*}*/
        td, th {
            border: 1px solid rgb(190, 190, 190);
            padding: 10px 20px;
            width: 33%;
        }

        th {
            background-color: rgb(235, 235, 235);
        }

        td {
            text-align: center;
        }

        .scrollingTable {
            /*width: 30em;*/
            width: 550px;
            overflow-y: auto;
        }
    </style>
    <script type="text/javascript">
        function makeTableScroll() {

            // Constant retrieved from server-side via JSP
            let maxRows = 5;

            let table = document.getElementById('myTable');
            let wrapper = table.parentNode;
            let rowsInTable = table.rows.length;
            let height = 0;
            if (rowsInTable > maxRows) {
                for (let i = 0; i < maxRows; i++) {
                    height += table.rows[i].clientHeight;
                }
                wrapper.style.height = height + "px";
            }

            // if (rowsInTable > maxRows){
            //     let tableH = document.getElementById('myTableHeader');
            //     let wrapperH = tableH.parentNode;
            //     wrapperH.style.width = "442px";
            // }
            if (rowsInTable > maxRows){
                let tableH = document.getElementById('myTableHeader');
                let tableHWith = tableH.clientWidth;
                let wrapperH = tableH.parentNode;
                wrapperH.style.width = (tableHWith-17)+"px";// !!! need to find (((
            }


        }
    </script>
</head>
<body onload="makeTableScroll();">
<a style="font-size: x-large" href="/MainMenu">main menu</a>
<br>
<br>
<hr>
<br>

<form method="post">

    <label for="fullName"> Input name of department
        <input style="margin-left: 10px;" type="text" id="fullName" name="fullName"
               value=<%= request.getAttribute("fullName")!=null ? request.getAttribute("fullName"):""%>>
    </label>
    <br><br>

    <div class="label">
        <label> Input status of department
            <%String checked="";%>
            <input type="radio" value="deprecated"
            <%--                   checked--%>
                    <% checked="";
                        if (request.getAttribute("selectDeprecatedId") != null){
                            int selectedSubEntityId = (int)(request.getAttribute("selectDeprecatedId"));
                            checked = (selectedSubEntityId == 1 ? "checked" : "");
                        }%>
                    <%=checked%>
                   name="selectDeprecatedId"
            />Deprecated
            <input type="radio" value="active"
                    <% checked="";
                        if (request.getAttribute("selectDeprecatedId") != null){
                            int selectedSubEntityId = (int)(request.getAttribute("selectDeprecatedId"));
                            checked = (selectedSubEntityId == 2 ? "checked" : "");
                        }%>
                    <%=checked%>
                   name="selectDeprecatedId"
            />Active
        </label>
    </div>
    <br/>


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
                            <% String selected="";
                                    if (request.getAttribute("selectedBossId") != null){
                                        int selectedSubEntityId = (int)(request.getAttribute("selectedBossId"));
                                        selected = (boss.getId() == selectedSubEntityId ? "selected" : "");
                                }%>
                            <%=selected%>

                > <%= boss.getName() %>
                </option>
            </div>
            <%
                    }
                }
            %>
        </select>
    </label>

    <br>
    <br>
    <input type="submit" name="buttonAction" value="save">
</form>

<hr>
<br>

<div class="scrollingTable">
<table  id="myTableHeader">
    <tr>
        <th >Name of Job</th>
        <th >Id</th>
        <th >Boss</th>
        <th >Deprecated</th>
        <th >Check for edit</th>
    </tr>
</table>
</div>


<form method="post">
    <div class="scrollingTable">
        <table id="myTable">

            <% if (request.getAttribute("entities") != null) {
                List<Department> entities = (List<Department>) request.getAttribute("entities");
                int i = 0;
                for (Department entity : entities) {
                    i++;
            %>
            <tr style="width: 460px">
                <td><%= entity.getName() %>
                </td>
                <td><%= entity.getId() %>
                </td>
                <td><%=( entity.getBoss()!=null ? entity.getBoss().getName() : "")%>
                </td>
                <td><%=( entity.isDeprecated() ? "Deprecated" : "")%>
                </td>
                <td>
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
    <input type="submit" name="buttonAction" value="edit">
<%--    <input type="submit" name="buttonAction" value="dismiss">--%>
    <br>
</form>

</body>
</html>