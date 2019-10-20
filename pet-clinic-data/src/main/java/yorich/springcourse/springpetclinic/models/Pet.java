package yorich.springcourse.springpetclinic.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Pet extends BaseEntity{

    private PetType petType;
    private Owner owner;
    private LocalDate birthday;
}
