/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.Utilities.Utilities;
import es.albarregas.beans.Alumno;
import es.albarregas.beans.Ciclo;
import es.albarregas.beans.Tutor;
import es.albarregas.beans.Usuario;
import es.albarregas.beans.Usuario.Rol;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.exceptions.BussinessException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

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

        Usuario usuario;
        Ciclo ciclo;

        switch (request.getParameter("op")) {
            case "acceso":
                usuario = new Usuario();
                usuario.setEmail(request.getParameter("email"));
                usuario.setPassword(request.getParameter("password"));

                List<Usuario> usuariosLogin;
                usuariosLogin = (List<Usuario>) gdao.getWhere("Email='" + request.getParameter("email") + "'", Usuario.class);

                for (Usuario user : usuariosLogin) {
                    System.out.println(user.getRol());
                    if (user != null) {
                        if (user.getRol().equals(Rol.ADMINISTRADOR)) {
                            url = "JSP/subIndexAdmin.jsp";
                        } else if (user.getRol().equals(Rol.TUTOR)) {
                            url = "JSP/subIndexTutor.jsp";
                        } else {
                            url = "JSP/subIndexAlumno.jsp";
                        }
                    }
                }
                break;
            case "addTutor":
                String cicloForm = request.getParameter("ciclo");
                String[] parts = cicloForm.split("/");
                String id = parts[0];
                String abreviatura = parts[1];
                String horas = parts[2];
                String ley = parts[3];
                String nombre = parts[4];

                Tutor tutor = new Tutor();
                ciclo = new Ciclo();

                ciclo.setIdCiclo(id);
                ciclo.setAbreviatura(abreviatura);
                ciclo.setHorasFCT(Integer.parseInt(horas));
                ciclo.setLey(ley);
                ciclo.setNombre(nombre);

                tutor.setNombre(request.getParameter("nombre"));
                tutor.setApellidos(request.getParameter("apellidos"));
                tutor.setNif(request.getParameter("dni"));
                tutor.setCiclo(ciclo);
                tutor.setRol(Rol.TUTOR);
                tutor.setPassword(request.getParameter("password"));
                tutor.setRepitePassword(request.getParameter("rpassword"));
                tutor.setEmail(request.getParameter("email"));
                tutor.setUltimoAcceso(new Date());

                try {
                    gdao.insertOrUpdate(tutor);
                } catch (BussinessException be) {
                    retorno.add(Utilities.procesarBussinessException(be));
                } finally {
                    request.setAttribute("error", retorno);
                    url = "JSP/subIndexAdmin.jsp";
                }
                break;
            case "addAlumno":
                String cicloFormAlum = request.getParameter("ciclo");
                String[] parts1 = cicloFormAlum.split("/");
                String id1 = parts1[0];
                String abreviatura1 = parts1[1];
                String horas1 = parts1[2];
                String ley1 = parts1[3];
                String nombre1 = parts1[4];

                Alumno alumno = new Alumno();
                ciclo = new Ciclo();
                try {
                    ciclo.setIdCiclo(id1);
                    ciclo.setAbreviatura(abreviatura1);
                    ciclo.setHorasFCT(Integer.parseInt(horas1));
                    ciclo.setLey(ley1);
                    ciclo.setNombre(nombre1);
                    
                    alumno.setRol(Rol.ALUMNO);
                    alumno.setCiclo(ciclo);
                    alumno.setNombre(request.getParameter("nombre"));
                    alumno.setApellidos(request.getParameter("apellidos"));
                    alumno.setNif(request.getParameter("dni"));
                    alumno.setPassword(request.getParameter("password"));
                    alumno.setRepitePassword(request.getParameter("rpassword"));
                    alumno.setEmail(request.getParameter("email"));
                    alumno.setUltimoAcceso(new Date());
                    alumno.setGenero(request.getParameter("genero"));
                    
                    //Se pasa a Date la fecha recibida y después se pasa a Calendar con el método setTime()                    
                    String s = request.getParameter("fechanacimiento");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                    Date dateBorn = sdf.parse(s);
                    alumno.setFechaNacimiento(dateBorn);
                    
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                try {
                    gdao.insertOrUpdate(alumno);
                } catch (BussinessException be) {
                    retorno.add(Utilities.procesarBussinessException(be));
                } finally {
                    request.setAttribute("error", retorno);
                    url = "JSP/subIndexTutor.jsp";
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
