package yorich.springcourse.springpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import yorich.springcourse.springpetclinic.models.Speciality;
import yorich.springcourse.springpetclinic.models.Vet;
import yorich.springcourse.springpetclinic.services.SpecialityService;
import yorich.springcourse.springpetclinic.services.VetService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities() != null) {
            if (object.getSpecialities().size() > 0) {
                object.getSpecialities().forEach(speciality -> {
                    if (speciality.getId() == null) {
                        Speciality s = specialityService.save(speciality);
                        s.setId(s.getId());
                    }
                });
            }
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
