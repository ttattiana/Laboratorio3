/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servelt;

import co.edu.unipiloto.entitys.Student;
import co.edu.unipiloto.session.StudentFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "Student_servelt", urlPatterns = {"/Student_servelt"})
public class Student_servelt extends HttpServlet {

    @EJB
    private StudentFacadeLocal studentFacade;
    private Student student;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); 
        String idstr = request.getParameter("studentId");
        int id = Integer.parseInt(idstr);
        String firtsnamestr = request.getParameter("firstName");
        String lastsnamestr = request.getParameter("lastName");
        String yearlevelstr = request.getParameter("yearLevel");
        int year = Integer.parseInt(yearlevelstr);
        request.getParameter("action");
        student = new Student (id,firtsnamestr,lastsnamestr,year); 
        studentFacade.create(student);
        response.setContentType("text/html;charset=UTF-8");
        
        request.setAttribute("student", student);
        request.setAttribute("allStudents", studentFacade.findAll());
        request.getRequestDispatcher("studentInfo.jsp").forward (request,response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
