package com.god.service.impl;

import com.alibaba.fastjson.JSON;
import com.god.mapper.BrandMapper;
import com.god.pojo.Brand;
import com.god.pojo.PageBean;
import com.god.service.BrandService;
import com.god.util.DBCon;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class BrandServiceImpl implements BrandService {


    @Override
    public List<Brand> selectBrands() throws IOException {
        SqlSession sqlSession = DBCon.getCon();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        sqlSession.commit();
        sqlSession.close();
        return brands;
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) throws IOException {
        SqlSession sqlSession = DBCon.getCon();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int begin=(currentPage-1)*pageSize;
        int size=pageSize;
        String brandName = brand.getBrandName();
        if (brandName!=null && brandName.length()>0){
            brand.setBrandName("%"+brandName+"%");
        }
        String companyName = brand.getCompanyName();
        if (companyName != null && companyName.length() > 0) {
            brand.setCompanyName("%" + companyName + "%");
        }
        List<Brand> brands = mapper.selectByPageAndCondition(begin, size,brand);
        Integer totalCount = mapper.selectTotalCountByCondition(brand);

        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setRows(brands);
        brandPageBean.setTotalCount(totalCount);
        sqlSession.close();
        return  brandPageBean;

    }

    @Override
    public String addBrand(Brand brand) throws IOException {
        SqlSession sqlSession=DBCon.getCon();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Integer rows = mapper.add(brand);
        sqlSession.commit();
        sqlSession.close();
        if (rows==1){
            return "success";
        }
        return "false";
    }

    @Override
    public List<Brand> selectBrand(Brand brand) throws IOException {
        SqlSession sqlSession=DBCon.getCon();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectByCondition(brand);
        sqlSession.commit();
        sqlSession.close();
        return  brands;
    }

    @Override
    public Integer deleteBrand(Brand brand) throws IOException {
        SqlSession sqlSession=DBCon.getCon();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Integer rows = mapper.delete(brand);
        sqlSession.commit();
        sqlSession.close();
        return  rows;
    }

    @Override
    public Integer updateBrand(Brand brand) throws IOException {
        SqlSession sqlSession=DBCon.getCon();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Integer rows = mapper.delete(brand);
        sqlSession.commit();
        sqlSession.close();
        return  rows;
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) throws IOException {
        SqlSession sqlSession = DBCon.getCon();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectByPage(currentPage, pageSize);
        PageBean<Brand> brandPageBean = new PageBean<>();
        Integer totalCount = mapper.selectTotalCount();
        brandPageBean.setRows(brands);
        brandPageBean.setTotalCount(totalCount);
        sqlSession.close();
        return brandPageBean;
    }

    @Override
    public Integer deleteByIds(int[] ids) throws IOException {
        SqlSession sqlSession=DBCon.getCon();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Integer rows = mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
        return rows;
    }
}
