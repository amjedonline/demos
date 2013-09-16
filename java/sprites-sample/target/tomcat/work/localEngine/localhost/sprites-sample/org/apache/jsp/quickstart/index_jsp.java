package org.apache.jsp.quickstart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fstripes_005fform_0026_005ffocus_005fbeanclass;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fstripes_005ftext_0026_005fname_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fstripes_005fsubmit_0026_005fvalue_005fname_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fstripes_005fform_0026_005ffocus_005fbeanclass = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fstripes_005ftext_0026_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fstripes_005fsubmit_0026_005fvalue_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fstripes_005fform_0026_005ffocus_005fbeanclass.release();
    _005fjspx_005ftagPool_005fstripes_005ftext_0026_005fname_005fnobody.release();
    _005fjspx_005ftagPool_005fstripes_005fsubmit_0026_005fvalue_005fname_005fnobody.release();
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
      out.write("<html>\n");
      out.write("  <head><title>My First Stripe</title></head>\n");
      out.write("  <body>\n");
      out.write("    <h1>Stripes Calculator</h1>\n");
      out.write("\n");
      out.write("    Hi, I'm the Stripes Calculator. I can only do addition. Maybe, some day, a nice programmer\n");
      out.write("    will come along and teach me how to do other things?\n");
      out.write("\n");
      out.write("    ");
      if (_jspx_meth_stripes_005fform_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("  </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_stripes_005fform_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  stripes:form
    net.sourceforge.stripes.tag.FormTag _jspx_th_stripes_005fform_005f0 = (net.sourceforge.stripes.tag.FormTag) _005fjspx_005ftagPool_005fstripes_005fform_0026_005ffocus_005fbeanclass.get(net.sourceforge.stripes.tag.FormTag.class);
    _jspx_th_stripes_005fform_005f0.setPageContext(_jspx_page_context);
    _jspx_th_stripes_005fform_005f0.setParent(null);
    // /quickstart/index.jsp(13,4) name = beanclass type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_stripes_005fform_005f0.setBeanclass(new String("com.faktor73.stripes.quickstart.CalculatorActionBean"));
    // /quickstart/index.jsp(13,4) name = focus type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_stripes_005fform_005f0.setFocus("");
    int[] _jspx_push_body_count_stripes_005fform_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_stripes_005fform_005f0 = _jspx_th_stripes_005fform_005f0.doStartTag();
      if (_jspx_eval_stripes_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_stripes_005fform_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_push_body_count_stripes_005fform_005f0[0]++;
          _jspx_th_stripes_005fform_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_stripes_005fform_005f0.doInitBody();
        }
        do {
          out.write("\n");
          out.write("        <table>\n");
          out.write("            <tr>\n");
          out.write("                <td>Number 1:</td>\n");
          out.write("                <td>");
          if (_jspx_meth_stripes_005ftext_005f0(_jspx_th_stripes_005fform_005f0, _jspx_page_context, _jspx_push_body_count_stripes_005fform_005f0))
            return true;
          out.write("</td>\n");
          out.write("            </tr>\n");
          out.write("            <tr>\n");
          out.write("                <td>Number 2:</td>\n");
          out.write("                <td>");
          if (_jspx_meth_stripes_005ftext_005f1(_jspx_th_stripes_005fform_005f0, _jspx_page_context, _jspx_push_body_count_stripes_005fform_005f0))
            return true;
          out.write("</td>\n");
          out.write("            </tr>\n");
          out.write("            <tr>\n");
          out.write("                <td colspan=\"2\">\n");
          out.write("                    ");
          if (_jspx_meth_stripes_005fsubmit_005f0(_jspx_th_stripes_005fform_005f0, _jspx_page_context, _jspx_push_body_count_stripes_005fform_005f0))
            return true;
          out.write("                    \n");
          out.write("                </td>\n");
          out.write("            </tr>\n");
          out.write("            <tr>\n");
          out.write("                <td>Result:</td>\n");
          out.write("                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${actionBean.result}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("            </tr>\n");
          out.write("        </table>\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_stripes_005fform_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_stripes_005fform_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
          _jspx_push_body_count_stripes_005fform_005f0[0]--;
        }
      }
      if (_jspx_th_stripes_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_stripes_005fform_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_stripes_005fform_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_stripes_005fform_005f0.doFinally();
      _005fjspx_005ftagPool_005fstripes_005fform_0026_005ffocus_005fbeanclass.reuse(_jspx_th_stripes_005fform_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_stripes_005ftext_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_stripes_005fform_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_stripes_005fform_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  stripes:text
    net.sourceforge.stripes.tag.InputTextTag _jspx_th_stripes_005ftext_005f0 = (net.sourceforge.stripes.tag.InputTextTag) _005fjspx_005ftagPool_005fstripes_005ftext_0026_005fname_005fnobody.get(net.sourceforge.stripes.tag.InputTextTag.class);
    _jspx_th_stripes_005ftext_005f0.setPageContext(_jspx_page_context);
    _jspx_th_stripes_005ftext_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_stripes_005fform_005f0);
    // /quickstart/index.jsp(17,20) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_stripes_005ftext_005f0.setName("numberOne");
    int[] _jspx_push_body_count_stripes_005ftext_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_stripes_005ftext_005f0 = _jspx_th_stripes_005ftext_005f0.doStartTag();
      if (_jspx_th_stripes_005ftext_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_stripes_005ftext_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_stripes_005ftext_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_stripes_005ftext_005f0.doFinally();
      _005fjspx_005ftagPool_005fstripes_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_stripes_005ftext_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_stripes_005ftext_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_stripes_005fform_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_stripes_005fform_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  stripes:text
    net.sourceforge.stripes.tag.InputTextTag _jspx_th_stripes_005ftext_005f1 = (net.sourceforge.stripes.tag.InputTextTag) _005fjspx_005ftagPool_005fstripes_005ftext_0026_005fname_005fnobody.get(net.sourceforge.stripes.tag.InputTextTag.class);
    _jspx_th_stripes_005ftext_005f1.setPageContext(_jspx_page_context);
    _jspx_th_stripes_005ftext_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_stripes_005fform_005f0);
    // /quickstart/index.jsp(21,20) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_stripes_005ftext_005f1.setName("numberTwo");
    int[] _jspx_push_body_count_stripes_005ftext_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_stripes_005ftext_005f1 = _jspx_th_stripes_005ftext_005f1.doStartTag();
      if (_jspx_th_stripes_005ftext_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_stripes_005ftext_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_stripes_005ftext_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_stripes_005ftext_005f1.doFinally();
      _005fjspx_005ftagPool_005fstripes_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_stripes_005ftext_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_stripes_005fsubmit_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_stripes_005fform_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_stripes_005fform_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  stripes:submit
    net.sourceforge.stripes.tag.InputSubmitTag _jspx_th_stripes_005fsubmit_005f0 = (net.sourceforge.stripes.tag.InputSubmitTag) _005fjspx_005ftagPool_005fstripes_005fsubmit_0026_005fvalue_005fname_005fnobody.get(net.sourceforge.stripes.tag.InputSubmitTag.class);
    _jspx_th_stripes_005fsubmit_005f0.setPageContext(_jspx_page_context);
    _jspx_th_stripes_005fsubmit_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_stripes_005fform_005f0);
    // /quickstart/index.jsp(25,20) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_stripes_005fsubmit_005f0.setName("addition");
    // /quickstart/index.jsp(25,20) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_stripes_005fsubmit_005f0.setValue("Add");
    int[] _jspx_push_body_count_stripes_005fsubmit_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_stripes_005fsubmit_005f0 = _jspx_th_stripes_005fsubmit_005f0.doStartTag();
      if (_jspx_th_stripes_005fsubmit_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_stripes_005fsubmit_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_stripes_005fsubmit_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_stripes_005fsubmit_005f0.doFinally();
      _005fjspx_005ftagPool_005fstripes_005fsubmit_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_stripes_005fsubmit_005f0);
    }
    return false;
  }
}
