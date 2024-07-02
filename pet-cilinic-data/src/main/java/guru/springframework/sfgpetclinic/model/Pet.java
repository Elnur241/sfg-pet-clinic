package guru.springframework.sfgpetclinic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "pet")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pet extends BaseEntity{

    @ManyToOne
    @JoinColumn(name="type_id")
    private PetType petType;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="owner_id")
    private Owner owner;
    @Column(name = "birth_date")
    private LocalDate birthdate;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")
    private Set<Visit> visitSet=new HashSet<>();

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
