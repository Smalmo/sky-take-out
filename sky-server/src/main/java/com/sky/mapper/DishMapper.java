package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

    /**
     * 新增菜品
     * @param dish
     */
    @AutoFill(OperationType.INSERT)
    void saveDish(Dish dish);

    /**
     * 菜品分页查询
     * @param dishPageQueryDTO
     * @return
     */
    Page<DishVO> dishPageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 根据id查询菜品
     * @param id
     * @return
     */
    @Select("select * from dish where id = #{id}")
    Dish getById(Long id);

    /**
     * 根据id删除菜品
     * @param dishIds
     */
    void delDishByIds(List<Long> dishIds);
}
