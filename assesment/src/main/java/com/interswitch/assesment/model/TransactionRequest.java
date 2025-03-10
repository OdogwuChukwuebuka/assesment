package com.interswitch.assesment.model;

import lombok.Data;

import java.util.Map;

@Data
public class TransactionRequest {
    private String userId;
    private double amount;
    private String paymentMethod; // "CARD", "BANK_TRANSFER", "DIGITAL_WALLET"
    private Map<String, String> paymentDetails;
}
