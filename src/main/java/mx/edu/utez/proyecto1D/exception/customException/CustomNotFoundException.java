package mx.edu.utez.proyecto1D.exception.customException;

public class CustomNotFoundException extends RuntimeException {
    public CustomNotFoundException(String  mensaje) {
        super(mensaje); //para mandar el error
    }
}
