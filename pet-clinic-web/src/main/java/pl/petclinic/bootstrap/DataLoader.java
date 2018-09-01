package pl.petclinic.bootstrap;

import pl.petclinic.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.petclinic.services.OwnerService;
import pl.petclinic.services.PetTypeService;
import pl.petclinic.services.SpecialtyService;
import pl.petclinic.services.VetService;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType bird = new PetType();
        bird.setName("Bird");
        PetType savedBirdPetType = petTypeService.save(bird);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Chris");
        owner1.setLastName("Kowalski");
        owner1.setAddress("Mokra 12");
        owner1.setCity("Gdynia");
        owner1.setTelephone("12212121212");

        Pet chrisPet = new Pet();
        chrisPet.setPetType(savedDogPetType);
        chrisPet.setOwner(owner1);
        chrisPet.setBirthDate(LocalDate.now());
        chrisPet.setName("Szarik");
        owner1.getPets().add(chrisPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Filip");
        owner2.setLastName("Chajzer");
        owner2.setAddress("Wydmowa 33");
        owner2.setCity("Gdansk");
        owner2.setTelephone("343434343434");

        Pet filipCat = new Pet();
        filipCat.setName("Rudy");
        filipCat.setOwner(owner2);
        filipCat.setPetType(savedCatPetType);
        filipCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(filipCat);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Karol");
        owner3.setLastName("Mikulski");
        owner3.setAddress("Niepodleglosci 99");
        owner3.setCity("Sopot");
        owner3.setTelephone("90909090909");

        Pet karolBird = new Pet();
        karolBird.setName("Ara");
        karolBird.setOwner(owner3);
        karolBird.setPetType(savedBirdPetType);
        karolBird.setBirthDate(LocalDate.now());
        owner3.getPets().add(karolBird);

        ownerService.save(owner3);

        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Jymmy");
        vet3.setLastName("Camell");
        vet3.getSpecialties().add(savedDentistry);

        vetService.save(vet3);

        System.out.println("Loading Vets........");
    }
}
