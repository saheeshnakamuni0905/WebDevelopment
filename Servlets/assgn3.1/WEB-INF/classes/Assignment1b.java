import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.MultipartConfig;

import java.io.*;
import java.util.Enumeration;
import java.util.Map;

@MultipartConfig
public class Assignment1b extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String user = req.getParameter("email");
		String p = req.getParameter("password");
		String cp = req.getParameter("confirm");
		Part pic= req.getPart("pic");
		
		String gender = req.getParameter("gender");
		String country = req.getParameter("country");
		String hobby[] = req.getParameterValues("hobby");
		String address = req.getParameter("address");
		
		
			
		out.println("<HTML>");
		out.println("<BODY>");
		out.println("<h1>3.1 Form Handler</h1>");
		out.println("<b>Submitted username: </b>"+user+"<BR/>");
		out.println("<b>Submitted password: </b>"+p+"<BR/>");
		out.println("<b>confirm password: </b>"+cp+"<BR>");
		
		if (pic != null) {
			String pictureName = pic.getSubmittedFileName();
			if (pictureName != null && !pictureName.isEmpty()) {
				out.println("<b>File name: </b>" + pictureName + "<BR/>");
			} else {
				out.println("<b>No file selected for upload</b>");
			}
		} else {
			out.println("<b>File input not found in the request</b>");
		}
		
		out.println("<b>Submitted gender: </b>"+gender+"<BR/>");
		out.println("<b>Submitted country: </b>"+country+"<BR/>");
		out.println("<b>Your hobbies: </b>");		
        if (hobby != null) {
            for (String h : hobby) {
                out.println(h + " ");
            }
        } else {
            out.println("<b>None selected</b>");
        }
        out.println("<BR/>");
		out.println("<b>Submitted address: </b>"+ address);
		
		out.println("<h1>3.2 Form Handler using getParameterMap()</h1>" );
		Map<String, String[]> paramMap = req.getParameterMap();
		for (String param : paramMap.keySet()) {
            String[] values = paramMap.get(param);
            out.println("<strong>" + param + "</strong>: ");
            for (int i = 0; i < values.length; i++) {
                out.print(values[i]);
                if (i < values.length - 1) {
                    out.print(", ");
                }
            }
            out.println("<br>");
        }
		
		if (pic != null) {
			String pictureName = pic.getSubmittedFileName();
			if (pictureName != null && !pictureName.isEmpty()) {
				out.println("<b>File name: </b>" + pictureName + "<BR/>");
			} else {
				out.println("<b>No file selected for upload</b>");
			}
		} else {
			out.println("<b>File input not found in the request</b>");
		}
		
		out.println("<h1>3.3 Form Handler using getParameterNames()</h1>" );
		Enumeration<String> parNames = req.getParameterNames();
		while (parNames.hasMoreElements()) {
            String paramName = parNames.nextElement();
            String[] paramValues = req.getParameterValues(paramName);

            out.println("<b>Parameter Name: </b>" + paramName );
            
            if (paramValues != null) {
                for (String paramValue : paramValues) {
                    out.println("<b>Parameter Value: </b>" + paramValue + "<BR/>");
                }
            } else {
                out.println("<b>No value for this parameter</b><BR/>");
            }
        }

		out.println("</BODY>");
		out.println("</HTML>");
	}		
}
