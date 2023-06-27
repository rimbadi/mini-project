package id.co.indivara.jdt12.mpcarrent.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpingSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}password").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()

                //Customer
                .antMatchers(HttpMethod.GET, "/customer/").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/customer").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/customer/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/customer/**").hasRole("ADMIN")

                //Driver
                .antMatchers(HttpMethod.GET, "/driver").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/driver").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/driver/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/driver/**").hasRole("ADMIN")

                //Vehicle
                .antMatchers(HttpMethod.GET, "/vehicle").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/vehicle").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/vehicle/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/vehicle/**").hasRole("ADMIN")

                //Rent
                .antMatchers(HttpMethod.GET, "/rent").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/rent").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/rent/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/rent/**").hasRole("ADMIN")

                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}

