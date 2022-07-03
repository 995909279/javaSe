package com.god.web;

import com.alibaba.fastjson.JSON;
import com.god.pojo.Brand;
import com.god.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.Encoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        BufferedReader reader = req.getReader();
        String jsonBrand = reader.readLine();
        System.out.println(jsonBrand);
        Brand brand = JSON.parseObject(jsonBrand,Brand.class);
        BrandServiceImpl brandService = new BrandServiceImpl();
        String str = brandService.addBrand(brand);

        System.out.println(str);
        resp.getWriter().write(str);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
