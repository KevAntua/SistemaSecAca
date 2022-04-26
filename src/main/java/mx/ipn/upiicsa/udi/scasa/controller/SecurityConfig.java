package mx.ipn.upiicsa.udi.scasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{ //Concepto de autenticacion con bd
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }*/
    
    @Override
    public void configure(AuthenticationManagerBuilder build) throws Exception{ //Concepto de autenticacion con bd
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    /*@Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception{ //Concepto de autenticacion hardcodec
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}123")
                .roles("Master","APrincipal","ASecundario")
            .and()
                .withUser("user")
                .password("{noop}123")
                .roles("Usuario","Pendiente")
            ;    
    }*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {  //Concepto de autorizacion
        http.authorizeRequests()
                .antMatchers("/","/Areas/**","/AgregarArticulo","/GuardarArticulo","/EliminarArticulo")
                .hasAnyRole("Master", "APrincipal", "ASecundario") //Javier Edgrdo , SA49MVJ2021
                .antMatchers("/", "/Articulos")
                .hasAnyRole("Usuario", "Pendiente")
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403");
    }
}
