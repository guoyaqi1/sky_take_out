package com.sky.controller.user;

import com.sky.result.Result;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:guoyaqi
 * @Date: 2024/10/31 23:39
 */
@RestController("userShopController")
@Slf4j
@RequestMapping("user/shop")
@ApiOperation("店铺状态")
public class ShopController {

    //public static final String KEY = "SHOP_STATUS";

    @Autowired
    private RedisTemplate redisTemplate;



    /**
     * 获取店铺的营业状态
     * @param
     * @return
     */
    @GetMapping("/status")
    @ApiOperation("获取店铺的营业状态")
    public Result<Integer> getStatus(){
        Integer status = (Integer)redisTemplate.opsForValue().get("SHOP_STATUS");
        log.info("获取店铺的营业状态:{}", status==1 ? "营业中" : "打烊中");

        return Result.success(status);
    }
}
