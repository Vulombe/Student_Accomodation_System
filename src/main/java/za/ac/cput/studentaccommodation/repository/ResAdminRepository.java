package za.ac.cput.studentaccommodation.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.studentaccommodation.domain.ResAdmin;

/**
 * Created by student on 2015/05/03.
 */
public interface ResAdminRepository extends CrudRepository<ResAdmin,Long>
{
    //public ResAdmin findById(Long id);
}
