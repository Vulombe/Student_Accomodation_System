package za.ac.cput.studentaccommodation.restapi.room;

import za.ac.cput.studentaccommodation.conf.RestUtil;
import za.ac.cput.studentaccommodation.domain.Room;

import java.util.Set;

public class RoomAPI {
    public static Room save(Room room){
        return RestUtil.save(RoomBaseUrl.Room.POST, room, Room.class);
    }

    public static Room findById(String id){
        return RestUtil.getById(RoomBaseUrl.Room.GET,id,Room.class);
    }
    public static Room update(Room room){
        return RestUtil.update(RoomBaseUrl.Room.PUT,room);
    }
    public static Set<Room> findAll(){
        return RestUtil.getAll(RoomBaseUrl.Room.GET_ALL,Room.class);
    }
}

