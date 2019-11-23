package yorich.springcourse.springpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yorich.springcourse.springpetclinic.models.Vet;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VetMapServiceTest {

    private static final Long VET_ID = 1L;

    VetMapService vetMapService;

    Vet vet;

    @BeforeEach
    void setUp() {
        vetMapService = new VetMapService(new SpecialityMapService());
        vet = Vet.builder().id(VET_ID).build();
        vetMapService.save(vet);
    }

    @Test
    void findAll() {
        Set<Vet> vets = vetMapService.findAll();
        assertEquals(vets.size(), 1);
    }

    @Test
    void deleteById() {
        vetMapService.deleteById(VET_ID);
        assertEquals(vetMapService.findAll().size(), 0);
    }

    @Test
    void delete() {
        vetMapService.delete(vet);
        assertEquals(vetMapService.findAll().size(), 0);
    }

    @Test
    void save() {
        vetMapService.save(Vet.builder().id(2L).build());
        assertEquals(vetMapService.findAll().size(), 2);
    }


    @Test
    void findById() {
        Vet foundVet = vetMapService.findById(VET_ID);
        assertEquals(foundVet, vet);
    }
}