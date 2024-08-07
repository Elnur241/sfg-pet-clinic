package guru.springframework.sfgpetclinic.service;

import org.springframework.stereotype.Service;

import java.util.Set;


public interface CrudService<T, ID> {
    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void deleteById(ID id);

    void delete(T object);
}
