package za.ac.cput.studentaccommodation.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.studentaccommodation.domain.ContactAddress;
import za.ac.cput.studentaccommodation.domain.Payment;
import za.ac.cput.studentaccommodation.domain.Room;
import za.ac.cput.studentaccommodation.domain.StudentHomeAddress;

import java.util.List;


/**
 * Created by student on 2015/09/13.
 */
public class StudentResource extends ResourceSupport
{
    private Long studentID;
    private String lName;
    private String fName;
    private String gender;
    private String levelOfStudy;
    private ContactAddress contactAddress;
    private StudentHomeAddress address;
    private List<Payment> payments;
    private List<Room> rooms;


    private StudentResource(){}


    public  StudentResource(Builder builder)
    {
        studentID = builder.studentID;
        lName = builder.lName;
        fName = builder.fName;
        gender = builder.gender;
        contactAddress = builder.contactAddress;
        levelOfStudy = builder.levelOfStudy;
        address = builder.address;
        payments = builder.payments;
        rooms = builder.rooms;
    }

    public Long getStudentID() {
        return studentID;
    }

    public String getlName() {
        return lName;
    }

    public String getfName() {
        return fName;
    }

    public String getGender() {
        return gender;
    }

    public ContactAddress getContactAddress() {
        return contactAddress;
    }

    public String getLevelOfStudy() {
        return levelOfStudy;
    }

    public StudentHomeAddress getAddress() {
        return address;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public static class Builder
    {
        private Long studentID;
        private String lName;
        private String fName;
        private String gender;
        private String levelOfStudy;
        private StudentHomeAddress address;
        private ContactAddress contactAddress;
        private List<Payment> payments;
        private List<Room> rooms;

        public Builder studentID(Long value){
            this.studentID = value;
            return this;
        }

        public Builder lName(String value){
            this.lName = value;
            return this;
        }

        public Builder fName(String value){
            this.fName = value;
            return this;
        }

        public Builder gender(String value){
            this.gender = value;
            return this;
        }


        public Builder levelOfStudy(String value){
            this.levelOfStudy = value;
            return this;
        }

        public Builder address(StudentHomeAddress value)
        {
            this.address = value;
            return this;
        }

        public Builder contactAddress(ContactAddress value)
        {
            this.contactAddress = value;
            return this;
        }

        public Builder payments(List<Payment> value)
        {
            this.payments = value;
            return this;
        }

        public Builder rooms(List<Room> value)
        {
            this.rooms = value;
            return this;
        }

        public Builder studentHomeAddress(StudentHomeAddress value)
        {
            this.address = value;
            return this;
        }
        public Builder copy(StudentResource value){
            this.fName = value.getfName();
            this.lName = value.getlName();
            this.studentID = value.getStudentID();
            this.gender = value.getGender();
            this.levelOfStudy = value.getLevelOfStudy();
            this.address = value.getAddress();
            this.contactAddress = value.getContactAddress();
            this.payments = value.getPayments();
            this.rooms = value.getRooms();
            return this;
        }
        public StudentResource build(){
            return new StudentResource(this);
        }
    }
}
