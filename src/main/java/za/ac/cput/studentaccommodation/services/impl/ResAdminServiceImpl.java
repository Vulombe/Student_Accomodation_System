package za.ac.cput.studentaccommodation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.studentaccommodation.domain.ResAdmin;
import za.ac.cput.studentaccommodation.repository.ResAdminRepository;
import za.ac.cput.studentaccommodation.restapi.admnistrator.ResAdminAPI;
import za.ac.cput.studentaccommodation.services.ResAdminService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by student on 2015/05/20.
 */
@Service
public class ResAdminServiceImpl implements ResAdminService
{
    private static ResAdminServiceImpl resAdminService=null;

    private ResAdminServiceImpl(){}

    public  static ResAdminServiceImpl getInstance(){
        if(resAdminService==null) {
            return new ResAdminServiceImpl();
        }
        return resAdminService;
    }

    @Override
    public ResAdmin findById(String s) {
        return ResAdminAPI.findById(s);
    }

    @Override
    public ResAdmin save(ResAdmin entity) {
        return ResAdminAPI.save(entity);
    }

    @Override
    public ResAdmin update(ResAdmin entity) {
        return ResAdminAPI.update(entity);
    }

    @Override
    public void delete(ResAdmin entity) {
        ResAdminAPI.update(entity);
    }

    @Override
    public Set<ResAdmin> findAll() {
        return ResAdminAPI.findAll();
    }
}
