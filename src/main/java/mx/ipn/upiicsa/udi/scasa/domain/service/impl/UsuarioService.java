package mx.ipn.upiicsa.udi.scasa.domain.service.impl;

import lombok.extern.slf4j.Slf4j;
import mx.ipn.upiicsa.udi.scasa.domain.model.CatalogoNvlsRoles;
import mx.ipn.upiicsa.udi.scasa.domain.model.CtrlUsuarios;
import mx.ipn.upiicsa.udi.scasa.infrastructure.repository.ICtlgUsuariosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UsuarioService implements UserDetailsService {

    @Autowired
    private ICtlgUsuariosDao iCtlgUsuariosDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CtrlUsuarios usuario = iCtlgUsuariosDao.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not present"));

        return User.withUsername(usuario.getCcveusu())
                .password(usuario.getCpasswr())
                .authorities(getAuthorities(usuario))
                .build();
    }

    private Collection<GrantedAuthority> getAuthorities(CtrlUsuarios user) {
        return user.getAuthorities()
                .stream()
                .map(CatalogoNvlsRoles::getDesctipnvl)
                .map(this::addGrantedAuthority)
                .collect(Collectors.toList());
    }

    private GrantedAuthority addGrantedAuthority(String authority) {
        return new SimpleGrantedAuthority(authority);
    }
}
