package com.dagabienkowska.documentmanager;

import com.dagabienkowska.documentmanager.models.User;
import com.dagabienkowska.documentmanager.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    private final UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");

        if(user.getUsername().length() < 5 || user.getUsername().length() > 20){
            errors.rejectValue("username", "Size.userForm.username");
        }

        if (userService.findByUsername(user.getUsername()) != null){
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");

        if (user.getPassword().length() < 8 || user.getPassword().length() > 20){
            errors.rejectValue("password", "Size.userForm.password");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");

        if (user.getName().length() < 3 || user.getName().length() > 25){
            errors.rejectValue("name", "Size.userForm.name");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "NotEmpty");

        if (user.getSurname().length() < 3 || user.getSurname().length() > 50){
            errors.rejectValue("surname", "Size.userForm.surname");
        }
    }
}
