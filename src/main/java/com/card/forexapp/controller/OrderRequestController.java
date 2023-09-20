package com.card.forexapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.card.forexapp.entity.OrderRequest;
import com.card.forexapp.entity.OrderResponse;
import com.card.forexapp.repository.MyOrderRepository;
import com.card.forexapp.service.OrderRequestService;
import com.razorpay.RazorpayException;

 
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class OrderRequestController {

    @Autowired
    private OrderRequestService orderRequestService;
    
    @Autowired 
    MyOrderRepository myOrderRepo;


    @PostMapping("/createorder")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest)throws RazorpayException {
       

        try {
        	return ResponseEntity.ok(this.orderRequestService.createOrder(orderRequest));

        } catch (RazorpayException e) {
            throw e;
        }
   }
}
