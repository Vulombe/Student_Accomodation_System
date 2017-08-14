package za.ac.cput.studentaccommodation.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/04/24.
 */
@Embeddable
public class StudentHomeAddress implements Serializable
{
    private String province;
    private String city;
    private String street;
    private String cityCode;

    private StudentHomeAddress(){}

    public StudentHomeAddress(Builder builder){
        province = builder.province;
        city = builder.city;
        street = builder.street;
        cityCode = builder.cityCode;
    }

    public String getProvince()
    {
        return province;
    }

    public String getStreet() {
        return street;
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getCity() {
        return city;
    }

    public static class Builder
    {
        private String province;
        private String city;
        private String street;
        private String cityCode;

        public Builder city(String value)
        {
            this.city = value;
            return this;
        }

        public Builder street(String value)
        {
            this.street = value;
            return this;
        }

        public Builder cityCode(String value)
        {
            this.cityCode = value;
            return this;
        }

        public Builder province(String value)
        {
            this.province = value;
            return this;
        }

        public Builder copy(StudentHomeAddress value){
            this.province = value.getProvince();
            this.city = value.getCity();
            this.street = value.getStreet();
            this.cityCode = value.getCityCode();

            return this;
        }

        public StudentHomeAddress build(){return new StudentHomeAddress(this);}
    }
}
