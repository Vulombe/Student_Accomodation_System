package za.ac.cput.studentaccommodation.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/16.
 */
@Entity
public class Payment implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentNumber;
    private double amountPaid;


    private Payment(){}

    public Payment (Builder builder)
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

        public Builder copy(Payment value){
            this.amountPaid = value.getAmountPaid();
            this.paymentNumber = value.getPaymentNumber();

            return this;
        }

        public Payment build(){return new Payment(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;

        Payment payment = (Payment) o;

        if (!paymentNumber.equals(payment.paymentNumber)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return paymentNumber.hashCode();
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentNumber=" + paymentNumber +
                ", amountPaid=" + amountPaid +
                '}';
    }
}
