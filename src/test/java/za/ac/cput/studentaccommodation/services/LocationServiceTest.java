package za.ac.cput.studentaccommodation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.studentaccommodation.App;
import za.ac.cput.studentaccommodation.conf.factory.LocationFactory;
import za.ac.cput.studentaccommodation.domain.Location;
import za.ac.cput.studentaccommodation.repository.LocationRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashdyani on 2015/05/29.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class LocationServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    LocationService locationService;

    private Long id;

    @Autowired
    private LocationRepository repository;

    @Test
    public void create() throws Exception {

        Map<String,String> values = new HashMap<String, String>();

        values.put("buildingName", "SouthPoint");
        values.put("city","Woodstock");

        Location location = LocationFactory.createLocation(values, "Long Street", 7925);

        repository.save(location);
        id=location.getLocationID();
        Assert.assertNotNull(location.getLocationID());
    }

}
