package com.god.web;

import com.alibaba.fastjson.JSON;
import com.god.pojo.Brand;
import com.god.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

//@WebServlet("/selectByCondition")
public class SelectByCondition extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String json = reader.readLine();
        Brand brand = JSON.parseObject(json, Brand.class);
        BrandServiceImpl brandService = new BrandServiceImpl();
        List<Brand> brands = brandService.selectBrand(brand);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(JSON.toJSONString(brands));


    }
}
