/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Alumno;
import es.albarregas.beans.Ciclo;
import es.albarregas.beans.Modulo;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author paco
 */
@WebServlet(name = "EleccionTutor", urlPatterns = {"/EleccionTutor"})
public class EleccionTutor extends HttpServlet {

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
        String url = null;

        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();

        HttpSession sesion = request.getSession();

        if (request.getParameter("op").equals("actualizar") || request.getParameter("op").equals("listar")) {
            Set<Alumno> listadoAlumnos = gdao.get("Alumno");
            sesion.setAttribute("listadoAlumnos", listadoAlumnos);
        }

        if (request.getParameter("op").equals("actualizar") || request.getParameter("op").equals("alta")) {
            Set<Modulo> listadoModulos = null;
            List<Ciclo> ciclos = (ArrayList<Ciclo>) gdao.getWhere("IdCiclo = '" + request.getParameter("_idCiclo") + "'", Ciclo.class);
            Ciclo ciclo = ciclos.get(0);
            listadoModulos = ciclo.getModulos();
            sesion.setAttribute("listadoModulos", listadoModulos);
            sesion.setAttribute("cicloTutor", ciclo);
        }

        switch (request.getParameter("op")) {
            case "actualizar":
                url = "JSP/elegirAlumno.jsp";
                break;
            case "alta":
                url = "JSP/formularioRegistroTutor.jsp";
                break;
            case "borrar":
                url = "JSP/elegirAlumnoBorrar.jsp";
                break;
            case "listar":
                url = "JSP/listadoAlumnos.jsp";
                break;
            case "inicio":
                url = "JSP/subIndexTutor.jsp";
        }

        request.getRequestDispatcher(url).forward(request, response);
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
