package za.ac.cput.studentaccommodation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.studentaccommodation.domain.Payment;
import za.ac.cput.studentaccommodation.model.PaymentResource;
import za.ac.cput.studentaccommodation.services.PaymentService;

/**
 * Created by student on 2015/09/13.
 */
@RestController
@RequestMapping("api/payment/**")
public class PaymentPage
{
    @Autowired
    private PaymentService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "Payment details";
    }

    @RequestMapping(value = "/{paymentID}", method = RequestMethod.GET)
    public PaymentResource getResAdmin(@PathVariable Long paymentID)
    {
        PaymentResource hateoas;
        Payment payment = service.getPayment(paymentID);
        PaymentResource resource = new PaymentResource
                .Builder()
                .amountPaid(payment.getAmountPaid())
                .build();


        Link PaymentDetails = new
                Link("http://localhost:8080/api/payment/" + resource.getPaymentNumber().toString())
                .withRel("payments");

        resource.add(PaymentDetails);
        hateoas = resource;

        return hateoas;
    }
}
