package yorich.springcourse.springpetclinic.models;

import lombok.Data;


public class PetType extends BaseEntity{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
