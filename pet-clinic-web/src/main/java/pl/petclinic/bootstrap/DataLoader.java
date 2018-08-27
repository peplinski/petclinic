package pl.petclinic.bootstrap;

import pl.petclinic.model.Owner;
import pl.petclinic.model.Pet;
import pl.petclinic.model.PetType;
import pl.petclinic.model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.petclinic.services.OwnerService;
import pl.petclinic.services.PetTypeService;
import pl.petclinic.services.VetService;


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
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType bird = new PetType();
        bird.setName("Bird");
        PetType savedBirdPetType = petTypeService.save(bird);

        Owner owner1 = new Owner();
        owner1.setFirstName("Chris");
        owner1.setLastName("Kowalski");

        ownerService.save(owner1);

        Owner owner2= new Owner();
        owner2.setFirstName("Filip");
        owner2.setLastName("Chajzer");

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Karol");
        owner3.setLastName("Mikulski");

        ownerService.save(owner3);

        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Jymmy");
        vet3.setLastName("Camell");

        vetService.save(vet3);

        System.out.println("Loading Vets........");


    }
}
