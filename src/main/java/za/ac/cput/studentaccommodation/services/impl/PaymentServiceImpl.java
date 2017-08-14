package za.ac.cput.studentaccommodation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.studentaccommodation.domain.Payment;
import za.ac.cput.studentaccommodation.domain.ResAdmin;
import za.ac.cput.studentaccommodation.repository.PaymentRepositroy;
import za.ac.cput.studentaccommodation.repository.ResAdminRepository;
import za.ac.cput.studentaccommodation.services.PaymentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
@Service
public class PaymentServiceImpl implements PaymentService
{

    @Autowired
    PaymentRepositroy repository;

    public List<Payment> getPayments()
    {
        List<Payment> allPayments = new ArrayList<Payment>();
        Iterable<Payment> payments = repository.findAll();
        for(Payment payment: payments)
            allPayments.add(payment);

        return allPayments;
    }

    public Payment getPayment(Long locationID) {
        return repository.findOne(locationID);
    }
}
