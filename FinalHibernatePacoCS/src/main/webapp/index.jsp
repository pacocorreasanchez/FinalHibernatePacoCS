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
        <%@include file="INC/metadatas.jsp" %>
        <title>Index</title>
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
                        <li class="pure-menu-item menu-item-divided pure-menu-selected">
                            <a href="${contexto}" class="pure-menu-link">Inicio</a>
                        </li>
                        <li class="pure-menu-item"><a href="${contexto}/Eleccion?op=acceso" class="pure-menu-link">Accede</a></li>
                        <!--<li class="pure-menu-item"><a href="${contexto}/Eleccion?op=registro" class="pure-menu-link">Registro Admin</a></li>-->
                    </ul>
                </div>
                <div>
                    <img id="logoCorporativo" src="IMG/logo.png" alt="logo corporativo">
                </div>
            </div>

            <div id="main">
                <div class="header">
                    <div class="pure-u-1-8">
                        <img class="pure-img-responsive" src="IMG/logo.png" alt="logo corporativo">
                    </div>
                    <h1>Education School Rating</h1>
                    <h2>ESR</h2>
                </div>

                <div class="content">
                    <h2 class="content-subhead">Qué es Education School Rating</h2>
                    <p>
                        Con esta aplicación, el profesor tutor del grupo podrá asignar las notas a sus alumnos y a su vez estos podrán tener acceso a ellas para ver cuáles han sido sus calificaciones.
                    </p>

                    <div class="pure-g">
                        <div class="pure-u-1-4">
                            <img class="pure-img-responsive" src="http://fic.uas.edu.mx/wp-content/uploads/2018/08/menu_elearning.png" alt="logo1">
                        </div>
                        <div class="pure-u-1-4">
                            <img class="pure-img-responsive" src="http://www.digital.santillana.es/file/2018/06/29/r3_1_1__5.png" alt="logo2">
                        </div>
                        <div class="pure-u-1-4">
                            <img class="pure-img-responsive" src="https://2.bp.blogspot.com/-vtxFBI1kqJk/VyJzsnNPFAI/AAAAAAAAAAw/AFvlSvuS3voVVwm5Lml43xz5ah_gYwvCwCLcB/s1600/Aulas%2Bvirtuales.png" alt="logo3">
                        </div>
                        <div class="pure-u-1-4">
                            <img class="pure-img-responsive" src="http://3.bp.blogspot.com/-we0xnvdylz8/TdEnPIdARCI/AAAAAAAAAAM/QOnvaVARADA/s1600/thumbnailCA42WUFF.jpg" alt="logo4">
                        </div>
                    </div>

                    <h2 class="content-subhead">Rol del tutor</h2>
                    <p>
                        El tutor tendrá dar de alta a sus nuevos alumnos para que estén dentro del sistema. Posteriormente a cada uno de sus alumnos, los podrá ir calificando y añadiendo las calificaciones de cada uno de los módulos que tenga el alumno en cuestión. Tendrá la opción de ver la lista de los alumnos y sus notas medias y ponderadas (clasificando de mayor a menor).
                    </p>

                    <h2 class="content-subhead">Rol del alumno</h2>
                    Un alumno tiene acceso a sus calificaciones y ver la lista de módulos especificando la familia, el curso y el nombre del módulo. 
                    <p>

                    </p>
                </div>
            </div>
        </div>
    </body>
</html>
