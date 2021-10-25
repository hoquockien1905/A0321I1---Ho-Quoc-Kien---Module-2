import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/translate"})
public class TranslateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> directory = new HashMap<>();
        directory.put("hello", "Xin chào");
        directory.put("good bye", "Tạm biệt");
        directory.put("see you again", "Hẹn gặp lại");
        directory.put("book", "Sách");
        directory.put("ok", "Được");

        String word = req.getParameter("word");
        PrintWriter writer = resp.getWriter();
        String result = directory.get(word);
        if (result != null) {
            writer.println("Word: " + word);
            writer.println("Result: " + result);
        } else {
            writer.println("Not found!");
        }

        writer.close();
    }
}
