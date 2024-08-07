package guru.springframework.sfgpetclinic.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.SpecialityRepository;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.service.SpecialityService;
import guru.springframework.sfgpetclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile(("springdatajpa"))
public class VetSDJpaService implements VetService {

    private final OwnerRepository ownerRepository;
    private final VetRepository vetRepository;

    public VetSDJpaService(OwnerRepository ownerRepository, VetRepository vetRepository) {
        this.ownerRepository = ownerRepository;
        this.vetRepository = vetRepository;
    }


    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }
}
