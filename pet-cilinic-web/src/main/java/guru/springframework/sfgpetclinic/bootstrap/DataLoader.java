package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.PetTypeService;
import guru.springframework.sfgpetclinic.service.SpecialityService;
import guru.springframework.sfgpetclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

//    public DataLoader() {
//        this.ownerService = new OwnerServiceMap();
//        this.vetService = new VetServiceMap();
//    }

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("afcarka");
        PetType petTypeDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("koska");
        PetType petTypeCat = petTypeService.save(dog);

        Speciality radiology =new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology=specialityService.save(radiology);

        Speciality urgery =new Speciality();
        urgery.setDescription("Urgery");
        Speciality savedUrgery=specialityService.save(urgery);

        Speciality dentistry =new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry=specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setName("Michael");
        owner1.setSurname("Weston");
        owner1.setCity("Baku");
        owner1.setAddress("poxluDere");
        owner1.setPhone("0706384838");

        Pet mikesCat=new Pet();
        mikesCat.setPetType(petTypeDog);
        mikesCat.setOwner(owner1);
        mikesCat.setBirthdate(LocalDate.now());
        mikesCat.setName("Rosco");
        owner1.getPets().add(mikesCat);
//        Set<Pet> cats=new HashSet<>();
//        cats.add(mikesCat);
//        owner1.setPets(cats);


        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setName("Fiona");
        owner2.setSurname("Glenanne");
        owner2.setCity("Balaken");
        owner2.setAddress("poxluDere");
        owner2.setPhone("0706384838");

        Pet fionasCat=new Pet();
        fionasCat.setPetType(petTypeCat);
        fionasCat.setOwner(owner1);
        fionasCat.setBirthdate(LocalDate.now());
        fionasCat.setName("Rosco");
        owner2.getPets().add(fionasCat);

//        Set<Pet> fionasCatSet=new HashSet<>();
//        fionasCatSet.add(fionasCat);
//        owner1.setPets(fionasCatSet);

        ownerService.save(owner2);


        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setName("Sam");
        vet1.setSurname("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setName("Jessie");
        vet2.setSurname("Porter");
        vet1.getSpecialities().add(savedUrgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
