package za.ac.cput.studentaccommodation.conf.factory;

import za.ac.cput.studentaccommodation.domain.Payment;
import za.ac.cput.studentaccommodation.domain.Student;

import java.util.List;

/**
 * Created by student on 2015/04/26.
 */
public class PaymentFactory
{

    public static Payment createPayment(double amountPaid){

        Payment payment = new Payment.Builder()
                                     .amountPaid(amountPaid)
                                     .build();
        return payment;
    }

}
