package mx.edu.utez.proyecto1D.model.usuario;

import jakarta.persistence.*;

//para decir que esta clase es una entidad escribir la anotacion de entidad
@Entity
@Table(name = "usuarios") //para establecer el nombre de la tabla
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
     @Transient //PARA QUE NO LO TOME COMO UNA COLUMNA
     private String atributoNoColumna;

     //el indice de la lista y la cadena de texto : puede guardar el E de roles
    //Guardar la cadena
    @Enumerated(EnumType.STRING)
    private Roles rol;

}
