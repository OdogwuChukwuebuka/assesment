package com.interswitch.assesment.service;


import com.interswitch.assesment.model.TransactionResponse;
import org.springframework.stereotype.Service;

@Service
public class MockPaymentGateway {
    public TransactionResponse processPayment(double amount, String paymentMethod) {
        // Simulate payment processing
        boolean success = Math.random() > 0.1; // 90% success rate
        String transactionId = "TXN" + System.currentTimeMillis();
        String message = success ? "Payment processed successfully" : "Payment failed";

        return TransactionResponse.builder()
                .transactionId(transactionId)
                .status(success ? "SUCCESS" : "FAILED")
                .message(message)
                .build();
    }

}
