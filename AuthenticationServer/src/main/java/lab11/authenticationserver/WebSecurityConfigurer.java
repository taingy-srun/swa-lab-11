package lab11.authenticationserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("john").password("{noop}password1").roles("CUSTOMER")
                .and()
                .withUser("frank").password("{noop}password2").roles("EMPLOYEE", "MANAGER")
                .and()
                .withUser("tota").password("{noop}password3").roles("CUSTOMER", "EMPLOYEE", "MANAGER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/product").permitAll()
                .antMatchers("/salary").hasAnyRole("MANAGER")
                .antMatchers("/contact").hasAnyRole("EMPLOYEE", "MANAGER")
                .and()
                .httpBasic();
    }
}