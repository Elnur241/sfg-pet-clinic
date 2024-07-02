package guru.springframework.sfgpetclinic.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    String lastName = "Smith";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @Mock
    PetRepository petRepository;

    @InjectMocks
    OwnerSDJpaService ownerService;

    Owner returnOwner;

    @BeforeEach
    void setUp() {

        returnOwner = Owner.builder().id(1L).lastName(lastName).build();
    }

    @Test
    void findByLastname() {
        Owner returnOwner = Owner.builder().id(1L).lastName(lastName).build();
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = ownerService.findByLastname(lastName);
        assertEquals(lastName, smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Optional<Owner> findEd = ownerRepository.findById(1L);
        assertNotNull(findEd);
    }

    @Test
    void save() {
        Owner ownerToSave=Owner.builder().id(1L).build();
        when(ownerRepository.save(ownerToSave)).thenReturn(returnOwner);

       Owner ownerSaved= ownerService.save(ownerToSave);
       assertNotNull(ownerSaved);
    }

    @Test
    void findAll() {
        Set<Owner>ownerHashSet=new HashSet<>();
        ownerHashSet.add(Owner.builder().id(1l).build());
        ownerHashSet.add(Owner.builder().id(2l).build());
        when(ownerRepository.findAll()).thenReturn(ownerHashSet);
       Set<Owner>owners= ownerService.findAll();
       assertNotNull(owners);
       assertEquals(2,owners.size());
    }
}