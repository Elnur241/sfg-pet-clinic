package guru.springframework.sfgpetclinic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vets")
public class Vet extends Person {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities",
            joinColumns = { @JoinColumn(name = "vet_id") },
            inverseJoinColumns = { @JoinColumn(name = "speciality_id") })
    private Set<Speciality> specialities=new HashSet<>();
}
