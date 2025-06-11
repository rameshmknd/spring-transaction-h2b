package com.ramesh.controller;

import com.ramesh.entity.Order;
import com.ramesh.service.OrderProcessingService;
import com.ramesh.service.isolation.ReadCommittedDemo;
import com.ramesh.service.isolation.ReadUncommittedDemo;
import com.ramesh.service.isolation.RepeatableReadDemo;
import com.ramesh.service.isolation.SerializableIsolationDemo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderProcessingController {

    private final OrderProcessingService orderProcessingService;

    private final ReadUncommittedDemo readUncommittedDemo;


    private final ReadCommittedDemo readCommittedDemo;


    private final RepeatableReadDemo repeatableReadDemo;

    private final SerializableIsolationDemo serializableIsolationDemo;


    public OrderProcessingController(OrderProcessingService orderProcessingService,
                                     ReadUncommittedDemo readUncommittedDemo,
                                     ReadCommittedDemo readCommittedDemo,
                                     RepeatableReadDemo repeatableReadDemo,
                                     SerializableIsolationDemo serializableIsolationDemo) {
        this.orderProcessingService = orderProcessingService;
        this.readUncommittedDemo=readUncommittedDemo;
        this.readCommittedDemo=readCommittedDemo;
        this.repeatableReadDemo=repeatableReadDemo;
        this.serializableIsolationDemo=serializableIsolationDemo;
    }

    /**
     * API to place an order
     *
     * @param order the order details
     * @return the processed order with updated total price
     */
    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderProcessingService.placeAnOrder(order));
    }


    @GetMapping("/isolation")
    public String testIsolation() throws InterruptedException {
               serializableIsolationDemo.testSerializableIsolation(1);
        return "success";
    }


}
