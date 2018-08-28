package pl.petclinic.services.map;

import pl.petclinic.model.Owner;
import org.springframework.stereotype.Service;
import pl.petclinic.services.OwnerService;
import pl.petclinic.services.PetService;
import pl.petclinic.services.PetTypeService;

import java.util.Set;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if (object != null){
            if (object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null){

                    }else {
                        throw new RuntimeException("Pet Type is required");
                    }
                });
            }

            return super.save(object);
        }else {
            return  null;
        }
    }


    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
