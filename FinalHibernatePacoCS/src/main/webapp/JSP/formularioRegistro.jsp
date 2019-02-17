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
                        <li class="pure-menu-item"><a href="${contexto}" class="pure-menu-link">Inicio</a></li>
                        <li class="pure-menu-item"><a href="${contexto}/Eleccion?op=acceder" class="pure-menu-link">Accede</a></li>
                        <li class="pure-menu-item menu-item-divided pure-menu-selected"><a href="${contexto}/Eleccion?op=registrar" class="pure-menu-link">Registrate</a></li>
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
                    <h2 class="content-subhead">Registrate</h2>
                    <form class="pure-form pure-form-aligned">
                        <fieldset>
                            <legend>Formulario de registro</legend>
                            <div class="pure-control-group">
                                <label for="name">Nombre</label>
                                <input id="name" type="text" placeholder="Nombre">
                            </div>
                            
                            <div class="pure-control-group">
                                <label for="apellidos">Apellidos</label>
                                <input id="apellidos" type="text" placeholder="Apellidos">
                            </div>
                            
                            <div class="pure-control-group">
                                <label for="dni">DNI</label>
                                <input id="dni" type="text" placeholder="DNI">
                            </div>

                            <div class="pure-control-group">
                                <label for="password">Contraseña</label>
                                <input id="password" type="password" placeholder="Contraseña">
                            </div>

                            <div class="pure-control-group">
                                <label for="email">Email</label>
                                <input id="email" type="email" placeholder="Email">
                            </div>

                            <div class="pure-controls">
                                <button type="submit" class="pure-button pure-button-primary">Submit</button>
                            </div>
                        </fieldset>
                    </form>

                </div>
            </div>
        </div>
    </body>
</html>

