package za.ac.cput.studentaccommodation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.studentaccommodation.App;
import za.ac.cput.studentaccommodation.conf.factory.ContactAddressFactory;
import za.ac.cput.studentaccommodation.conf.factory.PaymentFactory;
import za.ac.cput.studentaccommodation.conf.factory.StudentHomeAddressFactory;
import za.ac.cput.studentaccommodation.domain.ContactAddress;
import za.ac.cput.studentaccommodation.domain.Payment;
import za.ac.cput.studentaccommodation.domain.StudentHomeAddress;
import za.ac.cput.studentaccommodation.repository.PaymentRepositroy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashdyani on 2015/05/29.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class PaymentServiceTest extends AbstractTestNGSpringContextTests{

    @Autowired
    PaymentService paymentService;

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
}
