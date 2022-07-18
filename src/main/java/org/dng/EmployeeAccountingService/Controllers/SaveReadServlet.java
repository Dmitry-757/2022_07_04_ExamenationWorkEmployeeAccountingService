package org.dng.EmployeeAccountingService.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dng.EmployeeAccountingService.AppContext;
import org.dng.EmployeeAccountingService.Service.SaveReadDataBase;

import java.io.IOException;

@WebServlet(name = "SaveReadServlet", value = "/SaveRead")
public class SaveReadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/SaveRead.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("save") != null){
            SaveReadDataBase.saveDB();
        }
        if (request.getParameter("read") != null){
            SaveReadDataBase.readDB();
        }

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/SaveRead.jsp");
        dispatcher.forward(request, response);
    }

}
