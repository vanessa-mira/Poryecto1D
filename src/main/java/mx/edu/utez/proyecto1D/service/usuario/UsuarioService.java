package mx.edu.utez.proyecto1D.service.usuario;

import mx.edu.utez.proyecto1D.exception.customException.CustomBadRequestException;
import mx.edu.utez.proyecto1D.model.persona.Persona;
import mx.edu.utez.proyecto1D.model.usuario.Roles;
import mx.edu.utez.proyecto1D.model.usuario.Usuario;
import mx.edu.utez.proyecto1D.repository.persona.PersonaRepository;
import mx.edu.utez.proyecto1D.repository.usuario.UsuarioRepository;
import mx.edu.utez.proyecto1D.model.usuario.dto.RequestCreateUserDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.edu.utez.proyecto1D.exception.customException.CustomNotFoundException;
import mx.edu.utez.proyecto1D.model.usuario.dto.RequestUpdateUserDTO;
import mx.edu.utez.proyecto1D.model.usuario.dto.ResponseUsuarioDTO;


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
@Transactional
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
         //parciar




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
    private Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new CustomNotFoundException("El usuario con id " + id + " no existe"));
    }


    private ResponseUsuarioDTO convertir(Usuario usuario) {
        return new ResponseUsuarioDTO(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getDescripcion(),
                usuario.isEnable(),
                usuario.getRol(),
                usuario.getPersona()
        );
    }
    @Transactional(readOnly = true)
    public ResponseUsuarioDTO getUserById(Long id) {
        return convertir(buscarUsuario(id));
    }


    @Transactional
    public ResponseUsuarioDTO cambiarEstado(Long id, boolean enable) {
        Usuario usuario = buscarUsuario(id);
        if (usuario.isEnable() == enable) {
            throw new CustomBadRequestException(
                    enable ? "El usuario ya esta activo" : "El usuario ya esta desactivado");
        }
        usuario.setEnable(enable);
        return convertir(usuarioRepository.save(usuario));
    }


    @Transactional
    public ResponseUsuarioDTO updateUser(Long id, RequestUpdateUserDTO payload) {
        Usuario usuario = buscarUsuario(id);


        usuarioRepository.findByUsername(payload.getUsername()).ifPresent(otro -> {
            if (!otro.getId().equals(id)) {
                throw new CustomBadRequestException("El username ya esta en uso");
            }
        });


        usuario.setUsername(payload.getUsername());
        usuario.setDescripcion(payload.getDescripcion());
        return convertir(usuarioRepository.save(usuario));
    }

}

