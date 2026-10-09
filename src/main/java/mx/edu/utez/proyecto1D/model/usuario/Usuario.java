package mx.edu.utez.proyecto1D.model.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.proyecto1D.model.cursos.Curso;
import mx.edu.utez.proyecto1D.model.persona.Persona;

import java.util.List;

//para decir que esta clase es una entidad escribir la anotacion de entidad
@Entity
@Table(name = "usuarios") //para establecer el nombre de la tabla
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Id //Se ira generando secuencialmente estos tres
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para que se genere automaticamente
    private Long id;

    @Column(name = "username1", nullable = false, unique = true)
    private String username;

    private String password;

    private boolean isEnable;

    @Column(columnDefinition = "TEXT")//DECLARA QUE ES UN TEXTO Y MAYOR ESPACIO
    private String descripcion;

    // @Transient //PARA QUE NO LO TOME COMO UNA COLUMNA
    // private String atributoNoColumna;

    //el indice de la lista y la cadena de texto : puede guardar el E de roles
    //Guardar la cadena
    @Enumerated(EnumType.STRING)
    private Roles rol;

    //Escribir la notacion para crear una relacion
    @OneToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
/*
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id"),
            name = "personas_cursos"
    )
    private List<Curso> cursos;*/
}

