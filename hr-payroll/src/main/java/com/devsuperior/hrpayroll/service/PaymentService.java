package com.devsuperior.hrpayroll.service;

import com.devsuperior.hrpayroll.domain.Payment;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days) {
        return new Payment(String.valueOf(workerId), 220.0, days);
    }

}
