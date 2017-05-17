package appDice.jsp.bussines.AuthenticationSuccessHandler;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import appDice.jsp.bussines.UserService;
import appDice.jsp.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    
    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        String principal = SecurityContextHolder.getContext().getAuthentication().getName();
        if (userService.findByEmail(principal) != null) {
           Date date = new Date();
           User user = userService.findByEmail(principal);
           user.setActive(true);
           user.setLastSessionStart(date);
          
           userService.create(user);
        }
        httpServletResponse.sendRedirect("/");
    }

}