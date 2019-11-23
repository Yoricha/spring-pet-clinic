package yorich.springcourse.springpetclinic.services.map;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yorich.springcourse.springpetclinic.models.Owner;
import yorich.springcourse.springpetclinic.models.Pet;
import yorich.springcourse.springpetclinic.models.Visit;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VisitMapServiceTest {

    private final static Long VISIT_ID = 1L;

    Visit visit;

    VisitMapService visitMapService;


    @BeforeEach
    void setUp() {
        visitMapService = new VisitMapService();
        Pet pet = new Pet();
        pet.setId(2L);
        pet.setOwner(Owner.builder().id(1L).build());
        visit = Visit.builder().id(VISIT_ID).pet(pet).build();
        visitMapService.save(visit);
    }

    @Test
    void findAll() {
        Set<Visit> pets = visitMapService.findAll();
        assertEquals(pets.size(), 1);
    }

    @Test
    void deleteById() {
        visitMapService.deleteById(VISIT_ID);
        assertEquals(visitMapService.findAll().size(), 0);
    }

    @Test
    void delete() {
        visitMapService.delete(visit);
        assertEquals(visitMapService.findAll().size(), 0);
    }

    @Test
    void save() {
        Pet pet2 = new Pet();
        pet2.setId(2L);
        pet2.setOwner(Owner.builder().id(1L).build());
        visit = Visit.builder().id(2L).pet(pet2).build();
        visitMapService.save(visit);
        assertEquals(visitMapService.findAll().size(), 2);
    }

    @Test
    void saveWithoutPetId() {
        Pet pet2 = new Pet();
        pet2.setOwner(Owner.builder().id(1L).build());
        visit = Visit.builder().id(2L).pet(pet2).build();
        Assertions.assertThrows(RuntimeException.class, () -> {
            visitMapService.save(visit);
        });
    }

    @Test
    void saveWithoutOwner() {
        Pet pet2 = new Pet();
        pet2.setId(2L);
        visit = Visit.builder().id(2L).pet(pet2).build();
        Assertions.assertThrows(RuntimeException.class, () -> {
            visitMapService.save(visit);
        });
    }

    @Test
    void saveWithoutPet() {
        visit = Visit.builder().id(2L).build();
        Assertions.assertThrows(RuntimeException.class, () -> {
            visitMapService.save(visit);
        });
    }

    @Test
    void findById() {
        Visit foundPet = visitMapService.findById(VISIT_ID);
        assertEquals(foundPet, visit);
    }

}