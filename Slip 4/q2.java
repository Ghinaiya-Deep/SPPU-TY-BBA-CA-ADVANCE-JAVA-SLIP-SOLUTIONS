import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class q2 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        
        pw.println("<html><body><h1><b>Information of Server</b></h1>");
        pw.println("<br>Server Name : " + req.getServerName());
        pw.println("<br>Server Port : " + req.getServerPort());
        pw.println("<br>IP Address : " + req.getRemoteAddr());
        pw.println("<br>Client Browser : " + req.getHeader("User-Agent"));
        pw.println("</body></html>");
        
        pw.close();
    }
}
