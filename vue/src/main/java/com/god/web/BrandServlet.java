package com.god.web;

import com.alibaba.fastjson.JSON;
import com.god.pojo.Brand;
import com.god.pojo.PageBean;
import com.god.service.BrandService;
import com.god.service.impl.BrandServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {

    BrandService brandService=new BrandServiceImpl();

   public void selectAll(HttpServletRequest req,HttpServletResponse resp) throws IOException {
       req.setCharacterEncoding("utf-8");
       resp.setContentType("text/json;charset=utf8");
       List<Brand> brands = brandService.selectBrands();
       String jsonString = JSON.toJSONString(brands);
       PrintWriter out = resp.getWriter();
       out.write(jsonString);
   }
    public void add(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        BufferedReader reader = req.getReader();
        String jsonBrand = reader.readLine();
        Brand brand = JSON.parseObject(jsonBrand,Brand.class);

        String str = brandService.addBrand(brand);
        resp.getWriter().write(str);
   }
    public void update(HttpServletRequest req,HttpServletResponse resp) throws IOException {

        String json = req.getReader().readLine();
        Brand brand = JSON.parseObject(json, Brand.class);
        Integer rows = brandService.updateBrand(brand);
        if (rows==1){
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString("success"));
        }

   }
    public void delete(HttpServletRequest req,HttpServletResponse resp) throws IOException {

        BufferedReader reader = req.getReader();
        String params = reader.readLine();
        Brand brand = JSON.parseObject(params, Brand.class);
        Integer rows = brandService.deleteBrand(brand);
        if (rows==1){
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString("success"));
        }
   }

    public void deleteByIds(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String json = req.getReader().readLine();
        int[] ids = JSON.parseObject(json, int[].class);
        Integer rows = brandService.deleteByIds(ids);
        if (rows==1){
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(JSON.toJSONString("success"));
        }
    }
    public void selectByPage(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        Integer currentPage = Integer.parseInt(req.getParameter("currentPage"));
        Integer pageSize = Integer.parseInt(req.getParameter("pageSize"));
        PageBean<Brand> brandPageBean = brandService.selectByPage(currentPage, pageSize);
        String jsonString = JSON.toJSONString(brandPageBean);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    public void selectByCondition(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String json = req.getReader().readLine();
        Brand brand = JSON.parseObject(json, Brand.class);
        Integer currentPage = Integer.parseInt(req.getParameter("currentPage"));
        Integer pageSize = Integer.parseInt(req.getParameter("pageSize"));
        PageBean<Brand> brandPageBean = brandService.selectByPageAndCondition(currentPage, pageSize, brand);
        resp.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(brandPageBean);
        resp.getWriter().write(jsonString);
    }


}
