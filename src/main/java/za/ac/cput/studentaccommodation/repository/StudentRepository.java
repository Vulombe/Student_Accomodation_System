package za.ac.cput.studentaccommodation.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.studentaccommodation.domain.Student;

/**
 * Created by student on 2015/04/25.
 */
public interface StudentRepository extends CrudRepository<Student, Long>
{

    //public Student findById(Long id);
}
