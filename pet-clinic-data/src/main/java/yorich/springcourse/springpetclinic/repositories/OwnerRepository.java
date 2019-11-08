package yorich.springcourse.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import yorich.springcourse.springpetclinic.models.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
