package com.interswitch.assesment.service;


import com.interswitch.assesment.model.Transaction;
import com.interswitch.assesment.model.TransactionRequest;
import com.interswitch.assesment.model.TransactionResponse;
import com.interswitch.assesment.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private MockPaymentGateway mockPaymentGateway;

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionResponse processPayment(TransactionRequest request) {
        // Process payment via mock gateway
        TransactionResponse response = mockPaymentGateway.processPayment(request.getAmount(), request.getPaymentMethod());

        // Save transaction to database
        Transaction transaction = new Transaction();
        transaction.setTransactionId(response.getTransactionId());
        transaction.setUserId(request.getUserId());
        transaction.setAmount(request.getAmount());
        transaction.setPaymentMethod(request.getPaymentMethod());
        transaction.setStatus(response.getStatus());
        transactionRepository.save(transaction);

        return response;
    }
}
