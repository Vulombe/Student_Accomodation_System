package za.ac.cput.studentaccommodation.restapi.studentvalidation;

import za.ac.cput.studentaccommodation.conf.RestUtil;
import za.ac.cput.studentaccommodation.domain.StudentValidation;

import java.util.Set;

public class StudentValidationAPI {
    public static StudentValidation save(StudentValidation studentValidation){
        return RestUtil.save(StudentValidationBaseUrl.StudentValidation.POST, studentValidation, StudentValidation.class);
    }

    public static StudentValidation findById(String id){
        return RestUtil.getById(StudentValidationBaseUrl.StudentValidation.GET,id,StudentValidation.class);
    }
    public static StudentValidation update(StudentValidation studentValidation){
        return RestUtil.update(StudentValidationBaseUrl.StudentValidation.PUT,studentValidation);
    }
    public static Set<StudentValidation> findAll(){
        return RestUtil.getAll(StudentValidationBaseUrl.StudentValidation.GET_ALL,StudentValidation.class);
    }
}

