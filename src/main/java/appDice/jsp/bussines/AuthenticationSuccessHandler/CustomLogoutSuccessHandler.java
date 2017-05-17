package appDice.jsp.bussines.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import appDice.jsp.bussines.UserService;
import appDice.jsp.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;



@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	@Autowired
	private UserService userService;
	
	@Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Authentication authentication) throws IOException, ServletException {
		
        if (authentication != null && authentication.getDetails() != null) {
            try {
                 User user = userService.findByEmail(authentication.getName());
                 user.setActive(false);
              
                 userService.create(user);
            	

            } catch (Exception e) {
           	
                e.printStackTrace();
            }
        }
 
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.sendRedirect("/login");
    }
}
