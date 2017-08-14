package za.ac.cput.studentaccommodation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.studentaccommodation.domain.ResAdmin;
import za.ac.cput.studentaccommodation.repository.ResAdminRepository;
import za.ac.cput.studentaccommodation.services.ResAdminService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
@Service
public class ResAdminServiceImpl implements ResAdminService
{
    @Autowired
    ResAdminRepository repository;

    public List<ResAdmin> getResAdmins()
    {
        List<ResAdmin> allResAdmins = new ArrayList<ResAdmin>();
        Iterable<ResAdmin> resAdmins = repository.findAll();
        for(ResAdmin resAdmin: resAdmins)
            allResAdmins.add(resAdmin);

        return allResAdmins;
    }

    public ResAdmin getResAdmin(Long empID)
    {
        return repository.findOne(empID);
    }
}
