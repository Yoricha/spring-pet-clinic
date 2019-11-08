package yorich.springcourse.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import yorich.springcourse.springpetclinic.models.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
