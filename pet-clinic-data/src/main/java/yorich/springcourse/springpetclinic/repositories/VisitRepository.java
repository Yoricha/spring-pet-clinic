package yorich.springcourse.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import yorich.springcourse.springpetclinic.models.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
