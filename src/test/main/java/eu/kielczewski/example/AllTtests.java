package eu.kielczewski.example;

import com.sun.deploy.security.MozillaMyKeyStore;
import eu.kielczewski.example.domain.Pet;
import eu.kielczewski.example.domain.User;
import eu.kielczewski.example.repository.PetRepository;
import eu.kielczewski.example.service.pet.PetService;
import eu.kielczewski.example.service.pet.PetServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Danut on 3/9/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
@ContextConfiguration


public class AllTtests {

    @Autowired
    private PetService petService;

    @Autowired
    private PetRepository petRepository;


    @Configuration
    static class PetServiceTestContextConfiguration
    {
        @Bean
        public PetService petService()
        {
            return new PetServiceImpl();
        }
        @Bean
        public PetRepository petRepository()
        {
            return Mockito.mock(PetRepository.class);
        }
    }
    @Before
    public void setup()
    {
        Pet pet = new Pet();
        pet.setName("Danut");
        pet.setType("dog");
        pet.setOwner(new User());
        petService.createPet("Danut","dog",new User());
        Mockito.when(petRepository.findOneByName("Danut")).thenReturn(pet);
    }

    @Test
    public void testCreatePet()
    {
        Pet pet = new Pet();
        pet.setOwner(new User());
        pet.setType("dog");
        pet.setName("Danut");
        assertEquals("Danut",pet.getName());
    }
}
