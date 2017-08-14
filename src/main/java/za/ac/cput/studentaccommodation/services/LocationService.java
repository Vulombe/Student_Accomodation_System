package za.ac.cput.studentaccommodation.services;

import za.ac.cput.studentaccommodation.domain.Location;

import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
public interface LocationService {
    List<Location> getLocations();

    Location getLocation(Long locationID);
}
