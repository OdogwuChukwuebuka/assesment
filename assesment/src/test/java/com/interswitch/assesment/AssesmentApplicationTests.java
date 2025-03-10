package com.interswitch.assesment;

import com.interswitch.assesment.model.TransactionRequest;
import com.interswitch.assesment.model.TransactionResponse;
import com.interswitch.assesment.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AssesmentApplicationTests {
	@Autowired
	private PaymentService paymentService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testProcessPayment() {
		TransactionRequest request = new TransactionRequest();
		request.setUserId("user123");
		request.setAmount(100.0);
		request.setPaymentMethod("CARD");

		TransactionResponse response = paymentService.processPayment(request);
		assertNotNull(response.getTransactionId());
	}
}
