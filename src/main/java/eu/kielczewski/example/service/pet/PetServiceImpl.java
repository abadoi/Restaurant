package eu.kielczewski.example.service.pet;

import eu.kielczewski.example.domain.CurrentUser;
import eu.kielczewski.example.domain.Pet;
import eu.kielczewski.example.domain.PetCreateForm;
import eu.kielczewski.example.domain.User;
import eu.kielczewski.example.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
    public User getOwner(Pet pet)
    {
        return pet.getOwner();
    }

    @Override
    public Pet createPet(String name, String type, User owner) {
        Pet pet = new Pet();
        pet.setName(name);
        pet.setType(type);
        pet.setOwner(owner);
        return petRepository.save(pet);
    }

    @Override
    public Pet createPet(PetCreateForm form, Authentication authentication) {
        Pet pet = new Pet();
        pet.setName(form.getName());
        pet.setType(form.getType());
        User user = ((CurrentUser)authentication.getPrincipal()).getUser();
        pet.setOwner(user);
        return petRepository.save(pet);
    }


}
