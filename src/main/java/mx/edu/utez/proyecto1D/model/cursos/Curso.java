package mx.edu.utez.proyecto1D.model.cursos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Curso")

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nombre;
    private int noUnidades;
    private String estatus;

}
