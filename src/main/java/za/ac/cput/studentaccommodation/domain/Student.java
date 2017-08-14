package za.ac.cput.studentaccommodation.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * Created by student on 2015/04/16.
 */
@Entity
public class Student implements Serializable
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentID;
    private String lName;
    private String fName;
    private String gender;
    private String levelOfStudy;
    @Embedded
    private ContactAddress contactAddress;
    @Embedded
    private StudentHomeAddress address;
    @OneToMany
    @JoinColumn(name = "student_id")
    private List<Payment> payments;
    @OneToMany
    @JoinColumn(name = "student_id")
    private List<Room> rooms;

    private Student(){}


    public  Student(Builder builder)
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
        public Builder copy(Student value){
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
        public Student build(){
            return new Student(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (!studentID.equals(student.studentID)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return studentID.hashCode();
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", lName='" + lName + '\'' +
                ", fName='" + fName + '\'' +
                ", gender='" + gender + '\'' +
                ", levelOfStudy='" + levelOfStudy + '\'' +
                ", contactAddress=" + contactAddress +
                ", address=" + address +
                '}';
    }
}
