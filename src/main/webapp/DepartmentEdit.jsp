<%@ page import="java.util.List" %>
<%@ page import="org.dng.EmployeeAccountingService.Entities.Department" %>
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
            width: 460px;
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

            if (rowsInTable > maxRows){
                let tableH = document.getElementById('myTableHeader');
                let wrapperH = tableH.parentNode;
                // console.log(wrapperH.style.clientWidth);
                // let newWidth = wrapperH.style.width - 30;
                wrapperH.style.width = "442px";
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

    <label for="fullName"> Input name of department
        <input style="margin-left: 10px;" type="text" id="fullName" name="fullName"
               value=<%= request.getAttribute("fullName")!=null ? request.getAttribute("fullName"):""%>>
    </label>

    <br/>
    <input type="submit" value="save">
</form>

<hr>
<br>

<div class="scrollingTable">
<table  id="myTableHeader">
    <tr>
        <th >Name of Job</th>
        <th >Id</th>
        <th >Check for edit</th>
    </tr>
</table>
</div>


<form method="post">
    <div class="scrollingTable">
        <table id="myTable">
<%--            <tr>--%>
<%--                <th>Name of Job</th>--%>
<%--                <th>Id</th>--%>
<%--                <th>Check for edit</th>--%>
<%--            </tr>--%>

            <% if (request.getAttribute("entities") != null) {
                List<Department> entities = (List<Department>) request.getAttribute("entities");
                int i = 0;
                for (Department entity : entities) {
                    i++;
                    //                System.out.println("i="+i);
            %>
            <tr style="width: 460px">
                <td><%= entity.getName() %>
                </td>
                <td><%= entity.getId() %>
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
    <input type="submit" value="edit">
    <br>
</form>

</body>
</html>