package za.ac.cput.studentaccommodation.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.studentaccommodation.conf.factory.PaymentFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/26.
 */
public class TestPayment
{
    @Test
    public void testCreatePayment() throws Exception {
        Long paymentNum = 14571L;
        double amount = 2000.00;


        List<Student> students = new ArrayList<Student>();
        Payment payment = PaymentFactory.createPayment(amount);

        Assert.assertEquals(2000.00,payment.getAmountPaid(),.00);

    }

    @Test
    public void testUpdatePayment() throws Exception {
        Long paymentNum = 14571L;
        double amount = 3000.00;


        List<Student> students = new ArrayList<Student>();
        Payment payment = PaymentFactory.createPayment(amount);

        Payment newPayment = new Payment.Builder().copy(payment).amountPaid(amount)
                .build();
        
        Assert.assertEquals(3000.00,payment.getAmountPaid(),.00);
        Assert.assertEquals(3000.00,newPayment.getAmountPaid(),.00);
    }
}
