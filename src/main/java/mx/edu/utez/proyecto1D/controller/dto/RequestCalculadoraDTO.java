package mx.edu.utez.proyecto1D.controller.dto;
//librerias para evitar escribir get y setter

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCalculadoraDTO {
    private int num1;
    private int num2;
    //Validaciones

    @NotBlank(message = "La operacion es obligatorias")
    private String operacion;

}

