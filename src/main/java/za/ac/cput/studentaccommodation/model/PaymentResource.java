package za.ac.cput.studentaccommodation.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.studentaccommodation.domain.Student;


import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public class PaymentResource extends ResourceSupport
{

    private Long paymentNumber;
    private double amountPaid;


    private PaymentResource(){}

    public PaymentResource (Builder builder)
    {
        paymentNumber = builder.paymentNumber;
        amountPaid = builder.amountPaid;
    }

    public Long getPaymentNumber() {
        return paymentNumber;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public static class Builder{
        private Long paymentNumber;
        private double amountPaid;
        private List<Student> students;

        public Builder paymentNumber(Long value)
        {
            this.paymentNumber = value;
            return this;
        }

        public Builder amountPaid(double value)
        {
            this.amountPaid = value;
            return this;
        }

        public Builder students(List<Student> value)
        {
            this.students = value;
            return this;
        }

        public Builder copy(PaymentResource value){
            this.amountPaid = value.getAmountPaid();
            this.paymentNumber = value.getPaymentNumber();

            return this;
        }

        public PaymentResource build(){return new PaymentResource(this);}
    }
}
