package com.card.forexapp.service;
import com.card.forexapp.entity.OrderRequest;
import com.card.forexapp.entity.OrderResponse;
import com.razorpay.RazorpayException;

 

 

public interface OrderRequestService {

    OrderResponse createOrder (OrderRequest orderRequest)throws RazorpayException;
    //JSONObject createRazorPayOrder (Double amount)throws RazorpayException;

 

}
