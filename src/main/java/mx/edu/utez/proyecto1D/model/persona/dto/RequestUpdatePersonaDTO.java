package mx.edu.utez.proyecto1D.model.persona.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdatePersonaDTO {

@NotBlank(message = "El nombre es obligatorio")
    private String nombres;
@NotBlank(message = "El primer Apellido es obligatorio")
    private String primerApellido;
    private String segundoApellido;
@Email(message = "El correo no tiene un formato valido")
    private String correo;
    @NotBlank(message = "mete tu curp")
    @Pattern(
            regexp = "^[A-Z][AEIOUX][A-Z]{2}\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])[HM][A-Z]{2}[B-DF-HJ-NP-TV-Z]{3}[A-Z0-9]\\d$",
            message = "La CURP no tiene un formato válido"
    )
    private String curp;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
}
