/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.47
 * Generated at: 2019-05-15 23:06:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class reglamentoMonotributista_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<section>\n");
      out.write("\t<h1>PLANES DE SALUD PARA MONOTRIBUTISTAS</h1>\n");
      out.write("\t<h2>Reglamento</h2>\n");
      out.write("\t<hr />\n");
      out.write("\t<ol class=\"ol-reglamento\">\n");
      out.write("\t\t<li><div><b>Disposiciones Generales:</b></div>\n");
      out.write("\t\t\t<div class=\"content-reglamento\">\n");
      out.write("\t\t\t\tEl presente reglamento, as&iacute; como las modificaciones o ampliaciones que en el futuro pudieran introducirse como consecuencia de\n");
      out.write("\t\t\t\tdisposiciones legales, junto con el correspondiente Plan de Beneficios y Gu&iacute;a de Servicios que se entrega al Afiliado Titular, de\n");
      out.write("\t\t\t\tacuerdo a lo establecido por la Resoluci&oacute;n 76/98 de la Superintendencia de Servicios de Salud, establecen los derechos y\n");
      out.write("\t\t\t\tobligaciones de los beneficiarios OSDEPYM.\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</li>\n");
      out.write("\t\t<li><div><b>Beneficiarios:</b></div>\n");
      out.write("\t\t\t<div class=\"content-reglamento\">\n");
      out.write("\t\t\t\tTitulares: Pueden afiliarse como tales las quienes, estando comprendidos e inscriptos en el R&eacute;gimen Simplificado para Peque&ntilde;os\n");
      out.write("\t\t\t\tContribuyentes, previsto en la Ley 25.865 y sus modificatorias y ampliatorias, siendo o no empleadores de terceros, desempe&ntilde;en\n");
      out.write("\t\t\t\ten forma habitual actividades relacionadas con la producci&oacute;n agropecuaria, minera, forestal, pesquera, la industria manufacturera,\n");
      out.write("\t\t\t\tel comercio o los servicios en general o ejerzan actividades profesionales o t&eacute;cnicas de forma aut&oacute;noma. Familiares: Son los\n");
      out.write("\t\t\t\tintegrantes del grupo familiar primario del Afiliado Titular que, conforme los art&iacute;culos 40 inciso c) y 43 inciso d) de la ley 25.865,\n");
      out.write("\t\t\t\tsus modificatorias y ampliatorias realice el aporte adicional voluntario por Grupo Familiar. En tal caso, tienen derecho a las mismas\n");
      out.write("\t\t\t\tprestaciones hijos e hijas, hijastros e hijastras, solteros o no emancipados, hasta los 21 a&ntilde;os de edad, hijos estudiantes hasta los\n");
      out.write("\t\t\t\t25 a&ntilde;os inclusive, hijos incapacitados, menores en guarda y concubinos y lo que complemente el art&iacute;culo 9 inciso a) de la Ley\n");
      out.write("\t\t\t\t23.660.\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</li>\n");
      out.write("\t\t<li><div><b>Incorporaci&oacute;n:</b></div>\n");
      out.write("\t\t\t<div class=\"content-reglamento\">\n");
      out.write("\t\t\t\tLa cantidad de beneficiarios titular o familiar se adquiere en los plazos y condiciones previstos por la Superintendencia de\n");
      out.write("\t\t\t\tServicios de Salud, previa presentaci&oacute;n en las oficinas de OSDEPYM de Solicitud de Afiliaci&oacute;n debidamente cumplimentada,\n");
      out.write("\t\t\t\tformulario del Sistema Nacional del Seguro de Salud _ Libre de Elecci&oacute;n de Obra Social junto con la documentaci&oacute;n probatoria de\n");
      out.write("\t\t\t\tla identidad, del v&iacute;nculo familiar y la constancia del dep&oacute;sito regular de los aportes establecidos por ley y la firma del libro\n");
      out.write("\t\t\t\trubricado para tal efecto.\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</li>\n");
      out.write("\t\t<li><div><b>Continuidad de aportes:</b></div>\n");
      out.write("\t\t\t<div class=\"content-reglamento\">\n");
      out.write("\t\t\t\tLa condici&oacute;n de beneficiario se mantiene en tanto haya continuidad en el pago de los aportes desde la inscripci&oacute;n. Si vencido el\n");
      out.write("\t\t\t\tplazo correspondiente, OSDEPYM no recibiera de la AFIP, o el organismo oficial que a tal efecto se establezca, la informaci&oacute;n que\n");
      out.write("\t\t\t\tacredita dichos pagos, se considera al beneficiario en mora, perdiendo el derecho a las prestaciones y beneficios desde ese\n");
      out.write("\t\t\t\tmomento hasta su total regularizaci&oacute;n y/o demostraci&oacute;n fehaciente de haber efectuado los dep&oacute;sitos en tiempo y forma. Los\n");
      out.write("\t\t\t\tpagos parciales o irregulares no dar&aacute;n lugar a la rehabilitaci&oacute;n de los beneficios o prestaciones comprometidos, Si la falta de pago\n");
      out.write("\t\t\t\tfuera &uacute;nicamente del aporte voluntario por inclusi&oacute;n del grupo familiar, ser&aacute; autom&aacute;ticamente considerado como baja del mismo,\n");
      out.write("\t\t\t\tmanteni&eacute;ndose los derechos del titular mientras acredite regularidad en su aporte. La p&eacute;rdida por mora de la condici&oacute;n de\n");
      out.write("\t\t\t\tbeneficiario titular o familiar, se producir&aacute; autom&aacute;ticamente sin necesidad de comunicaci&oacute;n o reclamo por parte de OSDEPYM.\n");
      out.write("\t\t\t\tSer&aacute; de exclusiva responsabilidad del afiliado el pago de los servicios que hubiera utilizado a partir del vencimiento de la\n");
      out.write("\t\t\t\tobligaci&oacute;n de aporte.\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</li>\n");
      out.write("\t\t<li><div><b>Cambio de cuota por edad:</b></div>\n");
      out.write("\t\t\t<div class=\"content-reglamento\">\n");
      out.write("\t\t\t\tLos beneficiarios que al momento de cumplir los 65 a&ntilde;os de edad tuvieran menos de diez a&ntilde;os (10 a&ntilde;os) ininterrumpidos de\n");
      out.write("\t\t\t\tpermanencia como afiliados de los Planes de Salud Pyme deber&aacute;n abonar a partir del mes siguiente al de su aniversario, una\n");
      out.write("\t\t\t\tnueva cuota mensual con un incremento del 80% (ochenta por ciento). Este incremento se calcular&aacute; sobre el valor vigente a esa\n");
      out.write("\t\t\t\tfecha para un Afiliado Titular Individual del Plan que corresponda y se sumara a la cuota del Grupo Familiar afiliado,\n");
      out.write("\t\t\t\tprocedi&eacute;ndose luego a determinar el pago adicional correspondiente por diferencia entre este nuevo valor de la cuota y los aportes\n");
      out.write("\t\t\t\ty contribuciones percibidas por OSDEPYM.\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</li>\n");
      out.write("\t\t<li><div><b>Domicilio:</b></div>\n");
      out.write("\t\t\t<div class=\"content-reglamento\">\n");
      out.write("\t\t\t\tEl domicilio declarado por el beneficiario en la solicitud de inscripci&oacute;n ser&aacute; considerado como v&aacute;lido tanto a los efectos del envi&oacute;\n");
      out.write("\t\t\t\tde comunicaciones y documentaci&oacute;n como en el referente a la asignaci&oacute;n de los respectivos prestadores de los servicios\n");
      out.write("\t\t\t\tcomprometidos por OSDEPYM, siendo responsabilidad del afiliado titular comunicar cualquier cambio del mismo en forma\n");
      out.write("\t\t\t\tinmediata.\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t<li><div><b>Prestaciones cubiertas:</b></div>\n");
      out.write("\t\t\t<div class=\"content-reglamento\">\n");
      out.write("\t\t\t\tOSDEPYM brindara a sus beneficiarios las prestaciones previstas en el Programa M&eacute;dico Obligatorio, aprobado por la Resoluci&oacute;n\n");
      out.write("\t\t\t\t201/02 MS sus ampliatorias y modificatorias Y 1991/05, del Ministerio de Salud y Ambiente, sus modificatorias y ampliatorias, a\n");
      out.write("\t\t\t\ttrav&eacute;s de sus redes de prestadores y de acuerdo con las condiciones previstas en la Cartillas; teniendo en cuenta el car&aacute;cter\n");
      out.write("\t\t\t\tprogresivo a la cobertura de salud, previsto en la Ley 25.865 y decreto 806/04 o la que en un futuro la reemplace. No tendr&aacute;n\n");
      out.write("\t\t\t\tcobertura los estudios, pr&aacute;cticas y/o instituciones que no integren las redes prestadoras de OSDEPYM, excepto que se hubieran\n");
      out.write("\t\t\t\tautorizado expresamente, OSDEPYM no se responsabiliza de condiciones especiales ni beneficios adicionales que se hubieran\n");
      out.write("\t\t\t\tpactado entre el beneficiario y las redes prestadoras o sus integrantes.\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</li>\n");
      out.write("\t\t<li><div><b>Declaraci&oacute;n Jurada de Salud:</b></div> \n");
      out.write("\t\t\t<div class=\"content-reglamento\">\n");
      out.write("\t\t\t\t\"El falseamiento u ocultamiento de antecedentes de salud en el momento de realizar la solicitud de afiliaci&oacute;n o pase de plan,\n");
      out.write("\t\t\t\tfacultara a la Obra Social en forma inmediata a dejar sin efecto el plan superador contratado, haci&eacute;ndose cargo &uacute;nicamente de lo\n");
      out.write("\t\t\t\testablecido en el Programa M&eacute;dico Obligatorio vigente en el momento de efectivizarte la baja del Plan.\"\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</li>\n");
      out.write("\t\t<li><div><b>Cambios de Plan:</b></div>\n");
      out.write("\t\t\t<div class=\"content-reglamento\">\n");
      out.write("\t\t\t\t<ol type=\"A\">\n");
      out.write("\t\t\t\t\t<li><i>Condiciones Generales:</i>\n");
      out.write("\t\t\t\t\t\tEl beneficiario podr&aacute; optar por un Plan de beneficios superiores en cualquier momento, cumplimentando la respectiva solicitud.\n");
      out.write("\t\t\t\t\t\tNo obstante, para el acceso a dichos beneficios superiores, deber&aacute; mediar la aceptaci&oacute;n expresa de OSDEPYM y el pago de las\n");
      out.write("\t\t\t\t\t\tcuotas adicionales que en cada caso se establezcan, conservando mientras tanto los servicios y beneficios del plan anterior. El\n");
      out.write("\t\t\t\t\t\tcambio de plan registrado es para todo el grupo familiar, no pudiendo ning&uacute;n miembro de dicho grupo tener un plan diferente\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t<li><i>Acceso progresivo a las prestaciones en internaci&oacute;n (Cl&iacute;nica o Quir&uacute;rgica) en el Plan Superior.</i>\n");
      out.write("\t\t\t\t\t\t<ol>\n");
      out.write("\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\tPara las internaciones programadas podr&aacute; hacerlo en los prestadores del Plan Superior a partir de los 6 meses del cambio de Plan.\n");
      out.write("\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\tPara las internaciones por patolog&iacute;as anteriores al cambio de Plan, podr&aacute; hacerlo en los prestadores del Plan Superior a partir de los 24 meses.\n");
      out.write("\t\t\t\t\t\t\t</li>\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t</ol>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t</ol>\n");
      out.write("\t\t\t</div> \t\n");
      out.write("\t\t</li>\n");
      out.write("\t\t<li><div><b>Accidentes, Subrogaci&oacute;n de Derechos:</b></div>\n");
      out.write("\t\t\t<div class=\"content-reglamento\">\n");
      out.write("\t\t\t\tCuando la Obra Social se hiciera cargo de prestaciones originadas en accidentes de tr&aacute;nsito, laborales, o, en general, situaciones\n");
      out.write("\t\t\t\tque legalmente corresponda sean afrontadas por un tercero, el afiliado se obliga a subrogar sus derechos a favor de la misma.\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</li>\n");
      out.write("\t\t<li><div><b>Cambio de Obra Social:</b></div>\n");
      out.write("\t\t\t<div class=\"content-reglamento\">\n");
      out.write("\t\t\t\tEl beneficiario podr&aacute; optar por otra Obra Social, desvincul&aacute;ndose a OSDEPYM en los plazos y por los procedimientos que la\n");
      out.write("\t\t\t\tSuperintendencia de Servicios de Salud u Organismo oficial haya designado a tal efecto, no siendo OSDEPYM responsable de la\n");
      out.write("\t\t\t\tefectivizaci&oacute;n de dicho cambio.\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</li>\n");
      out.write("\t\t<li><div><b>Normas y procedimientos de los prestadores:</b></div>\n");
      out.write("\t\t\t<div class=\"content-reglamento\">\n");
      out.write("\t\t\t\tEl beneficiario deber&aacute; respetar las normas generales de admisi&oacute;n, funcionamiento y horarios, seguir los procedimientos que\n");
      out.write("\t\t\t\ttengan establecidos para la atenci&oacute;n de sus pacientes, los profesionales e instituciones contratados por OSDEPYM para brindarle\n");
      out.write("\t\t\t\tlos servicios comprometidos. No ser&aacute; responsabilidad de OSDEPYM la demora en la atenci&oacute;n u otros inconvenientes que puedan\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</li>\n");
      out.write("\t</ol>\t\t\n");
      out.write("</section> ");
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
