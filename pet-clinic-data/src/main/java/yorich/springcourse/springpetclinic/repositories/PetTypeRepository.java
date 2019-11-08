package yorich.springcourse.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import yorich.springcourse.springpetclinic.models.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
