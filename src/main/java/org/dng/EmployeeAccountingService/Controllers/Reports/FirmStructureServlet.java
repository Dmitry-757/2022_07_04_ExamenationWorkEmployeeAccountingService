package org.dng.EmployeeAccountingService.Controllers.Reports;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.Entities.Department;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "FirmStructureServlet", value = "/reports/firmStructure")
public class FirmStructureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //there it needs to show all, including dismissed
        List<Department> ld = AppContext.getDepartmentService().findAll(true);
        if (ld.size()>0){
            request.setAttribute("departments", ld);
        }


        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/reports/firmStructure.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
