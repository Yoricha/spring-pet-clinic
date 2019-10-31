package yorich.springcourse.springpetclinic.models;

import java.time.LocalDate;

public class Visit extends BaseEntity{

    private String description;
    private LocalDate date;
    private Pet pet;

    public Visit(String description, LocalDate date, Pet pet) {
        this.description = description;
        this.date = date;
        this.pet = pet;
    }
}
