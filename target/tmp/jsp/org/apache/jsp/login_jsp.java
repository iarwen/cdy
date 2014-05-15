package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');

	String contextPath = (String) request.getContextPath();

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<title>login</title>\n");
      out.write("<link type=\"text/css\" href=\"/css/reset.css\" rel=\"stylesheet\" />\n");
      out.write("<!--must have for everypage-->\n");
      out.write("<link type=\"text/css\" href=\"/css/home.css\" rel=\"stylesheet\" />\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery-easyui-1.3.5/jquery.min.js\">\n");
      out.write("\t\n");
      out.write("</script>\n");
      out.write("<!--log_tabJS start-->\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\">\n");
      out.write("\tfunction loginSubmit() {\n");
      out.write("\t\tvar loginId = $(\"#loginId\").val();\n");
      out.write("\t\tvar password = $(\"#password\").val();\n");
      out.write("\t\tvar number = $(\"#number\").val();\n");
      out.write("\t\tif (loginId.length < 1) {\n");
      out.write("\t\t\talert(\"用户名不能为空！\");\n");
      out.write("\t\t\treturn false;\n");
      out.write("\t\t}\n");
      out.write("\t\tif (password.length < 1) {\n");
      out.write("\t\t\talert(\"密码不能为空！\");\n");
      out.write("\t\t\treturn false;\n");
      out.write("\t\t}\n");
      out.write("\t\tif (number.length < 1) {\n");
      out.write("\t\t\talert(\"验证码不能为空！\");\n");
      out.write("\t\t\treturn false;\n");
      out.write("\t\t}\n");
      out.write("\t\tvar tar_form = document.getElementById(\"myFrom\");\n");
      out.write("\t\ttar_form.action = \"/userLogin.do?method=login\";\n");
      out.write("\t\ttar_form.submit();\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("\tfunction showing() {\n");
      out.write("\t\tvar url = '/servlet/imageServlet?time=' + Math.random();\n");
      out.write("\t\tdocument.getElementById(\"coding\").src = url;\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("\tif (window != top)\n");
      out.write("\t\ttop.location.href = location.href;\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body class=\"Back\" onload=\"document.getElementById('loginId').focus()\">\n");
      out.write("\t<div class=\"Backstage\">\n");
      out.write("\t\t<div class=\"loginbox\">\n");
      out.write("\t\t\t<form name=\"myFrom\" id=\"myFrom\" method=\"post\"\n");
      out.write("\t\t\t\taction=\"/userLogin.do?method=login\">\n");
      out.write("\t\t\t\t<!--h_ul start-->\n");
      out.write("\t\t\t\t<ul class=\"h_ul login\">\n");
      out.write("\t\t\t\t\t<li><label class=\"form-label\" for=\"loginId\" id=\"login_id_type\">\n");
      out.write("\t\t\t\t\t\t\t用户名： </label> <input type=\"text\" class=\"hors_input_in\" id=\"loginId\"\n");
      out.write("\t\t\t\t\t\tname=\"loginId\" maxlength=\"50\"\n");
      out.write("\t\t\t\t\t\tonkeyup=\"value=value.replace(/[^\\w\\.\\/]/ig,'')\" /></li>\n");
      out.write("\t\t\t\t\t<li><label class=\"form-label\" for=\"password\"> 密码： </label> <input\n");
      out.write("\t\t\t\t\t\ttype=\"password\" class=\"hors_input_in\" id=\"password\" maxlength=\"255\"\n");
      out.write("\t\t\t\t\t\tname=\"password\" /></li>\n");
      out.write("\t\t\t\t\t<li><label class=\"form-label\" for=\"number\"> 验证码： </label> <input\n");
      out.write("\t\t\t\t\t\ttype=\"text\" id=\"number\" name=\"number\" maxlength=\"4\"\n");
      out.write("\t\t\t\t\t\tclass=\"hors_input_in\"> <label class=\"form-label\">\n");
      out.write("\t\t\t\t\t\t\t&nbsp; </label> <img id=\"coding\" alt=\"user code\" src=\"/servlet/imageServlet\" />\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:showing()\"> 看不清，换一张 </a></li>\n");
      out.write("\t\t\t\t\t<li><span style=\"color: #C00; margin: 0px 0px 0px 25px;\">\n");
      out.write("\t\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" </span></li>\n");
      out.write("\t\t\t\t\t<li><label class=\"form-label\"> &nbsp; </label> <input\n");
      out.write("\t\t\t\t\t\ttype=\"button\" value=\" 重置\"\n");
      out.write("\t\t\t\t\t\tonclick=\"document.myFrom.reset()\" class=\"hors_input_btn\" /> <input\n");
      out.write("\t\t\t\t\t\ttype=\"submit\" value=\" 登录\" onclick=\"loginSubmit()\"\n");
      out.write("\t\t\t\t\t\tclass=\"hors_input_btn\" /></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t\t<!--h_ul end-->\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
