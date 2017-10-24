package za.ac.cput.studentaccommodation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.studentaccommodation.domain.Room;
import za.ac.cput.studentaccommodation.repository.RoomRepository;
import za.ac.cput.studentaccommodation.restapi.room.RoomAPI;
import za.ac.cput.studentaccommodation.services.RoomService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by student on 2015/05/20.
 */
@Service
public class RoomServiceImpl implements RoomService
{
    private static RoomServiceImpl roomService=null;

    private RoomServiceImpl(){}

    public  static RoomServiceImpl getInstance(){
        if(roomService==null) {
            return new RoomServiceImpl();
        }
        return roomService;
    }

    @Override
    public Room findById(String s) {
        return RoomAPI.findById(s);
    }

    @Override
    public Room save(Room entity) {
        return RoomAPI.save(entity);
    }

    @Override
    public Room update(Room entity) {
        return RoomAPI.update(entity);
    }

    @Override
    public void delete(Room entity) {
        RoomAPI.update(entity);
    }

    @Override
    public Set<Room> findAll() {
        return RoomAPI.findAll();
    }
}
