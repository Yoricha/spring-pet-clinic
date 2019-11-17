package yorich.springcourse.springpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import yorich.springcourse.springpetclinic.models.Owner;
import yorich.springcourse.springpetclinic.repositories.OwnerRepository;
import yorich.springcourse.springpetclinic.repositories.PetRepository;
import yorich.springcourse.springpetclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    private final static String LAST_NAME = "Grisha";
    private final static Long ID = 1L;
    private Owner returnedOwner;

    @BeforeEach
    void setUp() {
        returnedOwner = Owner.builder().id(ID).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);

        Owner owner = service.findByLastName(LAST_NAME);

        assertEquals(owner.getLastName(), LAST_NAME);
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnedOwnersSet = new HashSet<>();

        returnedOwnersSet.add(Owner.builder().id(1L).build());
        returnedOwnersSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnedOwnersSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(owners.size(), 2);
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnedOwner));

        Owner owner = service.findById(ID);

        assertEquals(returnedOwner, owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(2L).build();

        when(ownerRepository.save(any())).thenReturn(ownerToSave);

        Owner savedOwner = service.save(ownerToSave);

        assertEquals(savedOwner,ownerToSave);
    }

    @Test
    void delete() {
        service.delete(returnedOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {

        service.deleteById(ID);
        verify(ownerRepository).deleteById(any());
    }
}