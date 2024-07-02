package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {
    OwnerServiceMap ownerServiceMap;

    final Long ownerId = 1L;
    final String lastName = "ilyasli";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTyeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastname() {
       Owner ownerFind= ownerServiceMap.findByLastname(lastName);
       assertNotNull(ownerFind);
       assertEquals(ownerId,ownerFind.getId());
    }

    @Test
    void findById() {
        Owner ownerFinded = ownerServiceMap.findById(ownerId);
        assertNotNull(ownerFinded);
        assertEquals(ownerId, ownerFinded.getId());
    }

    @Test
    void saveNoId() {
       Owner ownerSaved= ownerServiceMap.save(Owner.builder().id(2L).build());
        assertNotNull(ownerSaved);
        assertNotNull(ownerSaved.getId());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0, ownerServiceMap.findAll().size());
    }
}