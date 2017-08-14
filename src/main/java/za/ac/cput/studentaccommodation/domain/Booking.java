package za.ac.cput.studentaccommodation.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by student on 2015/04/24.
 */
@Embeddable
public class Booking implements Serializable
{
    private String date;
    private String numOfDays;

    private Booking(){}

    public Booking(Builder builder)
    {
        date = builder.date;
        numOfDays = builder.numOfDays;
    }

    public String getNumOfDays() {
        return numOfDays;
    }


    public String getDate() {
        return date;
    }

    public static class Builder
    {
        private String date;
        private String numOfDays;

        public Builder date(String value)
        {
            this.date = value;
            return this;
        }

        public Builder numOfDays(String value)
        {
            this.numOfDays = value;
            return this;
        }

        public Builder copy(Booking value)
        {

            this.numOfDays = value.getNumOfDays();

            return this;
        }

        public  Booking build(){return new Booking(this);}
    }

}
