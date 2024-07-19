package inz;

//tag::securityConfigOuterClass[]

import org.springframework.context.annotation.Bean;
//end::securityConfigOuterClass[]
//tag::baseBonesImports[]
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web
                      .configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web
                      .configuration.WebSecurityConfigurerAdapter;
//end::baseBonesImports[]

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation
           .authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web
           .builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

//tag::securityConfigOuterClass[]

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

@Autowired
private UserDetailsService userDetailsService;

@Override
protected void configure(HttpSecurity http) throws Exception {
  http
    .authorizeRequests()
      .antMatchers("/calendar", "/seats", "/reservationMenu", "/reservationBrowse")
        .access("hasRole('ROLE_USER')")
      .antMatchers("/calendarAdmin")
      	.access("hasRole('ROLE_ADMIN')")
      .antMatchers("/").access("permitAll")
    .and()
      .formLogin()
        .loginPage("/login")
    .and()
      .logout()
        .logoutSuccessUrl("/")
    ;
}

@Bean
public PasswordEncoder encoder() {
  return new StandardPasswordEncoder("mv14dw8g");
}

@Override
protected void configure(AuthenticationManagerBuilder auth)
    throws Exception {
  auth
    .userDetailsService(userDetailsService)
    .passwordEncoder(encoder());
}

}
//end::securityConfigOuterClass[]