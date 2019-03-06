/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.Utilities.Utilities;
import es.albarregas.beans.Alumno;
import es.albarregas.beans.Ciclo;
import es.albarregas.beans.Nota;
import es.albarregas.beans.Usuario;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.exceptions.BussinessException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paco
 */
@WebServlet(name = "Conclusion", urlPatterns = {"/Conclusion"})
public class Conclusion extends HttpServlet {

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

        List<String> retorno = new ArrayList<>();

        Usuario usuario = null;
        Ciclo ciclo = null;
        ArrayList<Ciclo> ciclos = null;
        Alumno alumno = null;

        switch (request.getParameter("op")) {
            case "updateAlumno":
                
                alumno = (Alumno) gdao.getById(Integer.parseInt(request.getParameter("idUsuario")), Alumno.class);
                
                //usuario = new Usuario();
                alumno.setNombre(request.getParameter("nombre"));
                alumno.setApellidos(request.getParameter("apellidos"));
                alumno.setNif(request.getParameter("dni"));
                alumno.setEmail(request.getParameter("email"));
                alumno.setRepitePassword(alumno.getPassword());
                
                //recorrer las notas e insertarlas en el listado de notas del bean alumno
                    List<Nota> listaDeNotas = new ArrayList<>();
                    Map notas = request.getParameterMap();
                    System.out.println("Estas son las notas: "+notas);
                    Iterator<Map.Entry<String, String>> it = notas.entrySet().iterator();
                    /*while (it.hasNext()) {
                        Map.Entry<String, String> pair = it.next();
                        if (pair.getKey().startsWith("modulo_")) {
                            Nota n = new Nota();
                            n.setAlumno(alumno);
                            //n.setModulo(modulo);
                            n.getNota();
                        }
                    }*/
                
                try {
                    /*
                    gdao.update(usuarop);
                    gdao.update(nota);
                    */
                    gdao.insertOrUpdate(alumno);
                } catch (BussinessException be) {
                    retorno.add(Utilities.procesarBussinessException(be));
                } finally {
                    request.setAttribute("error", retorno);
                    url = "JSP/subIndexTutor.jsp";
                }
                break;
            case "updateTutor":
                /*try {
                    gdao.insertOrUpdate(///);
                } catch (BussinessException be) {
                    retorno.add(Utilities.procesarBussinessException(be));
                } finally {
                    request.setAttribute("error", retorno);
                    url = "JSP/subIndexAdmin.jsp";
                }*/
                break;
            case "AlumnoActualizar":
                alumno = (Alumno) gdao.getById(Integer.parseInt(request.getParameter("idUsuario")), Alumno.class);
                
                //usuario = new Usuario();
                alumno.setNombre(request.getParameter("nombre"));
                alumno.setApellidos(request.getParameter("apellidos"));
                alumno.setNif(request.getParameter("dni"));
                alumno.setEmail(request.getParameter("email"));
                try {
                    gdao.insertOrUpdate(alumno);
                } catch (BussinessException be) {
                    retorno.add(Utilities.procesarBussinessException(be));
                } finally {
                    request.setAttribute("error", retorno);
                    url = "JSP/subIndexAlumno.jsp";
                }
                break;
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
