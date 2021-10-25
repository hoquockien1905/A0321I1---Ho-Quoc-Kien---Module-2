import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/convert"})
public class ConvertCurrency extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double rate = Double.parseDouble(req.getParameter("rate"));
        double usd = Double.parseDouble(req.getParameter("usd"));
        double result = rate * usd;

        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");

        writer.println("<h1> Rate: " + rate + " VND</h1>");
        writer.println("<h1> USD: " + usd + " $</h1>");
        writer.println("<h1> VND: " + result + " VND </h1>");

        writer.close();
    }
}
