package com.interswitch.assesment.controller;

import com.interswitch.assesment.model.TransactionRequest;
import com.interswitch.assesment.model.TransactionResponse;
import com.interswitch.assesment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public TransactionResponse processPayment(@RequestBody TransactionRequest request) {
        return paymentService.processPayment(request);
    }
}
