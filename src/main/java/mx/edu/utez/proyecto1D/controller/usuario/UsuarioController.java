package mx.edu.utez.proyecto1D.controller.usuario;


import mx.edu.utez.proyecto1D.model.usuario.Usuario;
import mx.edu.utez.proyecto1D.service.usuario.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping //para la consulta
    public ResponseEntity<List<Usuario>> getAllUsers() {
        //PARA MANDARLO A LLAMAR
        return ResponseEntity
                .status(200)
                .body(usuarioService.getALLusers()
                );
    }


}
