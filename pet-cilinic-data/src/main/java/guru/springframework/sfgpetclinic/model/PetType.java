package guru.springframework.sfgpetclinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@Table(name="pet_type")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetType  extends BaseEntity{

    private String name;

}
