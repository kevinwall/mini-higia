package br.jus.jfrn.minihigia.service;

import br.jus.jfrn.minihigia.model.Usuario;
import br.jus.jfrn.minihigia.repository.UsuarioRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService implements UserDetailsService
{
    private UsuarioRepository usuarioRepository;

    public LoginService(UsuarioRepository usuarioRepository)
    {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<Usuario> optional = usuarioRepository.findUsuarioByUsername(username);

        if(optional.isPresent())
        {
            return new org.springframework.security.core.userdetails.User(optional.get().getUsername(),
                    encoder().encode(optional.get().getPassword()),
                    Collections.singletonList(new SimpleGrantedAuthority(optional.get().getRole())));
        }

        throw new UsernameNotFoundException("User not found");
    }

    public PasswordEncoder encoder()
    {
        return new BCryptPasswordEncoder();
    }

    public Usuario insertUsuario(Usuario usuario)
    {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario)
    {
        return usuarioRepository.saveAndFlush(usuario);
    }

    public void deleteUsuario(Usuario usuario)
    {
        usuarioRepository.delete(usuario);
    }


    public void deleteUsuarioById(long id)
    {
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> listAllUsuarios()
    {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> listUsuarioById(long id)
    {
        return usuarioRepository.findById(id);
    }
}
