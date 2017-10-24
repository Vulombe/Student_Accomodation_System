package za.ac.cput.studentaccommodation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.studentaccommodation.domain.Payment;
import za.ac.cput.studentaccommodation.domain.ResAdmin;
import za.ac.cput.studentaccommodation.repository.PaymentRepositroy;
import za.ac.cput.studentaccommodation.repository.ResAdminRepository;
import za.ac.cput.studentaccommodation.restapi.payment.PaymentAPI;
import za.ac.cput.studentaccommodation.services.PaymentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by student on 2015/05/20.
 */
@Service
public class PaymentServiceImpl implements PaymentService
{
    private static PaymentServiceImpl paymentService=null;

    private PaymentServiceImpl(){}

    public  static PaymentServiceImpl getInstance(){
        if(paymentService==null) {
            return new PaymentServiceImpl();
        }
        return paymentService;
    }

    @Override
    public Payment findById(String s) {
        return PaymentAPI.findById(s);
    }

    @Override
    public Payment save(Payment entity) {
        return PaymentAPI.save(entity);
    }

    @Override
    public Payment update(Payment entity) {
        return PaymentAPI.update(entity);
    }

    @Override
    public void delete(Payment entity) {
        PaymentAPI.update(entity);
    }

    @Override
    public Set<Payment> findAll() {
        return PaymentAPI.findAll();
    }
}
