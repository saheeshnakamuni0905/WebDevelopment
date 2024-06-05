import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.Enumeration;
import java.util.Map;

public class TuitionWaiver extends HttpServlet{
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        String term = req.getParameter("term");
        String acaYear = req.getParameter("year");
        String status[] = req.getParameterValues("status");
        String studentName = req.getParameter("studentname");
        String relation = req.getParameter("relation");
        String studentNUID = req.getParameter("studentnuid");
        String employeeName = req.getParameter("employeename");
        String employeeNUID = req.getParameter("employeenuid");
        String department = req.getParameter("department");    
        String location = req.getParameter("location");    
        String phoneNumber = req.getParameter("phonenumber");    
        String supervisor = req.getParameter("supervisor");    
        String program = req.getParameter("section3");    
        
        String r1c1 = req.getParameter("r1cell1");
        String r1c2 = req.getParameter("r1cell2");        
        String r1c3 = req.getParameter("r1cell3");
        String r1c4 = req.getParameter("r1cell4");
        String r1c5 = req.getParameter("r1cell5");
        String r1c6 = req.getParameter("r1cell6");
        String r2c1 = req.getParameter("r2cell1");
        String r2c2 = req.getParameter("r2cell2");
        String r2c3 = req.getParameter("r2cell3");
        String r2c4 = req.getParameter("r2cell4");
        String r2c5 = req.getParameter("r2cell5");
        String r2c6 = req.getParameter("r2cell6");
        String r3c1 = req.getParameter("r3cell1");
        String r3c2 = req.getParameter("r3cell2");
        String r3c3 = req.getParameter("r3cell3");
        String r3c4 = req.getParameter("r3cell4");
        String r3c5 = req.getParameter("r3cell5");
        String r3c6 = req.getParameter("r3cell6");
        
        String empSign = req.getParameter("empsign");
        String sec4date = req.getParameter("date");
        String hrm = req.getParameter("hrm");
        String sec5date = req.getParameter("datesec5");
        
        out.println("<HTML>");
        out.println("<BODY>");
        out.println("<h1>4 Tuition Waiver Form</h1>");
        out.println("<b>Submitted term: </b>"+term+"<BR/>");
        out.println("<b>Submitted year: </b>"+acaYear+"<BR/>");
        out.println("<b>Submitted Status: </b>");
        if (status != null) {
            for (String s : status) {
                out.println(s + " ");
            }
        } else {
            out.println("<b>None selected</b>");
        }
        out.println("<BR/>");
		
        out.println("<b>Submitted student's name: </b>"+studentName+"<BR/>");
        out.println("<b>Submitted relation to employee: </b>"+relation+"<BR/>");
        out.println("<b>Submitted student's NUID: </b>"+studentNUID+"<BR/>");
        out.println("<b>Submitted employee's Name: </b>"+employeeName+"<BR/>");
        out.println("<b>Submitted employee's NUID: </b>"+employeeNUID+"<BR/>");
        out.println("<b>Submitted department: </b>"+department+"<BR/>");
        out.println("<b>Submitted location: </b>"+location+"<BR/>");
        out.println("<b>Submitted phone Number: </b>"+phoneNumber+"<BR/>");
        out.println("<b>Submitted supervisor: </b>"+supervisor+"<BR/>");
        out.println("<b>Submitted program: </b>"+program+"<BR/>");
        
        out.println("<b>Submitted r1cell1: </b>"+r1c1+"<BR/>");
        out.println("<b>Submitted r1cell2: </b>"+r1c2+"<BR/>");
        out.println("<b>Submitted r1cell3: </b>"+r1c3+"<BR/>");
        out.println("<b>Submitted r1cell4: </b>"+r1c4+"<BR/>");
        out.println("<b>Submitted r1cell5: </b>"+r1c5+"<BR/>");
        out.println("<b>Submitted r1cell6: </b>"+r1c6+"<BR/>");
        out.println("<b>Submitted r2cell1: </b>"+r2c1+"<BR/>");
        out.println("<b>Submitted r2cell2: </b>"+r2c2+"<BR/>");
        out.println("<b>Submitted r2cell3: </b>"+r2c3+"<BR/>");
        out.println("<b>Submitted r2cell4: </b>"+r2c4+"<BR/>");
        out.println("<b>Submitted r2cell5: </b>"+r2c5+"<BR/>");
        out.println("<b>Submitted r2cell6: </b>"+r2c6+"<BR/>");
        out.println("<b>Submitted r3cell1: </b>"+r3c1+"<BR/>");
        out.println("<b>Submitted r3cell2: </b>"+r3c2+"<BR/>");
        out.println("<b>Submitted r3cell3: </b>"+r3c3+"<BR/>");
        out.println("<b>Submitted r3cell4: </b>"+r3c4+"<BR/>");
        out.println("<b>Submitted r3cell5: </b>"+r3c5+"<BR/>");
        out.println("<b>Submitted r3cell6: </b>"+r3c6+"<BR/>");
        
        out.println("<b>Submitted empSign: </b>"+empSign+"<BR/>");
        out.println("<b>Submitted date: </b>"+sec4date+"<BR/>");
        out.println("<b>Submitted hrm: </b>"+hrm+"<BR/>");
        out.println("<b>Submitted datesec5: </b>"+sec5date+"<BR/>");
        
        out.println("</BODY>");
        out.println("</HTML>");
    }       
}
