package za.ac.cput.studentaccommodation.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.studentaccommodation.domain.ContactAddress;
import za.ac.cput.studentaccommodation.domain.StudentValidation;


/**
 * Created by student on 2015/09/13.
 */
public class ResAdminResource extends ResourceSupport
{
    private Long empID;
    private String lName;
    private String fName;
    private ContactAddress contactAddress;
    private StudentValidation validate;

    public ResAdminResource(){}

    public ResAdminResource(Builder builder)
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
        public Builder copy(ResAdminResource value)
        {
            this.empID = value.getEmpID();
            this.lName = value.getlName();
            this.fName = value.getfName();
            this.validate = value.getValidate();
            this.contactAddress = value.getContactAddress();

            return this;
        }

        public ResAdminResource build(){return new ResAdminResource(this);}
    }
}
