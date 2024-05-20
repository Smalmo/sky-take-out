package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @author Zhou
 * @creat 2024-05-14 13:44
 */
@Mapper
public interface DishFlavorMapper {

    /**
     * 添加口味
     * @param flavors
     */
    void insertFlavors(List<DishFlavor> flavors);

    /**
     * 根据菜品id删除口味
     * @param dishIds
     */
    void delFlavorByDishIds(List<Long> dishIds);

    /**
     * 根据菜品id查询口味
     * @param dishId
     * @return
     */
    @Select("select * from dish_flavor where dish_id = #{dishId}")
    List<DishFlavor> getByDishId(Long dishId);
}
