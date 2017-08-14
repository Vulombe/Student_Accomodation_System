package za.ac.cput.studentaccommodation.services;

import za.ac.cput.studentaccommodation.domain.Room;

import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
public interface RoomService {
    List<Room> getRooms();

    Room getRoom(Long roomID);
}
