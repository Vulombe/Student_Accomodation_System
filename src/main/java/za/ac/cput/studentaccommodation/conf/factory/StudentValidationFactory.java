package za.ac.cput.studentaccommodation.conf.factory;

import za.ac.cput.studentaccommodation.domain.StudentValidation;

import java.util.Map;

/**
 * Created by student on 2015/04/28.
 */
public class StudentValidationFactory
{
    public static StudentValidation createStudentValidation(String studentID,
                                                            double avgPerc,
                                                            int numOfSubjects,
                                                            int sum)
    {
        StudentValidation studentValidation = new StudentValidation
                .Builder()
                .studentID(studentID)
                .avgPerc(avgPerc)
                .subjectNumber(numOfSubjects)
                .sumOfSubjects(sum)
                .build();
        return studentValidation;
    }
}
