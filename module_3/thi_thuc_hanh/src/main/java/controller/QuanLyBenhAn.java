package controller;

import model.bean.BenhAn;
import model.repository.HoSoBenhAnRepository;
import model.service.HoSoBenhAnService;
import model.service.impl.HoSoBenhAnServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {""})
public class QuanLyBenhAn extends HttpServlet {

    HoSoBenhAnService benhAnService = new HoSoBenhAnServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                showFormUpdate(req, resp);
                break;
            default:
                showDanhSachHoSo(req, resp);
        }
    }

    private void showFormUpdate(HttpServletRequest req, HttpServletResponse resp) {
//        List<BenhAn> danhSachBenhAn = this.benhAnService.findAll();
        int id = Integer.parseInt(req.getParameter("id"));
        BenhAn benhAn = this.benhAnService.findByIdBenhAn(id);

        req.setAttribute("benhAn", benhAn);
//        req.setAttribute("danhSachBenhAn", danhSachBenhAn);
        try {
            req.getRequestDispatcher("update.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDanhSachHoSo(HttpServletRequest req, HttpServletResponse resp) {
        List<BenhAn> danhSach = this.benhAnService.findAll();
        req.setAttribute("danhSach", danhSach);

        try {
            req.getRequestDispatcher("list.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
