package appDice.jsp.ui;

import java.net.MalformedURLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import appDice.jsp.bussines.UserService;
import appDice.jsp.model.User;
import appDice.jsp.ui.validation.SignUpValidation;

@Controller
public class SignUpController {

	@Autowired
    private UserService userService;
	@Autowired
	private SignUpValidation signUpValidation;
	
	@RequestMapping("/signup")
	public String signUp(ModelMap model) {
		User user = new User();
		model.put("user", user);
	        return "userSignUp";
	}
	 
	 
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signedUp( @Valid User user, BindingResult result
                           ) throws MalformedURLException {
      
    	signUpValidation.validate(user, result);
		if (result.hasErrors()) {
			return "userSignUp";
		}
    	
       
        userService.save(user);
        return "redirect:login";
    }

}
