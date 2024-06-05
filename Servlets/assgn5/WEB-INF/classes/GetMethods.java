import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class GetMethods extends HttpServlet
{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

        out.println("<HTML>");
        out.println("<BODY>");
		out.println("<h1>Part5</h1>"+"<BR/><BR/>");
		out.println("<h2>getX() methods from HTTPSERVLETREQUEST class</h2>"+"<BR/><BR/>");
		
		out.println("<b>getUserPrincipal() :</b>"+req.getUserPrincipal()+"<BR/>");
		out.println("<b>getQueryString() :</b>"+req.getQueryString()+"<BR/>");
        out.println("<b>getHttpServletMapping() :</b>"+req.getHttpServletMapping()+"<BR/>"); 
        out.println("<b>getContextPath() :</b>"+req.getContextPath()+"<BR/>");
		out.println("<b>getAuthType() :</b>"+req.getAuthType()+"<BR/>");		
		out.println("<b>getCookies() :</b>"+req.getCookies()+"<BR/>");
        out.println("<b>getMethod() :</b>"+req.getMethod()+"<BR/>");
        out.println("<b>getPathTranslated() :</b>"+req.getPathTranslated()+"<BR/>");
        out.println("<b>getSession() :</b>"+req.getSession()+"<BR/>");
        out.println("<b>getRequestURL() :</b>"+req.getRequestURL()+"<BR/>");

		out.println("<h2>Inherited getX() methods from the super interface SERVLETREQUEST</h2>"+"<BR/><BR/>");
        
		out.println("<b>getParameterMap() :</b>"+req.getParameterMap()+"<BR/>");
		out.println("<b>getServerName() :</b>"+req.getServerName()+"<BR/>");
		out.println("<b>getLocale() :</b>"+req.getLocale()+"<BR/>");
        out.println("<b>getCharacterEncoding() :</b>"+req.getCharacterEncoding()+"<BR/>"); 
        out.println("<b>getContentType() :</b>"+req.getContentType()+"<BR/>");
		out.println("<b>getAttributeNames() :</b>"+req.getAttributeNames()+"<BR/>");
		out.println("<b>getInputStream() :</b>"+req.getInputStream()+"<BR/");
        out.println("<b>getDispatcherType() :</b>"+req.getDispatcherType()+"<BR/>");
		out.println("<b>getLocalName() :</b>"+req.getLocalName()+"<BR/>");
		out.println("<b>getDispatcherType() :</b>"+req.getDispatcherType()+"<BR/>");
        
		
        
		out.println("</BODY>");
		out.println("</HTML>");
        
	}

}