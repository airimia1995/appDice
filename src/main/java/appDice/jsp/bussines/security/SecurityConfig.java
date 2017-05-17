package appDice.jsp.bussines.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.bind.annotation.RestController;

import appDice.jsp.bussines.AuthenticationSuccessHandler.CustomAuthenticationSuccessHandler;
import appDice.jsp.bussines.AuthenticationSuccessHandler.CustomLogoutSuccessHandler;


@Configuration
@EnableWebSecurity
@RestController
@ComponentScan(basePackageClasses = SecurityService.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

	  private static final Log log = LogFactory.getLog(SecurityConfig.class);

	    @Autowired
	    private SecurityService securityService;

	    @Autowired
	    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(securityService).passwordEncoder(passwordEncoder());
	    }


	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    @Bean
	    public SessionListener sessionListener(){
	    	return new SessionListener();
	    }
	    
	    @Autowired
	    private CustomAuthenticationSuccessHandler authenticationSuccessHandler;
	    
	    @Autowired
	    private CustomLogoutSuccessHandler logoutSuccessHandler;

	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.httpBasic().and()
	                .authorizeRequests()
	                .antMatchers("login").permitAll()
	                .antMatchers("/").authenticated()
	                .and()
	                .formLogin().loginPage("/login").successHandler(authenticationSuccessHandler)
	                .usernameParameter("emailLOG").passwordParameter("passwordLOG")
	                .failureUrl("/login?error")
	                .and()
	                .exceptionHandling().accessDeniedPage("/login")
	                .authenticationEntryPoint(new AuthenticationEntryPoint() {
						
						@Override
						public void commence(HttpServletRequest arg0, HttpServletResponse arg1, AuthenticationException arg2)
								throws IOException, ServletException {
							arg1.sendRedirect("/login");
							
						}
					})
	                .and()
	                .sessionManagement().sessionAuthenticationErrorUrl("/login")
	                .and()
	                .logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler)
	                .and().csrf().disable();
	    }
	    

}
