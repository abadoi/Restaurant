package eu.kielczewski.example.repository;

import eu.kielczewski.example.domain.Pet;
import eu.kielczewski.example.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by andreibadoi on 09/03/16.
 */
public interface PetRepository extends CrudRepository<Pet, Long> {
    List<Pet> findByOwner (User user);
    Pet findOneByName (String name);
}
