package controller;

import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"", "/list-customer-servlet"}, name = "listCustomerServler")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "https://th.bing.com/th/id/OIP.tjmIaOF2EOmArmX7Ay9KXQHaF7?w=269&h=215&c=7&r=0&o=5&dpr=1.25&pid=1.7"));
        customers.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "https://th.bing.com/th/id/OIP.tjmIaOF2EOmArmX7Ay9KXQHaF7?w=269&h=215&c=7&r=0&o=5&dpr=1.25&pid=1.7"));
        customers.add(new Customer("Nguyễn Thái Hòa", "1983-08-22", "Nam Định", "https://th.bing.com/th/id/OIP.tjmIaOF2EOmArmX7Ay9KXQHaF7?w=269&h=215&c=7&r=0&o=5&dpr=1.25&pid=1.7"));
        customers.add(new Customer("Trần Đăng Khoa", "1983-08-23", "Hà Tây", "https://th.bing.com/th/id/OIP.tjmIaOF2EOmArmX7Ay9KXQHaF7?w=269&h=215&c=7&r=0&o=5&dpr=1.25&pid=1.7"));
        customers.add(new Customer("Nguyễn Đình Thi", "1983-08-24", "Hà Nội", "https://th.bing.com/th/id/OIP.tjmIaOF2EOmArmX7Ay9KXQHaF7?w=269&h=215&c=7&r=0&o=5&dpr=1.25&pid=1.7"));

        req.setAttribute("listCustomer", customers);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
