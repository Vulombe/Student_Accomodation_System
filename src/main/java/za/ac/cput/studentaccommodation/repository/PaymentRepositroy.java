package za.ac.cput.studentaccommodation.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.studentaccommodation.domain.Payment;

/**
 * Created by student on 2015/05/03.
 */
public interface PaymentRepositroy extends CrudRepository<Payment,Long>
{
    //public Payment findById(Long id);
}
