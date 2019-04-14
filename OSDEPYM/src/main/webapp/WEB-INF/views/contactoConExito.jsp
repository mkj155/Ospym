<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>

<%-- <jsp:include page="./header.jsp" /> --%>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="/OSDEPYM/resources/core/js/bootstrap.min.js"></script>
<script src="/OSDEPYM/resources/core/js/bootstrap-swipe-carousel.min.js"></script>
<script src="/OSDEPYM/resources/core/js/main.js"></script> 
<script src="/OSDEPYM/resources/core/js/contacto.js"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/OSDEPYM/resources/core/css/fonts.css">
    <link rel="stylesheet" href="/OSDEPYM/resources/core/css/bootstrap.css">
    <link rel="stylesheet" href="/OSDEPYM/resources/core/css/main.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    <link href="/OSDEPYM/resources/core/css/_contacto.css" rel="stylesheet" />
</head>
<body>
	<header id="header">
        <div class="top bg-gradient">
            <nav class="navbar-top">
                <div class="container">
                    <ul class="list-inline list-unstyled mb-0 d-inline-block">
                        <li class="list-inline-item dropdown">
                            <a href="" class="text-white">Afiliados</a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="autoridades.html">Tramites On-line</a>
                                <a class="dropdown-item" href="facturacion.html">Facturación</a>
                                <a class="dropdown-item" href="cuenta-corriente.html">Cuenta Corriente</a>
                            </div>
                        </li>
                        <li class="list-inline-item dropdown">
                            <a href="" class="text-white">Prestadores</a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="autoridades.html">Validación On-line</a>
                                <a class="dropdown-item" href="facturacion.html">Discapacidad</a>
                            </div>
                        </li>
                        <li class="list-inline-item dropdown">
                            <a href="" class="text-white">Derivación</a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="autoridades.html">Empresas</a>
                                <a class="dropdown-item" href="facturacion.html">Centros médicos</a>
                            </div>
                        </li>
                        <li class="list-inline-item dropdown">
                        <a class="text-white" href="">
                            Tramites online
                        </a>
                        <div class="dropdown-menu">
<%--                         <spring:url value="/contacto/123/fruta" var="userUrl" /> --%>
                            <a class="dropdown-item" href="/OSDEPYM/contacto/123/fruta">Canal de contacto</a>
                            <a class="dropdown-item" href="recursos-humanos.html">Mi plan web</a>
                        </div>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="mainnav">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container">
                    <a class="navbar-brand" href="index-1.html"><img src="/OSDEPYM/resources/core/img/logo.svg" alt="OSDEPYM"></a>

                    <ul class="navbar-nav list-inline list-unstyled social-nav ml-0 mt-2 mt-lg-0 text-right">
                        <li class="nav-item nav-item-social facebook">
                            <a class="nav-link" href="#"> <span class="square"><i class="fab fa-facebook-f"></i> <span class="sr-only">Facebook</span></span> </a>
                        </li>
                        <li class="nav-item nav-item-social twitter">
                            <a class="nav-link" href="#"> <span class="square"><i class="fab fa-twitter"></i> <span class="sr-only">Twitter</span></span> </a>
                        </li>
                        <li class="nav-item nav-item-social instagram">
                            <a class="nav-link" href="#"> <span class="square"><i class="fab fa-instagram"></i> <span class="sr-only">Instagram</span></span> </a>
                        </li>
                    </ul>

                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fas fa-bars"></i>
                    </button>

                   
                
                    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                    <ul class="navbar-nav ml-auto mt-2 mt-lg-0 text-right">
                        <li class="nav-item active dropdown">
                        <a class="nav-link" href="nosotros.html">
                            Nosotros
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="autoridades.html">Autoridades</a>
                            <a class="dropdown-item" href="recursos-humanos.html">Recursos Humanos</a>
                            <a class="dropdown-item" href="responsabilidad-social.html">Responsabilidad Social</a>
                            <a class="dropdown-item" href="telefonos-utiles.html">Teléfonos útiles</a>
                        </div>
                        </li>
                        <li class="nav-item">
                        <a class="nav-link" href="planes.jsp">Planes</a>
                        </li>
                        <li class="nav-item">
                        <a class="nav-link" href="sucursales.html">Sucursales</a>
                        </li>
                        <li class="nav-item">
                        <a class="nav-link" href="cartilla-medica.html">Cartilla</a>
                        </li>
                    </ul>
                    
                    </div>
                </div>
              </nav>
        </div>
    </header>
 <section id="main" class="bg-gray">
   <div class="container page page-cartilla">
	<h1>Tramite ingresado con exito!</h1><br />
	<p class="big">
	<span class="text-green"><strong>Su numero de tramite es ${numeroTramite}</strong></span><br/>
	A partir de ahora su solucitud ser&aacute; procesada y a la brevedad nos comunicaremos con usted para informarle el resultado de la misma. 
	Por favor recuerde mantener sus datos de contacto actualizados.
	Muchas gracias!
	</p>
    <button type="button" class="btn-lg btn-primary pull-right" onclick="location.href='/osdepym'">Volver al menu</button>
	</div>
 </section>
 
 <section id="beneficios">
        <h2 class="title-section">
            <span class="bg-primary text">BENEFICIOS</span>
            <span class="line-div"></span>
        </h2>
        <div class="container text-center">
            <ul class="list-unstyled list-inline row">
                <li class="list-inline-item col">
                    <img src="/OSDEPYM/resources/core/img/icons-01.svg" class="d-none d-md-block" alt="Precios accesibles">
                    <div class="d-md-none">
                        <div class="row">
                            <div class="col-3 text-center">
                            <img src="/OSDEPYM/resources/core/img/icons-mobile-01.svg" alt="Precios accesibles">    
                            </div>
                            <div class="col-9 text-left">
                                <span class="text">Precios accesibles</span>
                            </div>                               
                        </div>
                    </div>
                </li>
                <li class="list-inline-item col">
                    <img src="/OSDEPYM/resources/core/img/icons-02.svg" class="d-none d-md-block" alt="Cartilla online">
                    <div class="d-md-none">
                        <div class="row">
                            <div class="col-3 text-center">
                            <img src="/OSDEPYM/resources/core/img/icons-mobile-02.svg" alt="Cartilla online">    
                            </div>
                            <div class="col-9 text-left">
                                <span class="text">Cartilla online</span>
                            </div>                               
                        </div>
                    </div>
                </li>
                <li class="list-inline-item col">
                    <img src="/OSDEPYM/resources/core/img/icons-03.svg" class="d-none d-md-block" alt="Más de 120 clínicas y centros de atención">
                    <div class="d-md-none">
                        <div class="row">
                            <div class="col-3 text-center">
                            <img src="/OSDEPYM/resources/core/img/icons-mobile-03.svg" alt="Más de 120 clínicas y centros de atención">    
                            </div>
                            <div class="col-9 text-left">
                                <span class="text">Más de 120 clínicas y centros de atención</span>
                            </div>                               
                        </div>
                    </div>
                </li>
                <li class="list-inline-item col">
                    <img src="/OSDEPYM/resources/core/img/icons-04.svg" class="d-none d-md-block" alt="Presencia en todo el país">
                    <div class="d-md-none">
                        <div class="row">
                            <div class="col-3 text-center">
                            <img src="/OSDEPYM/resources/core/img/icons-mobile-04.svg" alt="Presencia en todo el país">    
                            </div>
                            <div class="col-9 text-left">
                                <span class="text">Presencia en todo el país</span>
                            </div>                               
                        </div>
                    </div>
                </li>
                <li class="list-inline-item col">
                    <img src="/OSDEPYM/resources/core/img/icons-05.svg" class="d-none d-md-block" alt="Asistencia al viajero">
                    <div class="d-md-none">
                        <div class="row">
                            <div class="col-3 text-center">
                            <img src="/OSDEPYM/resources/core/img/icons-mobile-05.svg" alt="Asistencia al viajero">    
                            </div>
                            <div class="col-9 text-left">
                                <span class="text">Asistencia al viajero</span>
                            </div>                               
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        
    </section>
	
	<footer id="footer" class="bg-gradient">
        <div class="container">
            <div class="row">
                    <div class="col"><img class="logo-footer" src="/OSDEPYM/resources/core/img/logo-white.svg" alt="OSDEPYM"></div>
                    <div class="col col-address"> 
                        <p>Reconquista 458 / 2do piso <br>
                            Buenos Aires / Argentina <br>
                            Tel.: (011) 5288-5600</p>
                        <p class="small legal d-none d-md-block"> 
                            Superintendencia de servicios de salud <br>
                            0800-222-72583 / <a href="http://www.sssalud.gob.ar">www.sssalud.gob.ar</a><br>
                            R.N.O.S.: 4-0170-4 / R.N.E.M.P.: 1486
                        </p> 
                    </div>
                    <div class="col col-nosotros">
                        <h5 class="title">NOSOTROS</h5>
                        <ul class="list-unstyled">
                            <li><a href="/autoridades.html">Autoridades</a></li>
                            <li><a href="/recursos-humanos.html">Recursos Humanos</a></li>
                            <li><a href="/responsabilidad-social.html">Responsabilidad Social</a></li>
                            <li><a href="/telefonos-utiles.html">Teléfonos útiles</a></li>
                            <li><a href="/contacto.html">Contacto</a></li>
                        </ul> 
                    </div>
                    <div class="col col-planes">
                        <h5 class="title">NUESTROS PLANES</h5>
                        <ul class="list-unstyled">
                            <li><a href="/P800">P800</a></li>
                            <li><a href="/P3000">P3000</a></li>
                            <li><a href="/P4000">P4000</a></li>
                        </ul> 
                    </div>
                    <div class="col col-last">
                        <h5 class="title"><a href="/sucursales.html">SUCURSALES</a></h5>
                        <br>
                        <h5 class="title"><a href="/cartilla-medica.html">CARTILLA</a></h5>
                    </div>
                </div>
                <p class="small legal d-none d-block d-md-block d-lg-none"> 
                    Superintendencia de servicios de salud <br>
                    0800-222-72583 / <a href="http://www.sssalud.gob.ar">www.sssalud.gob.ar</a><br>
                    R.N.O.S.: 4-0170-4 / R.N.E.M.P.: 1486
                </p> 
        </div>
        
    </footer>

</html>