package za.ac.cput.studentaccommodation.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/04/16.
 */
@Embeddable
public class StudentValidation implements Serializable
{
    private String studentID;
    private double avgPerc;
    private int subjectNumber;
    private int sumOfSubjects;

    private StudentValidation(){}

    public StudentValidation(Builder builder)
    {
        studentID = builder.studentID;
        avgPerc = builder.avgPerc;
        subjectNumber = builder.subjectNumber;
        sumOfSubjects = builder.sumOfSubjects;
    }

    public String getStudentID() {
        return studentID;
    }

    public double getAvgPerc() {
        return avgPerc;
    }

    public int getSubjectNumber() {
        return subjectNumber;
    }

    public int getSumOfSubjects() {
        return sumOfSubjects;
    }

    public static class Builder
    {
        private String studentID;
        private double avgPerc;
        private int subjectNumber;
        private int sumOfSubjects;

        public Builder studentID(String value)
        {
            this.studentID = value;
            return this;
        }

        public Builder avgPerc(double value){
            this.avgPerc = value;
            return this;
        }

        public Builder subjectNumber(int value)
        {
            this.subjectNumber = value;
            return this;
        }

        public Builder sumOfSubjects(int value)
        {
            this.sumOfSubjects = value;
            return this;
        }

        public Builder copy(StudentValidation value)
        {
            this.studentID = value.getStudentID();
            this.avgPerc = value.getAvgPerc();
            this.subjectNumber = value.getSubjectNumber();
            this.sumOfSubjects = value.getSumOfSubjects();

            return this;
        }

        public StudentValidation build(){return new StudentValidation(this);}
    }
}
