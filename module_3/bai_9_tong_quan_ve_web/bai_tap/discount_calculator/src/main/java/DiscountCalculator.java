import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/display-discount"})
public class DiscountCalculator extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        Float price = Float.parseFloat(req.getParameter("price"));
        Float percent = Float.parseFloat(req.getParameter("percent"));
        Double discountAmount = price * percent * 0.01;
        Double discountPrice = price - discountAmount;

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h2>Description: " + description + "</h2>");
        writer.println("<h2>List Price: " + price + "</h2>");
        writer.println("<h2>Discount Percent: " + percent + "%</h2>");

        writer.println("<h1>Discount Amount: " + discountAmount + "</h1>");
        writer.println("<h1>Discount Price: " + discountPrice + "</h1>");

        writer.close();
    }
}
