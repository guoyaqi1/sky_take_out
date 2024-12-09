package com.sky.service;

import com.sky.dto.ShoppingCartDTO;
import org.springframework.stereotype.Service;

/**
 * @Author:guoyaqi
 * @Date: 2024/12/8 22:33
 */

public interface ShoppingCartService {
    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);
}
