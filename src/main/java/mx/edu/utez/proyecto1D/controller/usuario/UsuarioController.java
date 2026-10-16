package mx.edu.utez.proyecto1D.controller.usuario;


import jakarta.validation.Valid;
import mx.edu.utez.proyecto1D.model.usuario.Usuario;
import mx.edu.utez.proyecto1D.model.usuario.dto.RequestCreateUserDTO;
import mx.edu.utez.proyecto1D.service.usuario.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
