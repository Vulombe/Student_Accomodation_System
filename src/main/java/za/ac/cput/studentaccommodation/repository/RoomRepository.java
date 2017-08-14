package za.ac.cput.studentaccommodation.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.studentaccommodation.domain.Room;

/**
 * Created by student on 2015/05/03.
 */
public interface RoomRepository extends CrudRepository<Room,Long>
{
    //public Room findById(Long id);
}
