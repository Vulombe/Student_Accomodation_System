package za.ac.cput.studentaccommodation.services;
import java.util.Set;
public interface Service<E, ID>
{
    E findById(ID id);

    E save(E entity);

    E update(E entity);

    void delete(E entity);

    Set<E> findAll();
}
