package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zhou
 * @creat 2024-05-14 13:26
 */
@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类相关Api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 新增分类
     * @param categoryDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增分类")
    public Result save(@RequestBody CategoryDTO categoryDTO){
        log.info("新增分类：{}",categoryDTO);
        // 调用Service的方法将数据存入数据库
        categoryService.save(categoryDTO);
        return Result.success();
    }

    /**
     * 分类的分页查询
     * @param categoryPageQueryDTODTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分类的分页查询")
    public Result<PageResult> pageQuery(CategoryPageQueryDTO categoryPageQueryDTODTO){
        log.info("分类的分页查询：{}",categoryPageQueryDTODTO);
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTODTO);
        return Result.success(pageResult);
    }

    /**
     * 根据类型查询分类
     * 目前未知调用位置，与pageQuery功能重复
     * @param type
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> list(Integer type){
        log.info("根据类型查询分类：{}",type);
        List<Category> list = categoryService.list(type);
        return Result.success(list);
    }

    /**
     * 根据id删除份额里
     * @param id
     * @return
     */
    @DeleteMapping
    @ApiOperation("根据id删除分类")
    public Result deleteById(long id){
        log.info("根据id删除分类:{}",id);
        categoryService.deleteById(id);
        return Result.success();
    }

    /**
     * 启用、禁用分类
     * @param status
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用、禁用分类")
    public Result startOrStop(@PathVariable Integer status,Long id){
        log.info("启用、禁用分类:{}",status,id);
        categoryService.startOrStop(status, id);
        return Result.success();
    }

    /**
     * 修改分类
     * @param categoryDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改分类")
    public Result update(@RequestBody CategoryDTO categoryDTO){
        log.info("修改分类：{}",categoryDTO);
        categoryService.update(categoryDTO);
        return Result.success();
    }

}
