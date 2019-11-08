package yorich.springcourse.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import yorich.springcourse.springpetclinic.models.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
