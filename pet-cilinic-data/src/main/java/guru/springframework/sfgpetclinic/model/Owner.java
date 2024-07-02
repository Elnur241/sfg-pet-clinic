package guru.springframework.sfgpetclinic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="owners")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Owner extends Person {
    @Column(name="last_name")
    private  String lastName;
    @Column(name="id")
    private  Long id;

    @Column(name="phone")
    private String phone;
    @Column(name="address")
    private String address;
    @Column(name="city")
    private String city;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
   private  Set<Pet> pets =new HashSet<>();
@Builder
    public Owner(String name, String surname, String lastName, String phone, String address, String city, Set<Pet> pets,Long id) {
        super(name, surname);
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.pets = pets;
        this.id=id;
    }

//    public void setPets(Set<Pet> pets) {
//        if (this.pets != null) {
//            this.pets.forEach(pet -> pet.setOwner(null));
//        }
//        if (pets != null) {
//            pets.forEach(pet -> pet.setOwner(this));
//        }
//        this.pets = pets;
//    }

}
