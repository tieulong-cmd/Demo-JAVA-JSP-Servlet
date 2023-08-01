package fpoly.longth.ph16566.controller;

import fpoly.longth.ph16566.entity.MayTinh;
import fpoly.longth.ph16566.repository.MayTinhRepository;
import fpoly.longth.ph16566.service.MayTinhService;
import fpoly.longth.ph16566.service.impl.MayTinhServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "MayTinhServlet",
            value = {
                "/may-tinh/hien-thi",
                "/may-tinh/detail",
                "/may-tinh/remove",
                "/may-tinh/add",
                "/may-tinh/view-update",
                "/may-tinh/update",
            }
)
public class MayTinhServlet extends HttpServlet {
    private MayTinhService mayTinhService = new MayTinhServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")){
            this.hienThiMayTinh(req, resp);
        } else if (uri.contains("detail")) {
            this.detailMayTinh(req, resp);
        } else if (uri.contains("remove")) {
            this.removeMayTinh(req, resp);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(req, resp);
        }
    }

    private void hienThiMayTinh(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maParam = req.getParameter("DetailMa");
        MayTinh mayTinh = mayTinhService.getOne(maParam);
        req.setAttribute("lap", mayTinh);
        List<MayTinh> mayTinhList = mayTinhService.getAll();
        req.setAttribute("mayTinh", mayTinhList);
        req.getRequestDispatcher("/view/MayTinh.jsp").forward(req, resp);
    }

    private void detailMayTinh(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maParam = req.getParameter("DetailMa");
        MayTinh mayTinh = mayTinhService.getOne(maParam);
        req.setAttribute("lap", mayTinh);
        List<MayTinh> mayTinhList = mayTinhService.getAll();
        req.setAttribute("mayTinh", mayTinhList);
        req.getRequestDispatcher("/view/MayTinh.jsp").forward(req, resp);
    }

    private void removeMayTinh(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String maParam = req.getParameter("DeleteMa");
        MayTinh mayTinh = mayTinhService.getOne(maParam);
        mayTinhService.delete(mayTinh);
        resp.sendRedirect("/may-tinh/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maParam = req.getParameter("UpdateMa");
        MayTinh mayTinh = mayTinhService.getOne(maParam);
        req.setAttribute("mt", mayTinh);
        req.getRequestDispatcher("/view/UpdateMayTinh.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")){
            this.addMayTinh(req, resp);
        } else if (uri.contains("update")) {
            this.updateMayTinh(req, resp);
        }
    }

    private void addMayTinh(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tenParam = req.getParameter("ten");
        String giaParam = req.getParameter("gia");
        String boNhoParam = req.getParameter("boNho");
        String mauSacParam = req.getParameter("mauSac");
        String hangParam = req.getParameter("hang");
        String mieuTaParam = req.getParameter("mieuTa");

        MayTinh mayTinh = MayTinh.builder()
                .ten(tenParam)
                .gia(Float.valueOf(giaParam))
                .boNho(boNhoParam)
                .mauSac(mauSacParam)
                .hang(hangParam)
                .mieuTa(mieuTaParam)
                .build();
        mayTinhService.add(mayTinh);
        resp.sendRedirect("/may-tinh/hien-thi");
    }

    private void updateMayTinh(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String maParam = req.getParameter("ma");
        String tenParam = req.getParameter("ten");
        String giaParam = req.getParameter("gia");
        String boNhoParam = req.getParameter("boNho");
        String mauSacParam = req.getParameter("mauSac");
        String hangParam = req.getParameter("hang");
        String mieuTaParam = req.getParameter("mieuTa");


        MayTinh mayTinh = MayTinh.builder()
                .ma(maParam)
                .ten(tenParam)
                .gia(Float.valueOf(giaParam))
                .boNho(boNhoParam)
                .mauSac(mauSacParam)
                .hang(hangParam)
                .mieuTa(mieuTaParam)
                .build();
        mayTinhService.update(mayTinh);
        resp.sendRedirect("/may-tinh/hien-thi");
    }
}
