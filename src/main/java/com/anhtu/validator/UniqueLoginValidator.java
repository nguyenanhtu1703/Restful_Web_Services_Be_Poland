package com.anhtu.validator;

import com.anhtu.repository.UserRepository;
import com.anhtu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !UserService.isUsernameAlreadyInUse(value);
    }
}



