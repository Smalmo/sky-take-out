package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Zhou
 * @creat 2024-05-14 13:44
 */
@Mapper
public interface DishMapper {
    /**
     * 根据id查询菜品数量
     * @param cateogryId
     * @return
     */
    @Select("select count(*) from dish where category_id = #{cateogryId}")
    Integer countByCateogryId(long cateogryId);
}
