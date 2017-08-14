package za.ac.cput.studentaccommodation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.studentaccommodation.domain.ResAdmin;
import za.ac.cput.studentaccommodation.model.ResAdminResource;
import za.ac.cput.studentaccommodation.services.ResAdminService;

/**
 * Created by student on 2015/09/13.
 */
@RestController
@RequestMapping("api/resadmin/**")
public class ResAdminPage
{
    @Autowired
    private ResAdminService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "Residence Administrator details";
    }

    @RequestMapping(value = "/{empID}", method = RequestMethod.GET)
    public ResAdminResource getResAdmin(@PathVariable Long empID)
    {
        ResAdminResource hateoas;
        ResAdmin resAdmin = service.getResAdmin(empID);

        ResAdminResource res = new ResAdminResource
                .Builder()
                .fName(resAdmin.getfName())
                .lName(resAdmin.getlName())
                .contactAddress(resAdmin.getContactAddress())
                .validate(resAdmin.getValidate())
                .build();

        Link ResAdminDetails = new
                Link("http://localhost:8080/api/resadmin/" + res.getEmpID().toString())
                .withRel("resadmin");

        res.add(ResAdminDetails);
        hateoas = res;

        return hateoas;

    }
}
