package yorich.springcourse.springpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yorich.springcourse.springpetclinic.models.PetType;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetTypeMapServiceTest {

    private static final Long PET_TYPE_ID = 1L;

    PetTypeMapService petTypeMapService;

    PetType petType;

    @BeforeEach
    void setUp() {
        petTypeMapService = new PetTypeMapService();
        petType = PetType.builder().id(PET_TYPE_ID).build();
        petTypeMapService.save(petType);
    }

    @Test
    void findAll() {
        Set<PetType> petTypes = petTypeMapService.findAll();
        assertEquals(petTypes.size(), 1);
    }

    @Test
    void deleteById() {
        petTypeMapService.deleteById(PET_TYPE_ID);
        assertEquals(petTypeMapService.findAll().size(), 0);
    }

    @Test
    void delete() {
        petTypeMapService.delete(petType);
        assertEquals(petTypeMapService.findAll().size(), 0);
    }

    @Test
    void save() {
        petTypeMapService.save(PetType.builder().id(2L).build());
        assertEquals(petTypeMapService.findAll().size(), 2);
    }

    @Test
    void findById() {
        PetType foundType = petTypeMapService.findById(PET_TYPE_ID);
        assertEquals(foundType, petType);
    }
}