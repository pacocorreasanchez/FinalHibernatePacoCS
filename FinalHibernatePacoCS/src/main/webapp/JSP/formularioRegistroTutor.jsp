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
                        <li class="pure-menu-item"><a href="../JSP/subIndexTutor.jsp" class="pure-menu-link">Inicio</a></li>
                        <li class="pure-menu-item"><a href="${contexto}/EleccionTutor?op=actualizar" class="pure-menu-link">Actualizar</a></li>
                        <li class="pure-menu-item menu-item-divided pure-menu-selected"><a href="${contexto}/EleccionTutor?op=alta" class="pure-menu-link">Alta alumnos</a></li>
                        <li class="pure-menu-item"><a href="${contexto}/EleccionTutor?op=borrar" class="pure-menu-link">Borra alumnos</a></li>
                        <li class="pure-menu-item"><a href="${contexto}/EleccionTutor?op=listar" class="pure-menu-link">Lista alumnos</a></li>
                        <li class="pure-menu-item"><a href="${contexto}" class="pure-menu-link">Salir</a></li>
                    </ul>
                </div>
                <div>
                    <img id="logoCorporativo" src="../IMG/logo.png" alt="logo corporativo">
                </div>
            </div>

            <div id="main">
                <div class="header">
                    <div class="pure-u-1-8">
                        <img class="pure-img-responsive" src="../IMG/logo.png" alt="logo corporativo">
                    </div>
                    <h1>Education School Rating</h1>
                    <h2>ESR</h2>
                </div>

                <div class="content">
                    <h2 class="content-subhead">Registrar</h2>
                    <form class="pure-form pure-form-aligned" method="post" action="Controlador?op=addAlumno">
                        <fieldset>
                            <legend>Formulario de registro de un alumno</legend>
                            <div class="pure-control-group">
                                <label for="name">Nombre</label>
                                <input name="nombre" id="name" type="text" placeholder="Nombre">
                            </div>

                            <div class="pure-control-group">
                                <label for="apellidos">Apellidos</label>
                                <input name="apellidos" id="apellidos" type="text" placeholder="Apellidos">
                            </div>

                            <div class="pure-control-group">
                                <label for="dni">DNI</label>
                                <input name="dni" id="dni" type="text" placeholder="DNI">
                            </div>

                            <div class="pure-control-group">
                                <label for="password">Contraseña</label>
                                <input name="password" id="password" type="password" placeholder="Contraseña">
                            </div>

                            <div class="pure-control-group">
                                <label for="rpassword">Repite contraseña</label>
                                <input name="rpassword" id="rpassword" type="password" placeholder="Repite contraseña">
                            </div>

                            <div class="pure-control-group">
                                <label for="email">Email</label>
                                <input name="email" id="email" type="email" placeholder="Email">
                            </div>

                            <div class="pure-control-group">
                                <label for="fechanacimiento">Fecha de nacimiento</label>
                                <input name="fechanacimiento" id="fechanacimiento" type="datetime-local">
                            </div>

                            <div class="pure-control-group">
                                <label for="genero">Género</label>
                                <select name="genero" id="genero">
                                    <option value="generos" selected disabled>Generos</option>
                                    <option value="HOMBRE">Hombre</option>
                                    <option value="MUJER">Mujer</option>
                                </select>
                            </div>

                            <div class="pure-control-group">
                                <label for="ciclo">Ciclo</label>
                                <select name="ciclo" id="ciclo">
                                    <option value="ciclos" selected disabled>Ciclos</option>
                                    <c:forEach var="item" items="${listadoCiclos}">
                                        <option value="${item.idCiclo}/${item.abreviatura}/${item.horasFCT}/${item.ley}/${item.nombre}">${item.nombre}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            
                            <div class="pure-control-group">
                                <label for="modulo">Modulo</label>
                                <select name="modulo" id="modulo">
                                    <option value="modulos" selected disabled>Modulos</option>
                                    <c:forEach var="item" items="${listadoModulos}">
                                        <option value="modulos">${item.denominacion}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="pure-control-group">
                                <label for="notas">Notas</label>
                                <input name="notas" id="notas" type="number">
                            </div>

                            <div class="pure-controls">
                                <button type="submit" name="enviar" class="pure-button pure-button-primary">Enviar</button>
                            </div>
                        </fieldset>
                    </form>

                </div>
            </div>
        </div>
    </body>
</html>

