<%-- 
    Document   : index.jsp
    Created on : 14 feb. 2019, 20:48:09
    Author     : paco
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contexto" scope="application" value="${pageContext.request.contextPath}" />
<c:set var="estilos" scope="application" value="/CSS/layouts/side-menu.css" />
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../INC/metadatas.jsp" %>
        <link rel="stylesheet" type="text/css" href="../CSS/layouts/side-menu.css" />
        <title>Lista notas</title>
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
                    <a class="pure-menu-heading" href="#">ALUMNO</a>

                    <ul class="pure-menu-list">
                        <li class="pure-menu-item"><a href="${contexto}" class="pure-menu-link">Inicio</a></li>
                        <li class="pure-menu-item"><a href="${contexto}/EleccionAlumno?op=actualizar" class="pure-menu-link">Actualizar</a></li>
                        <li class="pure-menu-item  menu-item-divided pure-menu-selected"><a href="${contexto}/EleccionAlumno?op=listar" class="pure-menu-link">Lista notas</a></li>
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
                <center>
                    <div class="content">
                        <table class="pure-table pure-table-horizontal">
                            <thead>
                                <tr>
                                    <th>Módulo</th>
                                    <th>Nota</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach var="nota" items="${listadoNotas}">
                                    <tr>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </center>
            </div>
        </div>
    </body>
</html>
