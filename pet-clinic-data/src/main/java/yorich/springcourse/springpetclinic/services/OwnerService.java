package yorich.springcourse.springpetclinic.services;

import yorich.springcourse.springpetclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
