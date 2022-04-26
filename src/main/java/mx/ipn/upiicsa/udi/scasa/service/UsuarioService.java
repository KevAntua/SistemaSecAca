package mx.ipn.upiicsa.udi.scasa.service;

//import java.util.ArrayList;
//import lombok.RequiredArgsConstructor;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import mx.ipn.upiicsa.udi.scasa.dao.ICtlgUsuariosDao;
import mx.ipn.upiicsa.udi.scasa.entitys.CatalogoNvlsRoles;
import mx.ipn.upiicsa.udi.scasa.entitys.CtrlUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Slf4j
public class UsuarioService implements UserDetailsService {

    @Autowired
    private ICtlgUsuariosDao iCtlgUsuariosDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CtrlUsuarios usuario = iCtlgUsuariosDao.findByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }

        var roles = new ArrayList<GrantedAuthority>();

        for (CatalogoNvlsRoles nombreRol : usuario.getRoles()) {

            roles.add(new SimpleGrantedAuthority(nombreRol.getDesctipnvl()));

        }
        return new User(usuario.getCcveusu(), usuario.getCpasswr(), roles);
    }

    /*@Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CtrlUsuarios usuario = iCtlgUsuariosDao.findByUsername(username);
        return new CtrlUsuarios (usuario);
    }*/
}
