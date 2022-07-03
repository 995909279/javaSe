package com.god.mapper;

import com.god.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();

    Integer add(Brand brand);

    List<Brand> selectByCondition(Brand brand);

    Integer delete(Brand brand);

    Integer update(Brand brand);

    Brand selectById(Integer id);

    Integer deleteByIds(@Param("ids") int[] ids);

    List<Brand> selectByPage(@Param("begin") int begin,@Param("size")int size);

    Integer selectTotalCount();

    List<Brand>  selectByPageAndCondition(@Param("begin")int begin,@Param("size")int size,@Param("brand")Brand brand);

    Integer selectTotalCountByCondition(Brand brand);

}
