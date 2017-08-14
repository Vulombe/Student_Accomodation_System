package za.ac.cput.studentaccommodation.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.studentaccommodation.domain.Location;

/**
 * Created by student on 2015/05/03.
 */
public interface LocationRepository extends CrudRepository<Location,Long>
{
   // public Location findById(Long id);
}
