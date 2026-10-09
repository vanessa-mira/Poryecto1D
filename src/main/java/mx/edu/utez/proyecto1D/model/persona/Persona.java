package mx.edu.utez.proyecto1D.model.persona;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity //decimos que es una entidad
@Table(name="Personas") //no,bre de la tabla

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Persona { //da error por que necesitaba un identificador

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY) //es una configuracion de autocrementable (IDENTITY)
    private Long id;
      //Declaramos las varianbles a utilizar y su tipo
    private String nombre;
    private String primerApellido;
    private String segundoApellido;

    private LocalDate fechaNacimiento; //(LocalDate ->Almacena dia mes y año

    private String curp;
    private String correo;


}
