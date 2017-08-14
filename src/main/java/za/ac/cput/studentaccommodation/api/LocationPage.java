package za.ac.cput.studentaccommodation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.studentaccommodation.domain.Location;
import za.ac.cput.studentaccommodation.model.LocationResource;
import za.ac.cput.studentaccommodation.services.LocationService;

/**
 * Created by student on 2015/09/13.
 */
@RestController
@RequestMapping("api/location/**")
public class LocationPage
{
    @Autowired
    private LocationService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "Location details";
    }

    @RequestMapping(value = "/{locationID}", method = RequestMethod.GET)
    public LocationResource getLocation(@PathVariable Long locationID)
    {
        LocationResource hateoas;
        Location location = service.getLocation(locationID);
        LocationResource resource = new LocationResource
                .Builder()
                .buildingName(location.getBuildingName())
                .city(location.getCity())
                .street(location.getStreet())
                .cityCode(location.getCityCode())
                .build();

        Link LocationDetails = new
                Link("http://localhost:8080/api/location/" + resource.getLocationID().toString())
                .withRel("locations");

        resource.add(LocationDetails);
        hateoas = resource;

        return hateoas;
    }
}
