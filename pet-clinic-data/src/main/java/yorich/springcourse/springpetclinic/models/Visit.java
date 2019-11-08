package yorich.springcourse.springpetclinic.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visits")
public class Visit extends BaseEntity{

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Visit(String description, LocalDate date, Pet pet) {
        this.description = description;
        this.date = date;
        this.pet = pet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
