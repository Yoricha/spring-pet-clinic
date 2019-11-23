package yorich.springcourse.springpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yorich.springcourse.springpetclinic.models.Speciality;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpecialityMapServiceTest {

    private static final Long SPECIALITY_ID = 1L;

    SpecialityMapService specialityMapService;

    Speciality speciality;

    @BeforeEach
    void setUp() {
        specialityMapService = new SpecialityMapService();
        speciality = Speciality.builder().id(SPECIALITY_ID).build();
        specialityMapService.save(speciality);
    }

    @Test
    void findAll() {
        Set<Speciality> specialitySet = specialityMapService.findAll();
        assertEquals(specialitySet.size(), 1);
    }

    @Test
    void deleteById() {
        specialityMapService.deleteById(SPECIALITY_ID);
        assertEquals(specialityMapService.findAll().size(), 0);
    }

    @Test
    void delete() {
        specialityMapService.delete(speciality);
        assertEquals(specialityMapService.findAll().size(), 0);
    }

    @Test
    void save() {
        specialityMapService.save(Speciality.builder().id(2L).build());
        assertEquals(specialityMapService.findAll().size(), 2);
    }

    @Test
    void findById() {
        Speciality foundType = specialityMapService.findById(SPECIALITY_ID);
        assertEquals(foundType, speciality);
    }
}