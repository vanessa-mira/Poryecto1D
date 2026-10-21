package mx.edu.utez.proyecto1D.model.usuario.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.proyecto1D.model.persona.Persona;
import mx.edu.utez.proyecto1D.model.usuario.Roles;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUsuarioDTO {
    private Long id;
    private String username;
    private String descripcion;
    private boolean enable;
    private Roles rol;
    private Persona persona;

}
