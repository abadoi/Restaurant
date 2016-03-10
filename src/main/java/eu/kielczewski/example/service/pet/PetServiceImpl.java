package eu.kielczewski.example.service.pet;

import eu.kielczewski.example.domain.Pet;
import eu.kielczewski.example.domain.User;
import eu.kielczewski.example.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by andreibadoi on 09/03/16.
 */
@Service
public class PetServiceImpl implements PetService {


    private final PetRepository petRepository;
    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public User whosPet(Pet pet) {
        return pet.getOwner();
    }

    @Override
    public Pet createPet(String name, User owner, String type) {
        Pet pet = new Pet(name,type,owner);
        petRepository.save(pet);
        return pet;
    }

    @Override
    public List<Pet> findAllPetsOf(User user) {
        return petRepository.findByOwner(user);

    }


}
