package com.interswitch.assesment.model;

import lombok.Data;



import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionResponse {
    private String transactionId;
    private String status;
    private String message;
}
