package yorich.springcourse.springpetclinic.services;

import yorich.springcourse.springpetclinic.models.Pet;

import java.util.Set;

public interface PetService {
    Pet findById (Long id);
    Pet save(Pet owner);
    Set<Pet> findAll();
}
