package za.ac.cput.studentaccommodation.restapi.payment;

import za.ac.cput.studentaccommodation.conf.RestUtil;
import za.ac.cput.studentaccommodation.domain.Payment;

import java.util.Set;

public class PaymentAPI {
    public static Payment save(Payment payment){
        return RestUtil.save(PaymentBaseUrl.Payment.POST, payment, Payment.class);
    }

    public static Payment findById(String id){
        return RestUtil.getById(PaymentBaseUrl.Payment.GET,id,Payment.class);
    }
    public static Payment update(Payment payment){
        return RestUtil.update(PaymentBaseUrl.Payment.PUT,payment);
    }
    public static Set<Payment> findAll(){
        return RestUtil.getAll(PaymentBaseUrl.Payment.GET_ALL,Payment.class);
    }
}
