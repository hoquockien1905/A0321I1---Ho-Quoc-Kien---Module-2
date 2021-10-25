import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"", "/calculator-servlet"}, name = "calculator")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float firstOpe = Float.parseFloat(req.getParameter("firstOpe"));
        float secondOpe = Float.parseFloat(req.getParameter("secondOpe"));
        char ope = req.getParameter("ope").charAt(0);

        float result = 0;
        try {
            result = Calculator.calculate(firstOpe, secondOpe, ope);
        } catch (Exception e) {
        }

        req.setAttribute("firstOpe", firstOpe);
        req.setAttribute("secondOpe", secondOpe);
        req.setAttribute("ope", ope);
        req.setAttribute("result", result);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
