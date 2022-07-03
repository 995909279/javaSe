package com.god.web;

import com.alibaba.fastjson.JSON;
import com.god.pojo.Brand;
import com.god.service.BrandService;
import com.god.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/select")
public class SelectServlet extends HttpServlet {

    BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf8");
        List<Brand> brands = brandService.selectBrands();
        String jsonString = JSON.toJSONString(brands);
        PrintWriter out = resp.getWriter();
        out.write(jsonString);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
