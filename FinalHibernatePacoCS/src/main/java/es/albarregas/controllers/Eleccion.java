/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.Utilities.Utilities;
import es.albarregas.beans.Administrador;
import es.albarregas.beans.Usuario;
import es.albarregas.beans.Usuario.Rol;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.exceptions.BussinessException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paco
 */
@WebServlet(name = "Eleccion", urlPatterns = {"/Eleccion"})
public class Eleccion extends HttpServlet {

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
        List<String> retorno = new ArrayList<>();

        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();

        switch (request.getParameter("op")) {
            case "acceso":
                url = "JSP/formularioAcceso.jsp";
                break;
            /*case "registro": //este case, sirve para insertar usuarios a pelo, hay que descomentar en el index el enlace de registro y funcionará
                Administrador usuario = new Administrador(
                        true,
                        "finalhib@gmail.com",
                        "123",
                        "123",
                        "Admin",
                        "Admin",
                        Rol.ADMINISTRADOR,
                        "00001234S",
                        new Date()
                );
                try {
                    gdao.insertOrUpdate(usuario);
                } catch (BussinessException be) {
                    retorno.add(Utilities.procesarBussinessException(be));
                } finally {
                    request.setAttribute("error", retorno);
                    url = "index.jsp";
                }
                break;*/
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
