package za.ac.cput.studentaccommodation.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/04/16.
 */
@Entity
public class ResAdmin implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empID;
    private String lName;
    private String fName;
    @Embedded
    private ContactAddress contactAddress;
    @Embedded
    private StudentValidation validate;

    public ResAdmin(){}

    public ResAdmin(Builder builder)
    {
        empID = builder.empID;
        lName = builder.lName;
        fName = builder.fName;
        validate = builder.validate;
        contactAddress = builder.contactAddress;
    }


    public Long getEmpID() {
        return empID;
    }

    public String getlName() {
        return lName;
    }

    public String getfName() {
        return fName;
    }

    public ContactAddress getContactAddress() {
        return contactAddress;
    }

    public StudentValidation getValidate() {
        return validate;
    }

    public static class Builder
    {
        private Long empID;
        private String lName;
        private String fName;
        private StudentValidation validate;
        private ContactAddress contactAddress;

        public Builder empID(Long value)
        {
            this.empID = value;
            return this;
        }

        public Builder lName(String value)
        {
            this.lName = value;
            return this;
        }

        public Builder fName(String value)
        {
            this.fName = value;
            return this;
        }


        public Builder validate(StudentValidation value)
        {
            this.validate = value;
            return this;
        }

        public Builder contactAddress(ContactAddress value)
        {
            this.contactAddress = value;
            return this;
        }
        public Builder copy(ResAdmin value)
        {
            this.empID = value.getEmpID();
            this.lName = value.getlName();
            this.fName = value.getfName();
            this.validate = value.getValidate();
            this.contactAddress = value.getContactAddress();

            return this;
        }

        public ResAdmin build(){return new ResAdmin(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResAdmin)) return false;

        ResAdmin resAdmin = (ResAdmin) o;

        if (!empID.equals(resAdmin.empID)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return empID.hashCode();
    }

    @Override
    public String toString() {
        return "ResAdmin{" +
                "empID=" + empID +
                ", lName='" + lName + '\'' +
                ", fName='" + fName + '\'' +
                ", contactAddress=" + contactAddress +
                ", validate=" + validate +
                '}';
    }
}

