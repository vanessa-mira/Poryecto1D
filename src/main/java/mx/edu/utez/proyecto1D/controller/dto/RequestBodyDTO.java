package mx.edu.utez.proyecto1D.controller.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class RequestBodyDTO {
    @NotBlank(message = "escribet tu nombre")
    @Size(min = 3, message = "tiene q tener al menos tres letras")
    private String nombre;

    @Min(value = 18, message = "eres menor de edad :////")
    private int edad;
    @NotBlank(message = "el correo es obligatorio")
    @Email(message = "el correo no es asi")
    private String correo;

    @NotBlank(message = "mete tu curp")
    @Pattern(
            regexp = "^[A-Z][AEIOUX][A-Z]{2}\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])[HM][A-Z]{2}[B-DF-HJ-NP-TV-Z]{3}[A-Z0-9]\\d$",
            message = "La CURP no tiene un formato válido"
    )
    private String curp;

}