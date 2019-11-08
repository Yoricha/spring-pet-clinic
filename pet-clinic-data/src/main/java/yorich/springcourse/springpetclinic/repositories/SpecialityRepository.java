package yorich.springcourse.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import yorich.springcourse.springpetclinic.models.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
