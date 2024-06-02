package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 保存套餐菜品
     * @param setmealDishes
     * @param setmealId
     */
    void save(List<SetmealDish> setmealDishes, Long setmealId);

    /**
     * 删除套餐菜品
     * @param setmealIds
     */
    void delete(List<Long> setmealIds);

    /**
     * 更新套餐菜品
     * @param setmealDish
     */
    void update(SetmealDish setmealDish);

    /**
     * 根据setmealId查询关系
     * @param setmealId
     * @return
     */
    @Select("select * from setmeal_dish where setmeal_id = #{setmealId}")
    List<SetmealDish> getSetmealDishById(Long setmealId);
}
