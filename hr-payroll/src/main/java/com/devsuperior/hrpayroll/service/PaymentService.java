package com.devsuperior.hrpayroll.service;

import com.devsuperior.hrpayroll.client.WorkerClient;
import com.devsuperior.hrpayroll.domain.Payment;
import com.devsuperior.hrpayroll.domain.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerClient workerClient;

    public Payment getPayment(long workerId, int days) {
        Worker worker = workerClient.findById(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
