package za.ac.cput.studentaccommodation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.studentaccommodation.domain.Room;
import za.ac.cput.studentaccommodation.repository.RoomRepository;
import za.ac.cput.studentaccommodation.services.RoomService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
@Service
public class RoomServiceImpl implements RoomService
{
    @Autowired
    RoomRepository repository;

    public List<Room> getRooms()
    {
        List<Room> allrooms = new ArrayList<Room>();
        Iterable<Room> rooms = repository.findAll();
        for (Room room: rooms)
        {
            allrooms.add(room);
        }

        return allrooms;
    }


    public Room getRoom(Long roomID)
    {
        return repository.findOne(roomID);
    }
}
