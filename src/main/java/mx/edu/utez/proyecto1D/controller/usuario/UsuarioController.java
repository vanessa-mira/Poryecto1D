package mx.edu.utez.proyecto1D.controller.usuario;


import jakarta.validation.Valid;
import mx.edu.utez.proyecto1D.model.usuario.Usuario;
import mx.edu.utez.proyecto1D.model.usuario.dto.RequestCreateUserDTO;
import mx.edu.utez.proyecto1D.service.usuario.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mx.edu.utez.proyecto1D.model.usuario.dto.RequestUpdateUserDTO;
import mx.edu.utez.proyecto1D.model.usuario.dto.ResponseUsuarioDTO;

import java.util.List;

//Anotaciones para identificar un controller
@RestController
@RequestMapping("/usuario")
@CrossOrigin({"*"})

public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping //para la consulta Revisiveindo la peticion
    public ResponseEntity<List<Usuario>> getAllUsers() {
        //PARA MANDARLO A LLAMAR
        return ResponseEntity
                .status(200)
                .body(usuarioService.getALLusers()
                );
    }
    //Creacion de un recurso
    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody @Valid RequestCreateUserDTO payload){
        return ResponseEntity.status(201).body(
                usuarioService.createUser(payload)
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseUsuarioDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(usuarioService.getUserById(id));
    }


    @PatchMapping("/{id}/activar")
    public ResponseEntity<ResponseUsuarioDTO> activarUsuario(@PathVariable Long id) {
        return ResponseEntity.status(200).body(usuarioService.cambiarEstado(id, true));
    }


    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<ResponseUsuarioDTO> desactivarUsuario(@PathVariable Long id) {
        return ResponseEntity.status(200).body(usuarioService.cambiarEstado(id, false));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ResponseUsuarioDTO> updateUser(@PathVariable Long id,
                                                         @RequestBody @Valid RequestUpdateUserDTO payload) {
        return ResponseEntity.status(200).body(usuarioService.updateUser(id, payload));
    }


}
