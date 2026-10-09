package mx.edu.utez.proyecto1D.service.usuario;

import mx.edu.utez.proyecto1D.model.usuario.Usuario;
import mx.edu.utez.proyecto1D.repository.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//Todo los servicios que tenga,os de la entidad Usuario

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    //Declarar un contructor

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    //Metodo para los usuarios /Servicios
    public List<Usuario> getALLusers(){
        return usuarioRepository.findAll();
    }
    //Controlador pra mandar por URL


}
