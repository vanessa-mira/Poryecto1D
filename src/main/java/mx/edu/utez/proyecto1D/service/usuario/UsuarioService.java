package mx.edu.utez.proyecto1D.service.usuario;

import mx.edu.utez.proyecto1D.exception.customException.CustomBadRequestException;
import mx.edu.utez.proyecto1D.model.persona.Persona;
import mx.edu.utez.proyecto1D.model.usuario.Roles;
import mx.edu.utez.proyecto1D.model.usuario.Usuario;
import mx.edu.utez.proyecto1D.repository.persona.PersonaRepository;
import mx.edu.utez.proyecto1D.repository.usuario.UsuarioRepository;
import mx.edu.utez.proyecto1D.model.usuario.dto.RequestCreateUserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

//Todo los servicios que tenga,os de la entidad Usuario

@Service
public class UsuarioService {
    //inyeccion de dependencias
    private final UsuarioRepository usuarioRepository;
    private final PersonaRepository personaRepository;

    //Declarar un contructor
//servicios
    public UsuarioService(UsuarioRepository usuarioRepository, PersonaRepository personaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.personaRepository = personaRepository;
    }
    //Metodo para los usuarios /Servicios

    public List<Usuario> getALLusers(){

        return usuarioRepository.findAll();
    }

    //Controlador pra mandar por URL

    public Usuario createUser(RequestCreateUserDTO payload){
        if(usuarioRepository.findByUsername(payload.getUsername()).isPresent()){
            throw new CustomBadRequestException("El username ya esta en uso");
        }
        //Vamos a crear una instancia de persona
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre(payload.getNombres());
        nuevaPersona.setPrimerApellido(payload.getPrimerApellido());
        nuevaPersona.setSegundoApellido(payload.getSegundoApellido());
        nuevaPersona.setCorreo(payload.getCorreo());
        nuevaPersona.setCurp(payload.getCurp());
        nuevaPersona.setFechaNacimiento(payload.getFechaNacimiento());

        nuevaPersona= personaRepository.save(nuevaPersona);



        //Entidad de usuario armada
        Usuario nuevoUsuario= new Usuario();
        nuevoUsuario.setUsername(payload.getUsername());
        nuevoUsuario.setPassword(payload.getPassword());
        nuevoUsuario.setDescripcion(payload.getDescripcion());
        nuevoUsuario.setEnable(true);
        nuevoUsuario.setRol(
                Roles.valueOf(payload.getRol())
        );
        nuevoUsuario.setPersona(nuevaPersona);
        return usuarioRepository.save(nuevoUsuario);
    }

}

