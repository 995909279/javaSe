package com.god.brandServiceTest;

import com.god.pojo.Brand;
import com.god.service.BrandService;
import com.god.service.impl.BrandServiceImpl;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class BrandServiceTest {

    BrandServiceImpl brandService = new BrandServiceImpl();

    @Test
    public  void  selectBrands() throws IOException {
        List<Brand> brands = brandService.selectBrands();
        for (Brand brand : brands) {
            System.out.println(brand);
        }
    }

    @Test
    public  void  add() throws IOException {
        String s = brandService.addBrand(new Brand());
        System.out.println(s);
    }


}
