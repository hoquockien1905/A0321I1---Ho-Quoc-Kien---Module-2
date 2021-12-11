package com.example.demo.validator;

import com.example.demo.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (user.getFirstName().isEmpty()) {
            errors.rejectValue("firstName", "firstName.notEmpty", new String[]{}, "a" );
        }
    }
}
