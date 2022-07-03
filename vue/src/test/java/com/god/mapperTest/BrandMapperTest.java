package com.god.mapperTest;

import com.god.mapper.BrandMapper;
import com.god.pojo.Brand;
import com.god.util.DBCon;
import javafx.util.BuilderFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class BrandMapperTest {

    private  SqlSessionFactory sqlSessionFactory;

    @Test
    public void select() throws IOException {
        SqlSession sqlSession = DBCon.getCon();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> result = mapper.selectAll();
        for (Brand brand : result) {
            System.out.println(brand);
        }
    }

    @Test
    public void  add() throws IOException {
        SqlSession con = DBCon.getCon();
        BrandMapper mapper = con.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setBrandName("张无忌啊");
        brand.setCompanyName("安安");
        brand.setDescription("好吃的");
        brand.setOrdered(100);
        brand.setStatus(1);
        Integer rows = mapper.add(brand);
        System.out.println(rows);
    }

    @Test
    public  void selectByCondition() throws IOException {
        BrandMapper mapper = DBCon.getCon().getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setBrandName("zz");
        brand.setCompanyName("zz");
        List<Brand> brands = mapper.selectByCondition(brand);
        System.out.println(brands);
    }
    @Test
    public void delete() throws IOException {
        BrandMapper mapper = DBCon.getCon().getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setBrandName("zz");
        brand.setCompanyName("zz");
        Integer rows = mapper.delete(brand);
        System.out.println(rows);
    }

    @Test
    public void update() throws IOException {
        BrandMapper mapper = DBCon.getCon().getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setBrandName("zz");
        brand.setId(127);
        brand.setCompanyName("zz");
        Integer rows = mapper.update(brand);
        System.out.println(rows);
    }
}
