package za.ac.cput.studentaccommodation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.studentaccommodation.domain.Location;
import za.ac.cput.studentaccommodation.domain.ResAdmin;
import za.ac.cput.studentaccommodation.repository.LocationRepository;
import za.ac.cput.studentaccommodation.repository.ResAdminRepository;
import za.ac.cput.studentaccommodation.services.LocationService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    LocationRepository repository;

    public List<Location> getLocations()
    {
        List<Location> allLocations = new ArrayList<Location>();
        Iterable<Location> locations = repository.findAll();
        for(Location location: locations)
            allLocations.add(location);

        return allLocations;
    }

    public Location getLocation(Long locationID)
    {
        return repository.findOne(locationID);
    }
}
