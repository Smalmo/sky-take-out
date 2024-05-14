package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Zhou
 * @creat 2024-05-14 13:45
 */
@Mapper
public interface SetmealMapper {
    /**
     * 根据cateogryId查询套餐数量
     * @param cateogryId
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{cateogryId}")
    Integer countByCateogryId(long cateogryId);
}
