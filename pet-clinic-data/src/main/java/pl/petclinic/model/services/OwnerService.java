package pl.petclinic.model.services;

import pl.petclinic.model.Owner;



public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
