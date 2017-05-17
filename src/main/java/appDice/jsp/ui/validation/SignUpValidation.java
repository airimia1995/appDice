package appDice.jsp.ui.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import appDice.jsp.bussines.UserService;

import appDice.jsp.model.User;


@Component("signUpValidation")
public class SignUpValidation {
	
	@Autowired
	UserService userService;

	 public boolean supports(Class<?> klass) {
		    return User.class.isAssignableFrom(klass);
		  }

	public void validate(Object target, Errors errors) {
		    User registration = (User) target;
		    
		    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
		        "NotEmpty.registration.firstName",
		        "User First Name must not be Empty.");
		    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
			        "NotEmpty.registration.lastName",
			        "User Last Name must not be Empty.");
		    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
			        "NotEmpty.registration.email",
			        "User email must not be Empty.");
		    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
			        "NotEmpty.registration.password",
			        "User password must not be Empty.");
		   
		    
		    
		    if (userService.findByEmail(registration.getEmail())!=null) {
		      errors.rejectValue("email",
		          "matchingEmail.registration.email",
		          "The email is already in use");
		    }
		  }
}
