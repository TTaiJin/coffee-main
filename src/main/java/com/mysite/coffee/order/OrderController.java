package com.mysite.coffee.order;

import com.mysite.coffee.delivery.DeliveryService;
import com.mysite.coffee.orderDetail.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderDetailService orderDetailService;
    private final DeliveryService deliveryService;

    @PostMapping("/products")
    public String createOrder(@ModelAttribute OrderRequestDto orderRequestDto) {
        Order order = orderService.save(orderRequestDto);
        return "redirect:/order_detail?id=" + order.getId();
    }

    @GetMapping("/order_detail")
    public String showOrder(@RequestParam("id") Long orderId, Model model) {
        // OrderId로 주문 정보 가져오기
        Order order = orderService.findById(orderId);
        model.addAttribute("order", order);
        return "order_complete";
    }

}
