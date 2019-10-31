package yorich.springcourse.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import yorich.springcourse.springpetclinic.models.Owner;
import yorich.springcourse.springpetclinic.models.Pet;
import yorich.springcourse.springpetclinic.models.PetType;
import yorich.springcourse.springpetclinic.models.Vet;
import yorich.springcourse.springpetclinic.services.OwnerService;
import yorich.springcourse.springpetclinic.services.PetTypeService;
import yorich.springcourse.springpetclinic.services.VetService;

import java.time.LocalDate;


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


        Pet grishaPet = new Pet();
        grishaPet.setPetType(savedCat);
        grishaPet.setBirthday(LocalDate.now());
        grishaPet.setName("Yorich");

        Pet timiPet = new Pet();
        timiPet.setPetType(savedDog);
        timiPet.setBirthday(LocalDate.of(2019,6,8));
        timiPet.setName("Mirtil");

        Owner grisha = new Owner();
        grisha.setFirstName("Grisha");
        grisha.setLastName("Avramov");
        grisha.setAddress("ul. Orlovo gnezdo");
        grisha.setCity("Ruse");
        grisha.setTelephone("+359895363286");
        grisha.getPets().add(grishaPet);
        ownerService.save(grisha);

        Owner timi = new Owner();
        timi.setFirstName("Timea");
        timi.setLastName("Toth");
        timi.setAddress("Alacskai ut");
        timi.setCity("Budapest 1188");
        timi.setTelephone("+362024346124");
        timi.getPets().add(timiPet);
        ownerService.save(timi);

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
