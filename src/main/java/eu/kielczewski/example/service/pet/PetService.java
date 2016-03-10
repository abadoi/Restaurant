package eu.kielczewski.example.service.pet;

import eu.kielczewski.example.domain.Pet;
import eu.kielczewski.example.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by andreibadoi on 09/03/16.
 */
public interface PetService {
    User whosPet (Pet pet);

    Pet createPet (String name, User owner, String type);

    List<Pet> findAllPetsOf (User user);
}
