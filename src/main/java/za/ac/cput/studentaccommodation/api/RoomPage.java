package za.ac.cput.studentaccommodation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.studentaccommodation.domain.Room;
import za.ac.cput.studentaccommodation.model.RoomResource;
import za.ac.cput.studentaccommodation.services.RoomService;

import java.io.Serializable;

/**
 * Created by student on 2015/09/13.
 */
@RestController
@RequestMapping("api/room/**")
public class RoomPage
{
    @Autowired
    private RoomService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "Room details";
    }

    @RequestMapping(value = "/{roomID}", method = RequestMethod.GET)
    public RoomResource getResAdmin(@PathVariable Long roomID)
    {
        RoomResource hateoas;
        Room room = service.getRoom(roomID);
        RoomResource resource = new RoomResource
                .Builder()
                .roomType(room.getRoomType())
                .floorNumber(room.getFloorNumber())
                .booking(room.getBooking())
                .build();


                Link RoomDetails = new
                Link("http://localhost:8080/api/room/" + resource.getRoomNumber().toString())
                .withRel("rooms");

        resource.add(RoomDetails);
        hateoas = resource;

        return hateoas;
    }
}
