package eu.kielczewski.example.controller;


import eu.kielczewski.example.domain.User;
import eu.kielczewski.example.domain.CurrentUser;
import eu.kielczewski.example.domain.PetCreateForm;
import eu.kielczewski.example.domain.validator.PetCreateFormValidator;
import eu.kielczewski.example.service.pet.PetService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


/**
 * Created by Danut on 3/10/2016.
 */

@Controller
public class PetController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PetController.class);
    private final PetService petService;
    private final PetCreateFormValidator petCreateFormValidator;

    @Autowired
    public PetController(PetService petService,PetCreateFormValidator petCreateFormValidator) {
        this.petService = petService;
        this.petCreateFormValidator = petCreateFormValidator;
    }
    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(petCreateFormValidator);
    }

    @RequestMapping(value = "/add/pets", method = RequestMethod.GET)
    public ModelAndView getPetCreatePage() {
        LOGGER.debug("Getting pet create form");
        return new ModelAndView("add_pets", "form", new PetCreateForm());
    }


    @RequestMapping(value = "/add/pets", method = RequestMethod.POST)
    public String handlePetCreateForm(Authentication authentication, @Valid @ModelAttribute("form") PetCreateForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing pet create form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()) {
            // failed validation
            return "add_pets";
        }
        try {

            User user = ((CurrentUser) authentication.getPrincipal()).getUser();
            petService.createPet(form.getName(), form.getType(), user);

        } catch (DataIntegrityViolationException e) {
            return "home";
        }
        // ok, redirect
        return "redirect:/";
    }
}