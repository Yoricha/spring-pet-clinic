package yorich.springcourse.springpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yorich.springcourse.springpetclinic.models.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    final Long ownerID = 1L;
    final String ownerLastName = "Grisha";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());

        ownerMapService.save(Owner.builder().id(ownerID).lastName(ownerLastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(owners.size(), 1);
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerID);
        assertEquals(owner.getId(), ownerID);
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();

        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void deleteById() {
        ownerMapService.delete(ownerMapService.findById(ownerID));
        assertEquals(ownerMapService.findAll().size(),0);
    }

    @Test
    void delete() {
        ownerMapService.deleteById(ownerID);
        assertEquals(ownerMapService.findAll().size(),0);
    }

    @Test
    void findByLastName() {
        assertEquals(ownerMapService.findByLastName(ownerLastName).getLastName(), ownerLastName);
    }

    @Test
    void findByLastNameNull() {
        assertNull(ownerMapService.findByLastName("Smith"));
    }
}