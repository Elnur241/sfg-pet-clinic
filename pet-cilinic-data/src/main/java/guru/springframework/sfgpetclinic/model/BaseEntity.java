package guru.springframework.sfgpetclinic.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import jakarta.persistence.MappedSuperclass;
import lombok.Data;


import java.io.Serializable;

@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {  // Ensure it is public
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}