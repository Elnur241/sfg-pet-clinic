package guru.springframework.sfgpetclinic.springdatajpa;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.service.PetService;
import guru.springframework.sfgpetclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile(("springdatajpa"))
public class PetTypeSDJpaService implements PetTypeService {

    private final OwnerRepository ownerRepository;
    private final PetTypeRepository petTypeRepository;
    private final PetRepository petRepository;

    public PetTypeSDJpaService(OwnerRepository ownerRepository, PetTypeRepository petTypeRepository,
                               PetRepository petRepository) {
        this.ownerRepository = ownerRepository;
        this.petTypeRepository = petTypeRepository;
        this.petRepository = petRepository;
    }


    @Override
    public Set<PetType> findAll() {
        Set<PetType>petTypes=new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }

    @Override
    public void delete(PetType object) {
      petTypeRepository.delete(object);
    }
}
