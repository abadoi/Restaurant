package eu.kielczewski.example.controller;

import eu.kielczewski.example.domain.CurrentUser;
import eu.kielczewski.example.domain.User;
import eu.kielczewski.example.domain.validator.UserCreateFormValidator;
import eu.kielczewski.example.service.pet.PetService;
import eu.kielczewski.example.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by andreibadoi on 09/03/16.
 */

@Controller
public class PetsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

    private final PetService petService ;

    @Autowired
    public PetsController(PetService petService) {
        this.petService = petService;
    }

    @RequestMapping("/mypets")
    public ModelAndView getAllPets(Authentication authentication) {

        User user = ((CurrentUser)authentication.getPrincipal()).getUser();
        LOGGER.debug("Getting pets");
        return new ModelAndView("mypets", "pets", petService.findAllPetsOf(user));

    }

}
