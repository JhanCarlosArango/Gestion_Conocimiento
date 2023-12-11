/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package SV_protocolo;

import DOA.DAO_Fuseki;
import Modelo.Data_RDF;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author parko
 */
public class SV_fuseki extends HttpServlet {

    DAO_Fuseki MEM;

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
        System.out.println("holaaa");

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
    //System.out.println(MEM.Maestro_Estudiante_Modalidad("d").toString());
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
        //processRequest(request, response);
        String Modalidad_MEM = (String) request.getParameter("MEM_");
        String Modalidad_CEMM = (String) request.getParameter("CEMM_");
        String Modalidad_DM = (String) request.getParameter("DM_");
        String Modalidad_PY = (String) request.getParameter("PY_");
        MEM = new DAO_Fuseki();

        HttpSession Session_act = request.getSession();

        Session_act.setAttribute("MEM", MEM.Maestro_Estudiante_Modalidad(Modalidad_MEM));
        Session_act.setAttribute("CEMM", MEM.Cant_Estudiante_Materia_Modalidad(Modalidad_CEMM));
        Session_act.setAttribute("DM", MEM.Docente_Modalidad(Modalidad_DM));
        Session_act.setAttribute("T", MEM.Tripes());
        Session_act.setAttribute("C", MEM.Classs());
        Session_act.setAttribute("PY", MEM.Proyecto_profesor(Modalidad_PY));

        response.sendRedirect("Index.jsp");
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
