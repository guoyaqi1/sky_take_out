package com.sky.mapper;

import com.sky.anotation.AutoFill;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishFlavorMapper {
    

    /**
     * 批量插入口味数据
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * 删除菜品的口味数据
     * @param ids
     */
    void deleteByDishIds(List<Long> ids);

    /**
     * 根据id查询口味数据
     * @param id
     * @return
     */
    @Select("select * from dish_flavor where dish_id=#{dishId}")
    List<DishFlavor> getByDishId(Long id);

    void deleteByDishId(Long id);

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */

}
