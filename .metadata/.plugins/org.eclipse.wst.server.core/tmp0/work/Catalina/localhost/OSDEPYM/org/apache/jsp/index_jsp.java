/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.47
 * Generated at: 2019-05-15 23:00:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("jar:file:/C:/Users/PC/Documents/PiTu%5E%5E/Laburo/VAS/OSDEPYM/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/OSDEPYM/WEB-INF/lib/spring-webmvc-4.3.20.RELEASE.jar!/META-INF/spring.tld", Long.valueOf(1539602956000L));
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-4.3.20.RELEASE.jar", Long.valueOf(1555371285627L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1555371423052L));
    _jspx_dependants.put("jar:file:/C:/Users/PC/Documents/PiTu%5E%5E/Laburo/VAS/OSDEPYM/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/OSDEPYM/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153395882000L));
    _jspx_dependants.put("jar:file:/C:/Users/PC/Documents/PiTu%5E%5E/Laburo/VAS/OSDEPYM/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/OSDEPYM/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153395882000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./WEB-INF/views/header.jsp", out, false);
      out.write("\r\n");
      out.write("  \r\n");
      out.write("    <body>\r\n");
      out.write("    <section id=\"hero-carousel\">\r\n");
      out.write("        <div id=\"carouselHome\" class=\"carousel slide\" data-interval=\"1000\" data-ride=\"carousel\">\r\n");
      out.write("            <ul class=\"carousel-indicators\">\r\n");
      out.write("                <li data-target=\"#carouselHome\" data-slide-to=\"0\" class=\"active\"></li>\r\n");
      out.write("                <li data-target=\"#carouselHome\" data-slide-to=\"1\" class=\"\"></li>\r\n");
      out.write("                <li data-target=\"#carouselHome\" data-slide-to=\"2\" class=\"\"></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <div class=\"carousel-inner\">\r\n");
      out.write("                <div class=\"carousel-item active\">\r\n");
      out.write("                    <a href=\"#\"><img class=\"d-block w-100\" src=\"resources/core/img/slide-01.jpg?dummy=1557697417600\" alt=\"Texto slide 1\"></a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"carousel-item\">\r\n");
      out.write("                    <a href=\"#\"><img class=\"d-block w-100\" src=\"resources/core/img/slide-02.jpg?dummy=1557697417600\" alt=\"Texto slide 2\"></a>\r\n");
      out.write("              \t</div>\r\n");
      out.write("                <div class=\"carousel-item\">\r\n");
      out.write("                    <a target=\"blank\" href=\"#\"><img class=\"d-block w-100\" src=\"resources/core/img/slide-03.jpg?dummy=1557697417600\" alt=\"Texto slide 3\"></a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"carousel-item\">\r\n");
      out.write("                   <img class=\"d-block w-100\" src=\"resources/core/img/slide-04.png?dummy=1557697417600\" alt=\"\">\r\n");
      out.write("                </div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("            <a class=\"carousel-control-prev carousel-control-shadow\" href=\"#carouselHome\" data-slide=\"prev\">\r\n");
      out.write("\t\t\t   <span class=\"carousel-control-prev-icon\"></span>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t<a class=\"carousel-control-next carousel-control-shadow\" href=\"#carouselHome\" data-slide=\"next\">\r\n");
      out.write("\t\t\t   <span class=\"carousel-control-next-icon\"></span>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"contact-section\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-4 col-lg-3 text-center\">\r\n");
      out.write("                        <span class=\"label text-red\">EMERGENCIAS Y URGENCIAS</span> \r\n");
      out.write("                        <span id=\"linkTelefono\" class=\"phone-number\"><a href=\"tel:08002888000\">0800 288 8000</a></span>\r\n");
      out.write("                        <span id=\"linkTelefonoTexto\" class=\"phone-number\"><a>0800 288 8000</a></span>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<span id=\"linkTelefono\" class=\"phone-number\"><a href=\"tel:08103338743\">0810 333 8743</a></span> \r\n");
      out.write("\t\t\t\t\t\t<span id=\"linkTelefonoTexto\" class=\"phone-number\"><a>0810 333 8743</a></span>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-4 col-lg-3 text-center\">\r\n");
      out.write("                        <span class=\"label text-blue\">ATENCIÓN AL AFILIADO</span>\r\n");
      out.write("                        <span id=\"linkTelefono\" class=\"phone-number\"><a href=\"tel:08002887963\">0800 288 7963</a></span>\r\n");
      out.write("                        <span id=\"linkTelefonoTexto\" class=\"phone-number\"><a>0800 288 7963</a></span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-4 col-lg-3 text-center\">\r\n");
      out.write("                        <span class=\"label text-green\">QUIERO ASOCIARME</span>\r\n");
      out.write("                        <span id=\"linkTelefono\" class=\"phone-number\"><a href=\"tel:08002888432\">0800 288 8432</a></span>\r\n");
      out.write("                        <span id=\"linkTelefonoTexto\" class=\"phone-number\"><a>0800 288 8432</a></span>\r\n");
      out.write("<!--                         <span class=\"icon\"><i class=\"fas fa-envelope\"></i></span> -->\r\n");
      out.write("                        \r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-lg-3 col-btn\">\r\n");
      out.write("                        <a target=\"blank\" href=\"https://www.osdepym.com.ar/micrositio-beneficiarios/login\" role=\"button\" class=\"btn btn-outline-primary btn-block btn-sm\">TRÁMITES ONLINE</a>\r\n");
      out.write("                        <a href=\"./app.htm?page=contacto\" role=\"button\" class=\"btn btn-outline-primary btn-block btn-sm\">CONTÁCTENOS</a>\r\n");
      out.write("                        <a href=\"./app.htm?page=servicios\" role=\"button\" class=\"btn btn-outline-primary btn-block btn-sm\">CARTILLA</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </section>\r\n");
      out.write("\r\n");
      out.write("    <section id=\"novedades\" class=\"bg-gray\">\r\n");
      out.write("    <h2 class=\"title-section\" style=\"cursor:pointer;\">\r\n");
      out.write("            <span class=\"bg-primary text\">NOVEDADES</span>\r\n");
      out.write("            <span class=\"line-div\"></span>\r\n");
      out.write("        </h2>\r\n");
      out.write("        <div class=\"news\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row row-eq-height\" id=\"rowNews\">\r\n");
      out.write("                \t<div class=\"col-md-4\">  \r\n");
      out.write("\t\t\t\t\t\t<div class=\"card\">    \r\n");
      out.write("\t\t\t\t\t\t\t<img class=\"card-img-top\" src=\"resources/core/img/novedad25.jpg\" alt=\"Card image cap\">    \r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"card-body\">        \r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"date\">07/05/2019</span>        \r\n");
      out.write("\t\t\t\t\t\t\t\t<h5 class=\"card-title\">El Asma</h5>        \r\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"card-text\"></p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p><span style=\"font-size: 14pt;\">El asma es un <strong>trastorno respiratorio de carácter crónico</strong>. Principalmente, actúa Inflamando y estrechando las vías respiratorias.&nbsp;</span></p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p></p>        \r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"javascript:NavigateTo('novedadHome.htm?idNovedad=25');\" class=\"btn btn-outline-primary\">+ info</a>    \r\n");
      out.write("\t\t\t\t\t\t\t</div>  \r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-4\">  \r\n");
      out.write("\t\t\t\t\t\t<div class=\"card\">    \r\n");
      out.write("\t\t\t\t\t\t\t<img class=\"card-img-top\" src=\"resources/core/img/novedad24.jpg\" alt=\"Card image cap\">    \r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"card-body\">        \r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"date\">06/05/2019</span>       \r\n");
      out.write("\t\t\t\t\t\t\t\t<h5 class=\"card-title\">Cada vez más cerca tuyo</h5>        \r\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"card-text\"></p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p><span style=\"font-size: 14pt;\">Seguimos creciendo. Nueva Sucursal en el <strong>Centro Despachantes de Aduana</strong>.</span></p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p></p>        \r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"javascript:NavigateTo('novedadHome.htm?idNovedad=24');\" class=\"btn btn-outline-primary\">+ info</a>   \r\n");
      out.write("\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-4\">  \r\n");
      out.write("\t\t\t\t\t\t<div class=\"card\">    \r\n");
      out.write("\t\t\t\t\t\t\t<img class=\"card-img-top\" src=\"resources/core/img/novedad23.jpg\" alt=\"Card image cap\">   \r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"card-body\">        \r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"date\">29/04/2019</span>        \r\n");
      out.write("\t\t\t\t\t\t\t\t<h5 class=\"card-title\">Llegamos a Formosa</h5>        \r\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"card-text\"></p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p><span style=\"font-size: 14pt;\">La Cámara de Pequeñas y Medianas Empresas de Formosa (<strong>CAPYMEF</strong>) nos abre sus puertas.</span></p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p></p>        \r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"javascript:NavigateTo('novedadHome.htm?idNovedad=23');\" class=\"btn btn-outline-primary\">+ info</a>   \r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\t\r\n");
      out.write("                </div>\t\r\n");
      out.write("                <br><br>\r\n");
      out.write("                <div class=\"text-center\">\r\n");
      out.write("                    <a role=\"button\" style=\"border-radius:0px;\" href=\"./app.htm?page=novedadesHome\" class=\"btn btn-lg btn-outline-primary btn-novedades\">+ NOVEDADES</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("           \r\n");
      out.write("        </div>\r\n");
      out.write("    </section>\r\n");
      out.write("\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./WEB-INF/views/footer.jsp", out, false);
      out.write("\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
