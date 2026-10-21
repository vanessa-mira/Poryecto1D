package mx.edu.utez.proyecto1D.model.usuario.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor //AGRREGAMOS LAS NOTACIONES PRA LOS DATOS DE ENTRADA
@AllArgsConstructor
public class RequestUpdateUserDTO {
    @NotBlank(message = "El username es obligatorio") //es pra el mensaje
    @Size(min= 6, max =20, message = "El username debe contener entre 6 y 20 caracteres") //para las restricciones
    private String username;

    private String descripcion;

}
