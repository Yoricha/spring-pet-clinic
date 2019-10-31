package yorich.springcourse.springpetclinic.models;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person {

    private Set<Pet> pets;

    public Owner(Set<Pet> pets) {
        this.pets = pets;
    }

    public Owner() {
        pets = new HashSet<>();
    }

}
