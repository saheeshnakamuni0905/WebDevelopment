import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.Enumeration;

public class Assignment1 extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<HTML>");
		out.println("<BODY>");
		out.println("<h1>Request Headers</h1>");
		out.println("<ul>");
		Enumeration<String> headerNames = req.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String headerStr = headerNames.nextElement();
			Enumeration<String> headers = req.getHeaders(headerStr);
			while(headers.hasMoreElements()){
				String value = headers.nextElement();
				out.println("<li>"+headerStr+":"+value+"</li>");
			}
		}
		
		out.println("</ul");
		out.println("</BODY>");
		out.println("</HTML>");
	}	
}
