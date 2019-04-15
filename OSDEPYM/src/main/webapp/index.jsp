<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
  <jsp:include page="./WEB-INF/views/header.jsp" />
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/OSDEPYM/resources/core/css/fonts.css">
    <link rel="stylesheet" href="/OSDEPYM/resources/core/css/bootstrap.css">
    <link rel="stylesheet" href="/OSDEPYM/resources/core/css/main.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">

    <title>OSDEPYM</title>
  </head>
    <body>
    <section id="hero-carousel">
        <div id="carouselHome" class="carousel slide" data-ride="carousel" data-wrap="false">
            <ol class="carousel-indicators">
                <li data-target="#carouselHome" data-slide-to="0" class="active"></li>
                <li data-target="#carouselHome" data-slide-to="1"></li>
                <li data-target="#carouselHome" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                <img class="d-block w-100" src="/OSDEPYM/resources/core/img/slide-01.jpeg" alt="Texto slide 1">
                <div class="carousel-caption">
                    <h2 class="carousel-title">Estamos trabajando para vos y queremos estar más cerca tuyo y que accedas a todos los beneficios que tenemos para darte. <br>
                        Actualizá tus datos y enterate de todas las novedades.</h2>
                </div>
                </div>
                <div class="carousel-item">
                <img class="d-block w-100" src="/OSDEPYM/resources/core/img/slide-02.jpeg" alt="Texto slide 2">
                <div class="carousel-caption caption-left-40 text-left">
                    <h2 class="carousel-title">Beneficios de caminar:</h2>
                    <ul class="list-unstyled">
                        <li><span class="text-blue">Disminuye el riesgo de hipertensión arterial. </span></li>
                        <li><span class="text-green">Favorece los niveles de colesterol en sangre. </span></li>
                        <li><span class="text-blue">Previene la aparición de diábetes. </span></li>
                        <li><span class="text-green">Aumenta los niveles de Vitamina D caminando al aire libre. </span></li>
                        <li><span class="text-blue">Mejora la circulación. </span></li>
                        <li><span class="text-green">Fortalece el corazón.</span></li>
                        <li><span class="text-blue">Favorece el descenso de peso y disminuye el estrés.</span></li>
                    </ul>
                   
                </div>
                </div>
                <div class="carousel-item">
                <img class="d-block w-100" src="/OSDEPYM/resources/core/img/slide-03.jpeg" alt="Texto slide 3">
                <div class="carousel-caption caption-left-60 text-right">
                    <h2 class="carousel-title text-blue">Te presentamos la nueva credencial.</h2>
                    <p class="text-blue">Ahora con solo presentarla, podés acceder a todos los servicios.</p>
                </div>
                </div>
            </div>
        </div>
        <div class="contact-section">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 col-lg-3 text-center">
                        <span class="label text-red">EMERGENCIAS Y URGENCIAS</span> 
                        <span class="phone-number">0800 288 800</span>
                    </div>
                    <div class="col-md-4 col-lg-3 text-center">
                        <span class="label text-blue">ATENCIÓN AL AFILIADO</span>
                        <span class="phone-number">0800 288 7963</span>
                    </div>
                    <div class="col-md-4 col-lg-3 text-center">
                        <span class="label text-green">QUIERO ASOCIARME</span>
                        <span class="phone-number">0800 288 8432</span>
                        <span class="icon"><i class="fas fa-envelope"></i></span>
                        
                    </div>
                    <div class="col-lg-3 col-btn">
                        <a href="tramites-online.html" role="button" class="btn btn-outline-primary btn-block btn-sm">TRÁMITES ONLINE</a>
                        <a href="contacto.html" role="button" class="btn btn-outline-primary btn-block btn-sm">CONTÁCTENOS</a>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section id="novedades" class="bg-gray">
        <h2 class="title-section">
            <span class="bg-primary text">NOVEDADES</span>
            <span class="line-div"></span>
        </h2>
        <div class="news">
            <div class="container">
                <div class="row row-eq-height row-novedades">
                    <div class="col-lg-4 col-novedad">
                        <div class="card">
                            <img class="card-img-top" src="/OSDEPYM/resources/core/img/novedad-01.jpeg" alt="Card image cap">
                            <div class="card-body">
                                <span class="date">10/11/2018</span>
                                <h5 class="card-title">Más beneficios para nuestros afiliados.</h5>
                                <p class="card-text">Por eso si sos afiliado del <strong>Plan P4000</strong> o <strong>Plan Personal, OSDEPYM en alianza con Coris</strong> te ofrece la mayor seguridad y tranquilidad en cada viaje, en cualquier lugar del mundo</p>
                                <a href="detalle-novedad.html" class="btn btn-outline-primary">+ info</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-novedad">
                        <div class="card">
                            <img class="card-img-top" src="/OSDEPYM/resources/core/img/novedad-02.jpeg" alt="Card image cap">
                            <div class="card-body">
                                <span class="date">20/11/2018</span>
                                <h5 class="card-title">Orgullosos de ayudar</h5>
                                <p class="card-text">El pasado 9 de noviembre <strong>más de 40 voluntarios de Osdepym, CAME, y el Instituto Asegurador Mercantil,</strong> viajaron a Tucumán para participar de dos intensas jornadas solidarias. </p>
                                <a href="detalle-novedad.html" class="btn btn-outline-primary">+ info</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-novedad">
                        <div class="card">
                            <img class="card-img-top" src="/OSDEPYM/resources/core/img/novedad-03.jpeg" alt="Card image cap">
                            <div class="card-body">
                                <span class="date">25/11/2018</span>
                                <h5 class="card-title">Nuevas filiales en Tucumán y Catamarca</h5>
                                <p class="card-text">El próximo 10 de diciembre estaremos inaugurando <strong>dos nuevas filiales</strong> de atención para nuestros beneficiarios</p>
                                <a href="detalle-novedad.html" class="btn btn-outline-primary">+ info</a>
                            </div>
                        </div>
                    </div>
                    
                </div>
                <div class="text-center">
                        <a role="button" href="novedades.html" class="btn btn-lg btn-outline-primary btn-novedades">+ NOVEDADES</a>
                </div>
            </div>
           
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
	<jsp:include page="./WEB-INF/views/footer.jsp" />

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="/OSDEPYM/resources/core/js/bootstrap.min.js"></script>
    <script src="/OSDEPYM/resources/core/js/bootstrap-swipe-carousel.min.js"></script>
    <script src="/OSDEPYM/resources/core/js/main.js"></script>

    <script>
        const carouselHome = $('#carouselHome');
        carouselHome.carousel().swipeCarousel({
        sensitivity: 'high' // low, medium or high
    });
    </script>
  </body>
</html>