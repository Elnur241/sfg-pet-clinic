package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
