<%-- 
    Document   : formularioRegistro
    Created on : 17 feb. 2019, 14:00:16
    Author     : paco
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../INC/metadatas.jsp" %>
        <link rel="stylesheet" type="text/css" href="../CSS/layouts/side-menu.css" />
        <title>Acceso</title>
    </head>
    <body>
        <div id="layout">
            <!-- Menu toggle -->
            <a href="#menu" id="menuLink" class="menu-link">
                <!-- Hamburger icon -->
                <span></span>
            </a>

            <div id="menu">
                <div class="pure-menu">
                    <a class="pure-menu-heading" href="#">ESR</a>

                    <ul class="pure-menu-list">
                        <li class="pure-menu-item"><a href="${contexto}/EleccionTutor?op=inicio" class="pure-menu-link">Inicio</a></li>
                        <li class="pure-menu-item">
                            <form action="${contexto}/EleccionTutor?op=actualizar" method="post">
                                <input type="hidden" name="_idUsuario" value="${idTutor}"/>
                                <input type="hidden" name="_idCiclo" value="${idCiclo}"/>
                                <input class="botonAltaAlumno" type="submit" value="Asignar Notas" class="pure-menu-link">
                            </form>
                        </li>
                        <li class="pure-menu-item">
                            <form action="${contexto}/EleccionTutor?op=alta" method="post">
                                <input type="hidden" name="_idUsuario" value="${idTutor}"/>
                                <input type="hidden" name="_idCiclo" value="${idCiclo}"/>
                                <input class="botonAltaAlumno" type="submit" value="Alta alumnos" class="pure-menu-link">
                            </form>
                        </li>
                        <li class="pure-menu-item"><a href="${contexto}/EleccionTutor?op=borrar" class="pure-menu-link">Borra alumnos</a></li>
                        <li class="pure-menu-item"><a href="${contexto}/EleccionTutor?op=listar" class="pure-menu-link">Lista alumnos</a></li>
                        <li class="pure-menu-item"><a href="${contexto}" class="pure-menu-link">Salir</a></li>
                    </ul>
                </div>
                <div>
                    <img id="logoCorporativo" src="${contexto}/IMG/logo.png" alt="logo corporativo">
                </div>
            </div>

            <div id="main">
                <div class="header">
                    <div class="pure-u-1-8">
                        <img class="pure-img-responsive" src="${contexto}/IMG/logo.png" alt="logo corporativo">
                    </div>
                    <h1>Education School Rating</h1>
                    <h2>ESR</h2>
                </div>

                <div class="content">
                    <h2 class="content-subhead">Elige un alumno para actualiar y asignar notas</h2>
                    <form method="post" action="Controlador?op=updateAlumno">
                            <table>
                                <c:forEach var="item" items="${listadoAlumnos}">
                                    <tr>
                                        <td><input type="radio" name="seleccionado" value="${item.idUsuario}" /></td>
                                        <td> ${item.nombre}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        <div class="pure-controls">
                            <button type="submit" name="enviar" class="pure-button pure-button-primary">Enviar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

