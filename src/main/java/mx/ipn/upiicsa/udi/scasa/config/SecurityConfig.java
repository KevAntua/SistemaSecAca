package mx.ipn.upiicsa.udi.scasa.config;

import mx.ipn.upiicsa.udi.scasa.domain.service.impl.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception { // Concepto de autorizacion
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").hasAnyAuthority("ROLE_Usuario", "ROLE_Pendiente", "ROLE_Master", "ROLE_APrincipal", "ROLE_ASecundario")
                .antMatchers("/Articulos", "/Medidas", "/Entradas", "/DetallesEntradas").hasAnyAuthority("ROLE_Usuario", "ROLE_Pendiente")
                .antMatchers("/Areas/**", "/AgregarArticulo", "/GuardarArticulo", "/EliminarArticulo", "/AgregarMedida", "/GuardarMedida", "/EliminarMedida", "/AgregarEntradaAlmacen", "/GuardarEntrada", "/EliminarEntrada", "/AgregarDtllsEntrd", "/GuardarDtllsEntrd", "/EliminarDtllsEntrd").hasAnyAuthority("ROLE_Master", "ROLE_APrincipal", "ROLE_ASecundario") // Javier Edgrdo , SA49MVJ2021
                .and()
                .formLogin().loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403");
    }
}
