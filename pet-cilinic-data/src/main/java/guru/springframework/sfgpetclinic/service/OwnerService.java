package guru.springframework.sfgpetclinic.service;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

public interface OwnerService  {
    Owner findByLastname(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
