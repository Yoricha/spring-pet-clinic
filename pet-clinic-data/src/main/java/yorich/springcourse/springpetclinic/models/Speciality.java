package yorich.springcourse.springpetclinic.models;

public class Speciality extends BaseEntity{

    private String description;

    public Speciality(String description) {
        this.description = description;
    }
}
