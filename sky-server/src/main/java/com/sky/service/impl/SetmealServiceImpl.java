package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.Setmeal;
import com.sky.entity.SetmealDish;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.exception.SetmealEnableFailedException;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealDishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.result.PageResult;
import com.sky.service.SetmealService;
import com.sky.vo.DishItemVO;
import com.sky.vo.SetmealVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 套餐业务实现
 */
@Service
@Slf4j
public class SetmealServiceImpl implements SetmealService {

    @Autowired
    private SetmealMapper setmealMapper;
    @Autowired
    private SetmealDishMapper setmealDishMapper;
    @Autowired
    private DishMapper dishMapper;

    /**
     * 条件查询
     * @param setmeal
     * @return
     */
    public List<Setmeal> list(Setmeal setmeal) {
        List<Setmeal> list = setmealMapper.list(setmeal);
        return list;
    }

    /**
     * 根据id查询菜品选项
     * @param id
     * @return
     */
    public List<DishItemVO> getDishItemById(Long id) {
        return setmealMapper.getDishItemBySetmealId(id);
    }

    /**
     * 新增套餐
     * @param setmealDTO
     */
    @Transactional
    public void save(SetmealDTO setmealDTO) {
        Setmeal setmeal = new Setmeal();
        // 将dto中setmeal的数据复制给setmeal
        BeanUtils.copyProperties(setmealDTO,setmeal);
        // 保存setmeal信息
        setmealMapper.save(setmeal);
        // 将dto中的dish信息复制给setmealDishes
        List<SetmealDish> setmealDishes = setmealDTO.getSetmealDishes();
        // 获取存好的套餐id
        Long setmealId = setmeal.getId();
        // 向数据库插入数据
        setmealDishMapper.save(setmealDishes,setmealId);
    }

    /**
     * 批量删除套餐
     * @param ids
     */
    public void delete(List<Long> ids) {
        // 删除套餐菜品
        setmealDishMapper.delete(ids);
        // 删除套餐
        setmealMapper.delete(ids);
    }

    /**
     * 修改套餐
     * @param setmealDTO
     */
    @Transactional
    public void update(SetmealDTO setmealDTO) {

        Setmeal setmeal = new Setmeal();

        // 将dto中setmeal的数据复制给setmeal
        BeanUtils.copyProperties(setmealDTO,setmeal);
        // 保存setmeal信息
        setmealMapper.update(setmeal);
        // 将dto中的dish信息复制给setmealdish
        List<SetmealDish> setmealDishes = setmealDTO.getSetmealDishes();
        // 获取存好的套餐id
         List<Long> setmealId = new ArrayList<>();
         setmealId.add(setmeal.getId());
        // 删除原套餐的菜品
        setmealDishMapper.delete(setmealId);
        // 将菜品存入关系表
        setmealDishMapper.save(setmealDishes,setmealId.get(0));
    }

    /**
     * 套餐分页查询
     * @param setmealPageQueryDTO
     * @return
     */
    public PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO) {
        PageHelper.startPage(setmealPageQueryDTO.getPage(), setmealPageQueryDTO.getPageSize());
        Page<Setmeal> page = setmealMapper.pageQuery(setmealPageQueryDTO);
        List<Setmeal> records = page.getResult();
        long total = page.getTotal();
        return new PageResult(total,records);
    }

    /**
     * 根据id查询套餐
     * @param id
     * @return
     */
    public SetmealVO getSetmealById(Long id) {
        SetmealVO setmealVO = new SetmealVO();
        Setmeal setmeal = setmealMapper.getById(id);

        List<SetmealDish> setmealDishes = setmealDishMapper.getSetmealDishById(id);
        BeanUtils.copyProperties(setmeal,setmealVO);
        setmealVO.setSetmealDishes(setmealDishes);
        return setmealVO;
    }

    /**
     * 套餐起售、停售
     * @param status
     * @param id
     */
    public void startOrStop(Integer status, Long id) {
        Setmeal setmeal = Setmeal.builder()
                .id(id)
                .status(status)
                .build();
        setmealMapper.update(setmeal);
    }
}
