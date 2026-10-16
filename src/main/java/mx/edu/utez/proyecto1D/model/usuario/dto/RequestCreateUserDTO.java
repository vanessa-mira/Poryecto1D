package mx.edu.utez.proyecto1D.model.usuario.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

//Areegamos las anotaciones ||| para los datos de entrada
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateUserDTO { //Esta clase es para las petiicones del usuario
    //Definir todos los atributos que necesito de mi usuario

    @NotBlank(message = "El username es obligatorio") //es pra el mensaje
    @Size(min= 6, max =20, message = "El username debe contener entre 6 y 20 caracteres") //para las restricciones
    private String username;

    @NotBlank(message = "El password es obligatorio :) ")
    @Pattern( //Para validar
            regexp = "^(?=.*[A-Z])(?=.*\\d).{8,}$",
            message = "La contraseña debe tener al menos 8 caracteres, una mayúscula y un número"
    )
    private String password;

    private String descripcion;

    @NotBlank(message = "El rol es obligatorio")
    @Pattern(
            regexp = "^(ADMIN|PROFESOR|ESTUDIANTE)$",
            message = "El rol debe ser ADMIN, PROFESOR o ESTUDIANTE"
    )
    private String rol;

    //DATOS DE LA PERSONA
    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private String correo;
    private String curp;

    //Notacion para indicar en que formato vamos a recibir el dato
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;



}
