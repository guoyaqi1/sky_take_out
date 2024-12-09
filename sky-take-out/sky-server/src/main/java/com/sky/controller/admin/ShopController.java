package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:guoyaqi
 * @Date: 2024/10/31 23:39
 */
@RestController("adminShopController")
@Slf4j
@RequestMapping("admin/shop")
@ApiOperation("店铺状态")
public class ShopController {

    public static final String KEY = "SHOP_STATUS";

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 设置店铺的营业状态
     * @param status
     * @return
     */
    @PutMapping("/{status}")
    @ApiOperation("设置店铺的营业状态")
    public Result setStatus(@PathVariable Integer status){
        log.info("设置店铺的营业状态:{}",status==1?"营业中":"打烊中");
        redisTemplate.opsForValue().set("SHOP_STATUS",status);
        return Result.success();
    }

    /**
     * 获取店铺的营业状态
     * @param
     * @return
     */
    @GetMapping("/status")
    @ApiOperation("获取店铺的营业状态")
    public Result<Integer>getStatus(){
        Integer status = (Integer)redisTemplate.opsForValue().get("SHOP_STATUS");
        log.info("获取店铺的营业状态:{}",status==1?"营业中":"打烊中");

        return Result.success(status);
    }
}
