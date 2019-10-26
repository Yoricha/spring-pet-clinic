package yorich.springcourse.springpetclinic.services.map;

import org.springframework.stereotype.Service;
import yorich.springcourse.springpetclinic.models.Pet;
import yorich.springcourse.springpetclinic.services.PetService;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet,Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
