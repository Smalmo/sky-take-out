package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.SetmealDish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Zhou
 * @creat 2024-05-14 13:44
 */
@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品id查询套餐
     * @param dishIds
     * @return
     */
    List<Long> getByDishId(List<Long> dishIds);
}
