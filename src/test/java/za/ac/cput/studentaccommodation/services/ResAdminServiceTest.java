package za.ac.cput.studentaccommodation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.studentaccommodation.App;
import za.ac.cput.studentaccommodation.conf.factory.ContactAddressFactory;
import za.ac.cput.studentaccommodation.conf.factory.ResAdminFactory;
import za.ac.cput.studentaccommodation.conf.factory.StudentValidationFactory;
import za.ac.cput.studentaccommodation.domain.ContactAddress;
import za.ac.cput.studentaccommodation.domain.ResAdmin;
import za.ac.cput.studentaccommodation.domain.StudentValidation;
import za.ac.cput.studentaccommodation.repository.ResAdminRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashdyani on 2015/05/29.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ResAdminServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    ResAdminService resAdminService;

    private Long id;
    String studID = "1";
    int numOfSubjects = 3;
    int sum = 190;
    double avg = sum/numOfSubjects;
    StudentValidation validate = StudentValidationFactory.createStudentValidation(studID, avg, numOfSubjects, sum);
    @Autowired
    private ResAdminRepository repository;

    @Test
    public void create() throws Exception {
        //Long empID = 21425147L;
        Map<String,String> names = new HashMap<String, String>();

        names.put("fName","Jackson");
        names.put("lName","Davids");
        String email = "smale@v.com";
        String cellNum = "081147514";

        ContactAddress contactAddress = ContactAddressFactory.createContactAddress(email, cellNum);
        ResAdmin resAdmin = ResAdminFactory.createResAdminFactory(names, contactAddress, validate);


        repository.save(resAdmin);
        id=resAdmin.getEmpID();
        Assert.assertNotNull(resAdmin.getEmpID());
        Assert.assertEquals("smale@v.com", contactAddress.getEmail());

    }
}
