package za.ac.cput.studentaccommodation.services;

import za.ac.cput.studentaccommodation.domain.Payment;

import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
public interface PaymentService {
    List<Payment> getPayments();

    Payment getPayment(Long paymentID);
}
