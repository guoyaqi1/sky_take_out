package com.sky.controller.user;

import com.sky.dto.OrdersPaymentDTO;
import com.sky.dto.OrdersSubmitDTO;
import com.sky.entity.OrderDetail;
import com.sky.entity.Orders;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.OrderService;
import com.sky.vo.OrderPaymentVO;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:guoyaqi
 * @Date: 2024/12/15 0:58
 */
@RestController("userOrderController")
@RequestMapping("/user/order")
@ApiOperation("用户端接口")
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/submit")
    @ApiOperation("用户下单")
    public Result<OrderSubmitVO> submit(@PathVariable OrdersSubmitDTO ordersSubmitDTO){
        log.info("用户下单，参数为:{}",ordersSubmitDTO);
        OrderSubmitVO orderSubmitVO = orderService.submitOrder(ordersSubmitDTO);
        return Result.success(orderSubmitVO);
    }

    /**
     * 用户支付
     * @param ordersPaymentDTO
     * @return
     */
    @PutMapping("/payment")
    @ApiOperation("微信支付")
    public Result<OrderPaymentVO> payment(@PathVariable OrdersPaymentDTO ordersPaymentDTO) throws Exception {
        log.info("用户支付，参数为:{}",ordersPaymentDTO);
        OrderPaymentVO orderPaymentVO = orderService.payement(ordersPaymentDTO);
        return Result.success(orderPaymentVO);
    }


    /**
     * 支历史订单查询
     * @param
     */
    @GetMapping("/historyOrders")
    @ApiOperation("历史订单查询")
    public Result<PageResult> page(int page,int pageSize,int status){
        PageResult pageResult =orderService.pageQuery4User(page,pageSize,status);
        return Result.success(pageResult);

    }

    /**
     * 订单详情查询
     * @param id
     * @return
     */
    @GetMapping("/orderDetail/{id}")
    @ApiOperation("订单详情查询")
    public Result<OrderVO> details(@PathVariable("id") Long id){
        OrderVO orderVO = orderService.details(id);
        return Result.success(orderVO);
    }


    /**
     * 取消订单
     * @param id
     * @return
     * @throws Exception
     */
    @PutMapping("/cancel/{id}")
    @ApiOperation("取消订单")
    public Result cancel(@PathVariable("id") Long id) throws Exception {
        orderService.userCancelById(id);
        return Result.success();
    }

    /**
     * 用户再来一单
     * 再来一单就是将原订单中的商品重新加入到购物车中
     * @param id
     * @return
     * @throws Exception
     */
    @PutMapping("/repetition/{id}")
    @ApiOperation("用户再来一单")
    public Result repetition(@PathVariable("id") Long id) throws Exception {
        orderService.repetition(id);
        return Result.success();
    }

    /**
     * 用户催单
     * @param id
     * @return
     */
    @GetMapping("/reminder/{id}")
    @ApiOperation("用户催单")
    public Result reminder(@PathVariable("id") Long id){
        orderService.reminder(id);
        return Result.success();
    }
}
