package za.ac.cput.studentaccommodation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.studentaccommodation.domain.Location;
import za.ac.cput.studentaccommodation.domain.ResAdmin;
import za.ac.cput.studentaccommodation.repository.LocationRepository;
import za.ac.cput.studentaccommodation.repository.ResAdminRepository;
import za.ac.cput.studentaccommodation.restapi.location.LocationAPI;
import za.ac.cput.studentaccommodation.services.LocationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by student on 2015/05/20.
 */
@Service
public class LocationServiceImpl implements LocationService{

    private static LocationServiceImpl locationService=null;

    private LocationServiceImpl(){}

    public  static LocationServiceImpl getInstance(){
        if(locationService==null) {
            return new LocationServiceImpl();
        }
        return locationService;
    }

    @Override
    public Location findById(String s) {
        return LocationAPI.findById(s);
    }

    @Override
    public Location save(Location entity) {
        return LocationAPI.save(entity);
    }

    @Override
    public Location update(Location entity) {
        return LocationAPI.update(entity);
    }

    @Override
    public void delete(Location entity) {
        LocationAPI.update(entity);
    }

    @Override
    public Set<Location> findAll() {
        return LocationAPI.findAll();
    }
}
