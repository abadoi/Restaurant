package eu.kielczewski.example.domain.validator;

import eu.kielczewski.example.domain.PetCreateForm;
import eu.kielczewski.example.domain.UserCreateForm;
import eu.kielczewski.example.service.pet.PetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * Created by Danut on 3/10/2016.
 */


@Component
public class PetCreateFormValidator implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(PetCreateFormValidator.class);
    private final PetService petService;

    @Autowired
    public PetCreateFormValidator(PetService petService) {
        this.petService = petService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(PetCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("Validating {}", target);
        PetCreateForm form = (PetCreateForm) target;
    }

}
