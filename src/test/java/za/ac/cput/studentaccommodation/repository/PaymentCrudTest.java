package za.ac.cput.studentaccommodation.repository;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.studentaccommodation.App;
import za.ac.cput.studentaccommodation.conf.factory.*;
import za.ac.cput.studentaccommodation.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class PaymentCrudTest extends AbstractTestNGSpringContextTests
{

    private Long id;

    @Autowired
    private PaymentRepositroy repository;

    @Test
    public void create() throws Exception {
        Long paymentNum = 14571L;
        double amount = 2000.00;

        Map<String,String> names = new HashMap<String, String>();
        Map<String,String> values = new HashMap<String, String>();


        String level = "3rd";

        names.put("fName","Vulombe");
        names.put("lName","Makhubele");

        String email = "vmakhubele@gmail.com";
        String cellNumber = "0828139818";

        ContactAddress contactAddress = ContactAddressFactory.createContactAddress(email, cellNumber);

        values.put("province", "Limpompo");
        values.put("city", "Giyani");
        String street = "Dorset";
        String cityCode = "8000";
        StudentHomeAddress address = StudentHomeAddressFactory.createStudentHomeAddressFactory(values, street, cityCode);


        Payment payment = PaymentFactory.createPayment(amount);

        repository.save(payment);
        id=payment.getPaymentNumber();
        Assert.assertNotNull(payment.getPaymentNumber());
       // Assert.assertEquals(2000.00,payment.getAmountPaid(),.00);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Payment payment = repository.findOne(id);
        Assert.assertNotNull(payment.getAmountPaid());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Payment payment = repository.findOne(id);


        Payment newPayment = new Payment
                .Builder()
                .copy(payment)
                .amountPaid(3000.00)
                .build();

        repository.save(newPayment);

        Payment updatePayment = repository.findOne(id);
        Assert.assertEquals(3000.00, updatePayment.getAmountPaid(),.00);
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Payment payment = repository.findOne(id);
        repository.delete(payment);
        Payment deletedPayment = repository.findOne(id);
        Assert.assertNull(deletedPayment);
    }
}
