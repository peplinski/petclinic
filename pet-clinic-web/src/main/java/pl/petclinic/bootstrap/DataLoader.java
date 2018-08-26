package pl.petclinic.bootstrap;

import pl.petclinic.model.Owner;
import pl.petclinic.model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.petclinic.services.OwnerService;
import pl.petclinic.services.VetService;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Chris");
        owner1.setLastName("Kowalski");

        ownerService.save(owner1);

        Owner owner2= new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Filip");
        owner2.setLastName("Chajzer");

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setId(3L);
        owner3.setFirstName("Karol");
        owner3.setLastName("Mikulski");

        ownerService.save(owner3);

        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setId(3L);
        vet3.setFirstName("Jymmy");
        vet3.setLastName("Camell");

        vetService.save(vet3);

        System.out.println("Loading Vets........");


    }
}
