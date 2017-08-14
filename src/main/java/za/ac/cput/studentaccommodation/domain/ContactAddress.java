package za.ac.cput.studentaccommodation.domain;

import javax.persistence.Embeddable;

/**
 * Created by student on 2015/04/28.
 */
@Embeddable
public class ContactAddress
{
    private String email;
    private String cellNumber;

    private ContactAddress()
    {}

    public ContactAddress(Builder builder) {
        email=builder.email;
        cellNumber = builder.cellNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public static class Builder{
        private String email;
        private String cellNumber;

        public Builder(String email) {
            this.email = email;
        }

        public Builder cellNumber(String value){
            this.cellNumber=value;
            return this;
        }

        public Builder copy(ContactAddress value){
            this.cellNumber=value.getCellNumber();
            this.email=value.getEmail();
            return this;
        }

        public ContactAddress build(){
            return new ContactAddress(this);
        }
    }
}
