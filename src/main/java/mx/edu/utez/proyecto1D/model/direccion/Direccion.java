package mx.edu.utez.proyecto1D.model.direccion;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.proyecto1D.model.persona.Persona;

@Entity
@Table(name="Direcciones")

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //atributos
    private String calle;
    private int noExterior;
    private String colonia;
    private String municipio;
    private String estado;
    private String codigoPostal;

    //Declarar la relacion
    @ManyToOne //por que direccion es la que tiene la conecion de muchos hacia una persona
    @JoinColumn(name ="persona_id") //perosnalizar el campo de la foreing Key
    //ATributo de la entidad que nos vamos a relacionar
    private Persona persona;
}
