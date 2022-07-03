package com.god.service;

import com.god.pojo.Brand;
import com.god.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;

public interface BrandService {

    List<Brand> selectBrands() throws IOException;

    String addBrand(Brand brand ) throws IOException;

    List<Brand> selectBrand(Brand brand) throws IOException;

    Integer deleteBrand(Brand brand) throws IOException;

    Integer updateBrand(Brand brand) throws IOException;

    Integer deleteByIds( int[] ids) throws IOException;

    PageBean<Brand> selectByPage(int currentPage, int pageSize) throws IOException;

    PageBean<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand) throws IOException;








}
