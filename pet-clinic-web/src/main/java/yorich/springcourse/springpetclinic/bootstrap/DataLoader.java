package yorich.springcourse.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import yorich.springcourse.springpetclinic.models.Owner;
import yorich.springcourse.springpetclinic.models.Vet;
import yorich.springcourse.springpetclinic.services.OwnerService;
import yorich.springcourse.springpetclinic.services.VetService;
import yorich.springcourse.springpetclinic.services.map.OwnerServiceMap;
import yorich.springcourse.springpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Grisha");
        owner.setLastName("Avramov");
        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Timea");
        owner1.setLastName("Toth");
        ownerService.save(owner1);

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Geza");
        vet.setLastName("Toth");
        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Ildiko");
        vet1.setLastName("Toth");
        vetService.save(vet1);

        System.out.println("Loading data");
    }
}
