package yorich.springcourse.springpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yorich.springcourse.springpetclinic.models.Pet;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetMapServiceTest {

    private final static Long PET_ID = 1L;

    Pet pet;

    PetMapService petMapService;

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();
        pet = Pet.builder().id(PET_ID).build();
        petMapService.save(pet);
    }

    @Test
    void findAll() {
        Set<Pet> pets = petMapService.findAll();
        assertEquals(pets.size(), 1);
    }

    @Test
    void deleteById() {
        petMapService.deleteById(PET_ID);
        assertEquals(petMapService.findAll().size(), 0);
    }

    @Test
    void delete() {
        petMapService.delete(pet);
        assertEquals(petMapService.findAll().size(), 0);
    }

    @Test
    void save() {
        petMapService.save(Pet.builder().id(2L).build());
        assertEquals(petMapService.findAll().size(), 2);

    }

    @Test
    void findById() {
        Pet foundPet = petMapService.findById(PET_ID);
        assertEquals(foundPet, pet);
    }
}