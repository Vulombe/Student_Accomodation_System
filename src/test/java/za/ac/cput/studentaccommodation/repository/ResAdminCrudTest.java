package za.ac.cput.studentaccommodation.repository;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.studentaccommodation.App;
import za.ac.cput.studentaccommodation.conf.factory.ContactAddressFactory;
import za.ac.cput.studentaccommodation.conf.factory.LocationFactory;
import za.ac.cput.studentaccommodation.conf.factory.ResAdminFactory;
import za.ac.cput.studentaccommodation.conf.factory.StudentValidationFactory;
import za.ac.cput.studentaccommodation.domain.ContactAddress;
import za.ac.cput.studentaccommodation.domain.Location;
import za.ac.cput.studentaccommodation.domain.ResAdmin;
import za.ac.cput.studentaccommodation.domain.StudentValidation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ResAdminCrudTest extends AbstractTestNGSpringContextTests
{
    private Long id;
    String studID = "1";
    int numOfSubjects = 3;
    int sum = 190;
    double avg = sum/numOfSubjects;
    StudentValidation validate = StudentValidationFactory.createStudentValidation(studID,avg,numOfSubjects,sum);
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

        ContactAddress contactAddress = ContactAddressFactory.createContactAddress(email,cellNum);
        ResAdmin resAdmin = ResAdminFactory.createResAdminFactory(names, contactAddress,validate);


        repository.save(resAdmin);
        id=resAdmin.getEmpID();
        Assert.assertNotNull(resAdmin.getEmpID());
        Assert.assertEquals("smale@v.com", contactAddress.getEmail());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        ResAdmin resAdmin = repository.findOne(id);
        Assert.assertNotNull(resAdmin.getEmpID());

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        ResAdmin resAdmin = repository.findOne(id);

        String email = "smale@v.com";
        String cellNum = "0828139818";
        ContactAddress newContact = ContactAddressFactory.createContactAddress(email, cellNum);
        ResAdmin newResAdmin = new ResAdmin.Builder().copy(resAdmin).contactAddress(newContact)
                .build();
        repository.save(newResAdmin);

        ResAdmin updatedResAdmin = repository.findOne(id);
        Assert.assertEquals("Jackson", updatedResAdmin.getfName());
        Assert.assertEquals("0828139818", newContact.getCellNumber());

    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        ResAdmin resAdmin = repository.findOne(id);
        repository.delete(resAdmin);
        ResAdmin deletedResAdmin = repository.findOne(id);
        Assert.assertNull(deletedResAdmin);

    }
}
