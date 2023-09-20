package com.card.forexapp.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.card.forexapp.entity.OrderRequest;
import com.card.forexapp.entity.OrderResponse;
import com.razorpay.Order;

import com.razorpay.RazorpayException;

import com.razorpay.RazorpayClient;

@Service

public class OrderRequestServiceImpl implements OrderRequestService {

	private RazorpayClient client;

	// generate and change keys

	private static final String SECRET_ID1 = "rzp_test_sGsxqvKY8AVB27";

	private static final String SECRET_KEY1 = "iVmdefYLCwKWpE4TsoXqHf9C";

	private static final String SECRET_ID2 = "rzp_test_J4fInjDpTX475d";

	private static final String SECRET_KEY2 = "r8fNXAB78RmsVfdiQbWGwyjr";

	public Order createRazorPayOrder(Double amount) throws RazorpayException {

		// You can enable this if you want to do Auto Capture.

		JSONObject optionOrder = new JSONObject();

		optionOrder.put("amount", amount * 100.0);

		optionOrder.put("currency", "INR");

		optionOrder.put("receipt", "txn_123456");

		optionOrder.put("payment_capture", 1);

		return this.client.orders.create(optionOrder);

	}

	@Override

	public OrderResponse createOrder(OrderRequest orderRequest) throws RazorpayException {

		OrderResponse response = new OrderResponse();

		try {

			if (orderRequest.getAmount().intValue() > 1000) {

				client = new RazorpayClient(SECRET_ID1, SECRET_KEY1);

			} else {

				client = new RazorpayClient(SECRET_ID2, SECRET_KEY2);

			}

			Order order = createRazorPayOrder(orderRequest.getAmount());

			System.out.println("---------------------------");

			String orderId = (String) order.get("id");

			System.out.println("Order ID: " + orderId);

			System.out.println("---------------------------");

			System.out.println(orderRequest.getAmount());

			response.setRazorpayOrderId(orderId);

			response.setApplicationFee("" + orderRequest.getAmount());

			if (orderRequest.getAmount().intValue() > 1000) {

				response.setSecretKey(SECRET_KEY1);

				response.setSecretId(SECRET_ID1);

				response.setPgName("razor1");

			} else {

				response.setSecretKey(SECRET_KEY2);

				response.setSecretId(SECRET_ID2);

				response.setPgName("razor2");

			}

			return response;

		} catch (RazorpayException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		return response;

	}
 
    
	
}
