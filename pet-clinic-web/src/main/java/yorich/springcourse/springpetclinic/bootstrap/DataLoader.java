package yorich.springcourse.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import yorich.springcourse.springpetclinic.models.Owner;
import yorich.springcourse.springpetclinic.models.PetType;
import yorich.springcourse.springpetclinic.models.Vet;
import yorich.springcourse.springpetclinic.services.OwnerService;
import yorich.springcourse.springpetclinic.services.PetTypeService;
import yorich.springcourse.springpetclinic.services.VetService;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Doge");
        PetType savedDog = petTypeService.save(dog);
        PetType cat = new PetType();
        cat.setName("Pussy");
        PetType savedCat = petTypeService.save(cat);

        Owner owner = new Owner();
        owner.setFirstName("Grisha");
        owner.setLastName("Avramov");
        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setFirstName("Timea");
        owner1.setLastName("Toth");
        ownerService.save(owner1);

        Vet vet = new Vet();
        vet.setFirstName("Geza");
        vet.setLastName("Toth");
        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Ildiko");
        vet1.setLastName("Toth");
        vetService.save(vet1);

        System.out.println("Loading data");
    }
}
